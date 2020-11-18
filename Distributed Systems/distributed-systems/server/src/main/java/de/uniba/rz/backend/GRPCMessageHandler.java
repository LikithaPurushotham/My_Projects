package de.uniba.rz.backend;

import java.util.Arrays;
import java.util.List;

import de.uniba.rz.app.converter.MessageConverter;
import de.uniba.rz.entities.Constants;
import de.uniba.rz.entities.Message;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.io.rpc.MessageTransferObject;
import io.grpc.stub.StreamObserver;

public class GRPCMessageHandler extends Constants implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3621873834431394056L;
	private MessageTransferObject messageTransferObject ;
	private TicketStore ticketStore;
	private StreamObserver<MessageTransferObject> responseObserver;
	public GRPCMessageHandler(MessageTransferObject messageTransferObject, TicketStore ticketStore, StreamObserver<MessageTransferObject> responseObserver) {
		this.messageTransferObject = messageTransferObject;
		this.ticketStore = ticketStore;
		this.responseObserver = responseObserver;
	}
	
	@Override
	public void run() {
		
		// As mentioned in client side, MessageTransferObject has to be converted back Message Object.
		Message message = MessageConverter.convertToMessage(messageTransferObject);
		String operation = message.getOperation();
		 
		Message response = new Message();
		try {
			switch(operation) {
		
				case STORE_TICKET:
					Ticket ticket = ticketStore.storeNewTicket(message.getTicket().getReporter(), message.getTicket().getTopic(), message.getTicket().getDescription(), message.getTicket().getType(), message.getTicket().getPriority());
					response.setResponse(Arrays.asList(ticket));
					break;
			
				case GET_ALL_TICKETS:
					List<Ticket> tickets = ticketStore.getAllTickets();
					response.setResponse(tickets);
					break;
				
				case UPDATE_TICKET_STATUS:
					ticketStore.updateTicketStatus(message.getTicket().getId(), message.getTicket().getStatus());
					response.setResponse(Arrays.asList(message.getTicket()));
					break;
			
				default :
					System.out.println("Invalid operation");
				
			}
			
			// Message is converted to messageTransferObject to send the response to client
			MessageTransferObject responseTransferObject = MessageConverter.convertToMessageTransferObject(response);
			responseObserver.onNext(responseTransferObject);
            responseObserver.onCompleted();
			
		} catch (IllegalStateException | UnknownTicketException | TicketException e) {
			e.printStackTrace();
		} 
	
	}
	


}
