package de.uniba.rz.app;

import de.uniba.rz.converter.TicketConverter;
import de.uniba.rz.converter.TicketsConverter;
import de.uniba.rz.entities.*;
import de.uniba.rz.io.rpc.TicketManagementGrpc;
import de.uniba.rz.io.rpc.TicketTransferObject;
import de.uniba.rz.io.rpc.TicketsTransferObject;
import de.uniba.rz.ui.swing.SwingMainController;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GRPCTicketManagementBackend implements TicketManagementBackend {

    private ManagedChannel channel;

    private TicketManagementGrpc.TicketManagementBlockingStub syncStub;
    private TicketManagementGrpc.TicketManagementStub asyncAutoUpdateStub;
    // Object of AutoUpdateManager to receive broadcast about addition or modification
    // of tickets from server.
    AutoUpdateManager autoUpdateManager;

    AtomicInteger nextId;

    public GRPCTicketManagementBackend(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
        this.nextId = new AtomicInteger(1);
    }

    public GRPCTicketManagementBackend(ManagedChannelBuilder<?> channelBuilder){
        this.channel = channelBuilder.build();
        this.syncStub = TicketManagementGrpc.newBlockingStub(this.channel);
    }

    public void initiateGRPCAutoUpdate(SwingMainController swingController){
        this.asyncAutoUpdateStub = TicketManagementGrpc.newStub(this.channel);
        autoUpdateManager = new AutoUpdateManager(asyncAutoUpdateStub, swingController);
        autoUpdateManager.receiver();
        autoUpdateManager.sendMessage("JOIN");
    }

    @Override
    public Ticket createNewTicket(String reporter, String topic, String description, Type type, Priority priority) throws TicketException {
        TicketTransferObject ticketRequest = TicketConverter.toTicketTransferObject(
                new Ticket(nextId.getAndIncrement(),reporter,topic,description,type,priority));
        TicketTransferObject ticketResponse = null;
        try {
            ticketResponse = this.syncStub.createNewTicket(ticketRequest);
        } catch (StatusRuntimeException e) {
            System.err.println("The server is unresponsive.");
            this.triggerShutdown();
        }
        return TicketConverter.toTicket(ticketResponse);
    }

    @Override
    public List<Ticket> getAllTickets() throws TicketException {
        TicketsTransferObject ticketsResponse = null;
        try{
            ticketsResponse = this.syncStub.getAllTickets(null);
        } catch (StatusRuntimeException e) {
            System.err.println("The server is unresponsive.");
            this.triggerShutdown();
        }
        return TicketsConverter.toTickets(ticketsResponse);
    }

    @Override
    public Ticket getTicketById(int id) throws TicketException {
        TicketTransferObject ticketResponse = null;
        try {
            ticketResponse = this.syncStub.getTicketById(TicketConverter.toTicketIDTransferObject(id));
        } catch (StatusRuntimeException e) {
            System.err.println("The server is unresponsive.");
            this.triggerShutdown();
        }
        return TicketConverter.toTicket(ticketResponse);
    }

    @Override
    public Ticket acceptTicket(int id) throws TicketException {
        TicketTransferObject ticketResponse = null;
        try {
            ticketResponse = this.syncStub.updateTicket(TicketConverter.toTicketIDStatusTransferObject(id, Status.ACCEPTED));
        } catch (StatusRuntimeException e) {
            System.err.println("The server is unresponsive.");
            this.triggerShutdown();
        }
        return TicketConverter.toTicket(ticketResponse);
    }

    @Override
    public Ticket rejectTicket(int id) throws TicketException {
        TicketTransferObject ticketResponse = null;
        try {
            ticketResponse = this.syncStub.updateTicket(TicketConverter.toTicketIDStatusTransferObject(id, Status.REJECTED));
        } catch (StatusRuntimeException e) {
            System.err.println("The server is unresponsive.");
            this.triggerShutdown();
        }
        return TicketConverter.toTicket(ticketResponse);
    }

    @Override
    public Ticket closeTicket(int id) throws TicketException {
        TicketTransferObject ticketResponse = null;
        try {
            ticketResponse = this.syncStub.updateTicket(TicketConverter.toTicketIDStatusTransferObject(id, Status.CLOSED));
        } catch (StatusRuntimeException e) {
            System.err.println("The server is unresponsive.");
            this.triggerShutdown();
        }
        return TicketConverter.toTicket(ticketResponse);
    }

    @Override
    public List<Ticket> getTicketsByName(String name) throws TicketException {
        TicketsTransferObject ticketsResponse = null;
        try{
            ticketsResponse = this.syncStub.getTicketsByName(TicketConverter.toTicketNameTransferObject(name));
        } catch (StatusRuntimeException e) {
            System.err.println("The server is unresponsive.");
            this.triggerShutdown();
        }
        return TicketsConverter.toTickets(ticketsResponse);
    }

    @Override
    public List<Ticket> getTicketsByNameAndType(String name, Type type) throws TicketException {
        TicketsTransferObject ticketsResponse = null;
        try{
            ticketsResponse = this.syncStub.getTicketsByNameAndType(TicketConverter.toTicketNameTypeTransferObject(name,type));
        } catch (StatusRuntimeException e) {
            System.err.println("The server is unresponsive.");
            this.triggerShutdown();
        }
        return TicketsConverter.toTickets(ticketsResponse);
    }

    @Override
    public void triggerShutdown() {
        autoUpdateManager.sendMessage("LEAVE");
    }
}
