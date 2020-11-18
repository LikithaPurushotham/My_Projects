package de.uniba.rz.backend;

import java.util.Arrays;
import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;

import de.uniba.rz.entities.Constants;
import de.uniba.rz.entities.Message;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;

public class JMSMessageHandler extends Constants implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1789768088325335688L;
	private ObjectMessage om;
	private TicketStore ticketStore;
	private JMSContext jmsContext;
	
	public JMSMessageHandler(ObjectMessage om, TicketStore ticketStore, JMSContext jmsContext) throws NamingException {
		this.om = om;
		this.ticketStore = ticketStore;
		this.jmsContext = jmsContext;
	}
	@Override
	public void run() {
		handleResponse();
		
	}

	public void handleResponse(){
		Message message = null;
		try {
			// Getting actual data from ObjectMessage
			message = om.getBody(Message.class);
		} catch (JMSException e1) {
			e1.printStackTrace();
		}
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
			
			// Responding to client via the temporary queue.
			Destination tempDestination = om.getJMSReplyTo();
			jmsContext.createProducer().send(tempDestination, response);
			
		} catch (IllegalStateException | UnknownTicketException | TicketException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
