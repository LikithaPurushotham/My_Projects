package de.uniba.rz.backend;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import de.uniba.rz.entities.Constants;
import de.uniba.rz.entities.Message;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;


/**
 * Implementation to handles messages from clients
 * @author ADMIN
 *
 */
public class JaxWSMessageHandler extends Constants implements Callable<Message> {

	private static final long serialVersionUID = 5507210783324372627L;
	private Message message;
	private TicketStore ticketStore;
	
	public JaxWSMessageHandler(TicketStore ticketStore, Message message) {
		this.message = message;
		this.ticketStore = ticketStore;
	}
	@Override
	public Message call() throws Exception {
		
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
			
		
			
		} catch (IllegalStateException | UnknownTicketException | TicketException e) {
			e.printStackTrace();
		} 
		
		return response;
	}

}
