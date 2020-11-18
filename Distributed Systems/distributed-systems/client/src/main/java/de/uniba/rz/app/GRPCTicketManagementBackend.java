package de.uniba.rz.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import de.uniba.rz.app.converter.MessageConverter;
import de.uniba.rz.entities.Constants;
import de.uniba.rz.entities.Message;
import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.entities.Type;
import de.uniba.rz.io.rpc.MessageTransferObject;
import de.uniba.rz.io.rpc.TicketManagementServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCTicketManagementBackend implements TicketManagementBackend{
   
    // A channel is first created through which messages are sent and connection is maintained
    private ManagedChannel channel;
   
    // sync stub stands for synchronized stub or blocking stub
    // This blocks the control of the program until the server responds
    private TicketManagementServiceGrpc.TicketManagementServiceBlockingStub syncStub;
    

    // Constructor of this class
    //This instantiates a channel builder upon creating an object of this class
    public GRPCTicketManagementBackend(String host, int port) {
        
    	// calls another constructor of this class to build the channel and sync stub
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public GRPCTicketManagementBackend(ManagedChannelBuilder<?> channelBuilder) {
        this.channel = channelBuilder.build();
        this.syncStub = TicketManagementServiceGrpc.newBlockingStub(this.channel);
        
    }

  
    /*
     * This method is used to send the message
     * 
     * Note : This method also takes care of converting the object types
     * 		  gRPC sends data as objects that are auto generated as per mentioned in .proto file.
     * 		  But this program cant interpret those objects so we have to convert them. 
     */
    public Message sendMessage(Message message) {
  
    	// Converting Message object of this program to Message object of gRPC i.e MessageTransferObject
    	MessageTransferObject request = MessageConverter.convertToMessageTransferObject(message);
    	
    	// Message is sent and awaits for response
    	MessageTransferObject response = this.syncStub.send(request);
    	
    	// Converting back from MessageTransferObject to Message Object
        return MessageConverter.convertToMessage(response);
        
    }

    
    @Override
	public void triggerShutdown() {
		 if (!channel.isShutdown()) {
	            System.out.println("Trying to shut down the client . . .");
	            while (true) {
	                try {
	                    channel.shutdown().awaitTermination(10, TimeUnit.SECONDS);
	                    System.out.println("Client successfully shutdown!");
	                } catch (InterruptedException e) {
	                  // no handling of the InterruptedException needed
	                }
	                break;
	            }
	        }
	}

	@Override
	public Ticket createNewTicket(String reporter, String topic, String description, Type type, Priority priority)
			throws TicketException {

		Ticket ticket = new Ticket(0, reporter, topic, description, type, priority);
		Message message = new Message(ticket, null, Constants.STORE_TICKET);
		sendMessage(message);
		return ticket;
	
	}

	@Override
	public List<Ticket> getAllTickets() throws TicketException {
		List<Ticket> tickets = new ArrayList<>();
		Message Message = new Message(null, null, Constants.GET_ALL_TICKETS);
		Message response = sendMessage(Message);
		tickets.addAll(response.getResponse());
		return tickets;
	}

	@Override
	public Ticket getTicketById(int id) throws TicketException {
		List<Ticket> tickets = getAllTickets();
		Ticket ticket = null;
		if(!tickets.isEmpty()){
			ticket = tickets.stream().filter(t -> t.getId() == id).collect(Collectors.toList()).get(0);
		}
			
		return ticket;
	}

	@Override
	public Ticket acceptTicket(int id) throws TicketException {
		Ticket ticketToModify = getTicketById(id);
		if (ticketToModify.getStatus() != Status.NEW) {
			throw new TicketException(
					"Can not reject Ticket as it is currently in status " + ticketToModify.getStatus());
		}
		Ticket ticket = new Ticket(id, null, null, null, null, null,Status.ACCEPTED);
		Message message = new Message(ticket, null, Constants.UPDATE_TICKET_STATUS);
		Message reply = sendMessage(message);
		return reply.getTicket();
	}

	@Override
	public Ticket rejectTicket(int id) throws TicketException {
		
		Ticket ticketToModify = getTicketById(id);
		if (ticketToModify.getStatus() != Status.NEW) {
			throw new TicketException(
					"Can not reject Ticket as it is currently in status " + ticketToModify.getStatus());
		}
		Ticket ticket = new Ticket(id, null, null, null, null, null,Status.REJECTED);
		Message message = new Message(ticket, null, Constants.UPDATE_TICKET_STATUS);
		Message reply = sendMessage(message);
		return reply.getTicket();

	}

	@Override
	public Ticket closeTicket(int id) throws TicketException {
		
		Ticket ticketToModify = getTicketById(id);
		if (ticketToModify.getStatus() != Status.ACCEPTED) {
			throw new TicketException(
					"Can not reject Ticket as it is currently in status " + ticketToModify.getStatus());
		}
		Ticket ticket = new Ticket(id, null, null, null, null, null,Status.CLOSED);
		Message message = new Message(ticket, null, Constants.UPDATE_TICKET_STATUS);
		Message reply = sendMessage(message);
		return reply.getTicket();
	}

}
