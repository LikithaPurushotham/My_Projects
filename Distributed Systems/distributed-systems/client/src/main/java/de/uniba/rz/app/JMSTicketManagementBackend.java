package de.uniba.rz.app;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.uniba.rz.entities.Constants;
import de.uniba.rz.entities.Message;
import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.entities.Type;


public class JMSTicketManagementBackend implements TicketManagementBackend{

	String connFactoryLookup;
	String destinationLookup; 
	Context context;
	ConnectionFactory connectionFactory;
	Destination destination;
	
	public JMSTicketManagementBackend(String connFactoryLookup, String destinationLookup) {
		
		this.connFactoryLookup = connFactoryLookup;
		this.destinationLookup = destinationLookup;
		
		initializeContext();
	}
	
	// This is constructor for this class i.e. the code written inside this is executed when an object is created for this class
	public void initializeContext(){
		Hashtable<String, String> contextParams = new Hashtable<>();
		try {
			// For use with the File System JNDI Service Provider
			
			contextParams.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
			
			//Details regarding the connection and queue is stored under this folder in '.bindings' file
			contextParams.put(Context.PROVIDER_URL, "file:///D:/IdsMQFolder");
			
			// a object for context is created which will be used to create context factory and destination
			this.context = new InitialContext(contextParams);
			
			// connFactoryLookup we pass as program argument
			connectionFactory = (ConnectionFactory) context.lookup(connFactoryLookup);
			
			// destinationLookup also we pass as program argument
			destination = (Destination) context.lookup(destinationLookup);
			/*
			 *  Note : connectionFactoryLookup and destinationLookup are the alias names we give in the JMS server where we created connectionFactory and Destination
			 */
		} catch (NamingException e) {
			System.out.println("JNDI Problem. Check used hostname and/or " + "Glassfish configuration.");
			e.printStackTrace();
		} 
	}
	 
	/*
	 * This method is used to send messages
	 */
	public Message sendMessage(de.uniba.rz.entities.Message message){
		
		Message reply = null;
		try(JMSContext jms = connectionFactory.createContext()){
			
			
			Destination temporaryQueue = jms.createTemporaryQueue(); // The queue we use to send message from client to server cant be used to get response from server as queue is unidirectional. Therefore we create temporary queue to get resposne from server.
			ObjectMessage msg = jms.createObjectMessage(message); // Data is sent as ObjectMessage which is a serialized form of the data we intend to send
			msg.setJMSReplyTo(temporaryQueue); // Setting the temporary queue in message which is used by server to respond.
			jms.createProducer().send(destination, msg); // message sent
			
			JMSConsumer consumer = jms.createConsumer(temporaryQueue); // A consumer is created for each queue to fetch data from it.
			reply = consumer.receiveBody(Message.class); // Fetching data from consumer
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
		return reply;
	}
	
	@Override
	public void triggerShutdown() {
		try {
			context.close();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Ticket createNewTicket(String reporter, String topic, String description, Type type, Priority priority)
			throws TicketException {
		Ticket ticket = new Ticket(0,reporter, topic, description, type, priority);
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
