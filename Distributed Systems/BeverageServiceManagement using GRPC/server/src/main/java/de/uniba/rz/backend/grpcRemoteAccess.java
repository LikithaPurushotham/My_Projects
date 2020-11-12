package de.uniba.rz.backend;

import com.google.protobuf.Empty;
import de.uniba.rz.converter.TicketConverter;
import de.uniba.rz.converter.TicketsConverter;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.io.rpc.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.*;
import java.util.stream.Collectors;

public class GRPCRemoteAccess implements RemoteAccess {
    private final int port;
    private final Server server;
    private static TicketStore ticketStore;
    private static Set<StreamObserver<TicketTransferObject>> clientList;

    // Creating a synchronized map that stores mutex object for ticket IDs
    // This is an attempt to implement lock by value rather than lock by object
    private static final Map<Integer, WeakReference<Object>> weakHashMap =
            Collections.synchronizedMap(new WeakHashMap<>());

    // If any other client is updating the same ticket this client is trying to update and
    // already inside the synchronized block , this method returns the locking object used in synchronized block
    // so that this method can wait.
    // If there are no other clients updating the same ticket this method creates a new Object to be used in lock
    // and saves a copy for future use.
    private static Object getMutex(Integer key) {
        return Optional.ofNullable(weakHashMap.get(key))
                .map(WeakReference::get)
                .orElseGet(() -> saveNewReference(key));
    }

    //This method saves new reference to lock object.
    private static Object saveNewReference(Integer key) {
        Object mutex = new Object();
        weakHashMap.put(key, new WeakReference<>(mutex));
        return mutex;
    }

    public GRPCRemoteAccess(String port) {
        this.port = Integer.parseInt(port);
        this.clientList = new HashSet<>();
        this.server = ServerBuilder.forPort(this.port).addService(new TicketManagementImpl()).build();
    }

    private static class TicketManagementImpl extends TicketManagementGrpc.TicketManagementImplBase{

        private TicketTransferObject getTicketById(int id) throws UnknownTicketException {
            List<Ticket> tickets = ticketStore.getAllTickets();
            Ticket requiredTicket = null;
            for(int i =0; i<tickets.size(); i++){
                if(tickets.get(i).getId()==id){
                    requiredTicket = tickets.get(i);
                    break;
                }
            };
            if(requiredTicket != null){
                 return TicketConverter.toTicketTransferObject(requiredTicket);
            }else{
                throw new UnknownTicketException("Ticket with given ID not found");
            }
        }

        @Override
        public void createNewTicket(TicketTransferObject request, StreamObserver<TicketTransferObject> responseObserver) {
            TicketTransferObject response = TicketConverter.toTicketTransferObject(
                    ticketStore.storeNewTicket(request.getReporter(), request.getTopic(), request.getDescription(),
                            de.uniba.rz.entities.Type.valueOf(request.getType().name()),
                            de.uniba.rz.entities.Priority.valueOf(request.getPriority().name())));
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            // Broadcast creation of new ticket to all clients
            clientList.stream().forEach(o -> o.onNext(response));
        }

        @Override
        public void getAllTickets(Empty request, StreamObserver<TicketsTransferObject> responseObserver) {
            TicketsTransferObject response = TicketsConverter.toTicketsTransferObject(ticketStore.getAllTickets());
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void getTicketById(TicketIDTransferObject request, StreamObserver<TicketTransferObject> responseObserver) {
            int id = TicketConverter.toTicketID(request);
            try{
                TicketTransferObject response = getTicketById(id);
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } catch (UnknownTicketException e) {
                responseObserver.onError(e);
            }
        }

        @Override
        public void updateTicket(TicketIDStatusTransferObject request, StreamObserver<TicketTransferObject> responseObserver) {
            // This is an attempt to "synchronize by value" rather than by object.
            // The idea is to allow other clients to access this block if they are not trying to update the same ticket.
            synchronized (getMutex(request.getId())){
               try{
                    ticketStore.updateTicketStatus(request.getId(), Status.valueOf(request.getStatus().name()));
                    TicketTransferObject requiredTicket = getTicketById(request.getId());
                    responseObserver.onNext(requiredTicket);
                   // Broadcast update of ticket to all clients
                    clientList.stream().forEach(o -> o.onNext(requiredTicket));
                    responseObserver.onCompleted();
                } catch (UnknownTicketException e) {
                    responseObserver.onError(e);
                }
            }
        }

        @Override
        public void getTicketsByName(TicketNameTransferObject request, StreamObserver<TicketsTransferObject> responseObserver) {
            String ticketNameToSearch = request.getName();
            List<Ticket> tickets = ticketStore.getAllTickets();
            List<Ticket> filteredTickets = new ArrayList<Ticket>();
            filteredTickets = tickets.stream().filter((Ticket t)-> t.getTopic().contains(ticketNameToSearch)).collect(Collectors.toList());
            TicketsTransferObject response = TicketsConverter.toTicketsTransferObject(filteredTickets);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void getTicketsByNameAndType(TicketNameTypeTransferObject request, StreamObserver<TicketsTransferObject> responseObserver) {
            String ticketNameToSearch = request.getName();
            Type typeToSearch = request.getType();
            List<Ticket> tickets = ticketStore.getAllTickets();
            List<Ticket> filteredTickets = new ArrayList<Ticket>();
            filteredTickets = tickets.stream().filter((Ticket t)
                    -> t.getTopic().contains(ticketNameToSearch) && t.getType().name() == typeToSearch.name())
                    .collect(Collectors.toList());
            TicketsTransferObject response = TicketsConverter.toTicketsTransferObject(filteredTickets);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<AutoUpdateMessage> autoUpdate (StreamObserver<TicketTransferObject> responseObserver){
            return new StreamObserver<AutoUpdateMessage>() {
                @Override
                public void onNext(AutoUpdateMessage value) {
                    switch (value.getMessage()) {
                        case "JOIN":
                            clientList.add(responseObserver);
                            break;
                        case "LEAVE":
                            clientList.remove(responseObserver);
                            break;
                    }
                }

                @Override
                public void onError(Throwable t) {
                    clientList.remove(responseObserver);
                }

                @Override
                public void onCompleted() {
                    clientList.remove(responseObserver);
                }
            };
        }
    }

    @Override
    public void prepareStartup(TicketStore ticketStore) {
        this.ticketStore = ticketStore;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public void run() {
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
