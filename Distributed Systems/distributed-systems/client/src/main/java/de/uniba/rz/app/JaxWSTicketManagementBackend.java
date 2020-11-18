package de.uniba.rz.app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.uniba.rz.app.exceptions.WebServiceNotAvailableException;
import de.uniba.rz.backend.JaxWSImplService;
import de.uniba.rz.backend.JaxWsInterface;
import de.uniba.rz.backend.Message;
import de.uniba.rz.backend.Status;
import de.uniba.rz.entities.Constants;
import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.entities.Type;

public class JaxWSTicketManagementBackend implements TicketManagementBackend {
	
	private JaxWsInterface jaxWsInterface;
	
	public JaxWSTicketManagementBackend() throws WebServiceNotAvailableException {
		try {
			URL url = new URL("http://localhost:8888/TicketMgmt?wsdl");
			JaxWSImplService jaxWSImplService = new JaxWSImplService(url);
			this.jaxWsInterface = jaxWSImplService.getJaxWSImplPort();	
		} catch (MalformedURLException e) {
			throw new WebServiceNotAvailableException();
		}
		
		
	}
	
	/**
	 * Send message to web service
	 * @param message
	 * @return
	 */
	private de.uniba.rz.entities.Message sendMessage(de.uniba.rz.entities.Message message){
		Message msg = convertToJAXWSMessage(message);
		Message response = jaxWsInterface.sendMessage(msg);
		return convertToMessage(response);
		
	}

	@Override
	public void triggerShutdown() {
		
	}

	@Override
	public Ticket createNewTicket(String reporter, String topic, String description, Type type, Priority priority)
			throws TicketException {
		Ticket ticket = new Ticket(0, reporter, topic, description, type, priority);
		de.uniba.rz.entities.Message message = new de.uniba.rz.entities.Message(ticket, null, Constants.STORE_TICKET);
		sendMessage(message);
		return ticket;
	}

	@Override
	public List<Ticket> getAllTickets() throws TicketException {
		List<Ticket> tickets = new ArrayList<>();
		de.uniba.rz.entities.Message Message = new de.uniba.rz.entities.Message(null, null, Constants.GET_ALL_TICKETS);
		de.uniba.rz.entities.Message response = sendMessage(Message);
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
		if (ticketToModify.getStatus() != de.uniba.rz.entities.Status.NEW) {
			throw new TicketException(
					"Can not reject Ticket as it is currently in status " + ticketToModify.getStatus());
		}
		Ticket ticket = new Ticket(id, null, null, null, null, null,de.uniba.rz.entities.Status.ACCEPTED);
		de.uniba.rz.entities.Message message = new de.uniba.rz.entities.Message(ticket, null, Constants.UPDATE_TICKET_STATUS);
		de.uniba.rz.entities.Message reply = sendMessage(message);
		return reply.getTicket();
	}

	@Override
	public Ticket rejectTicket(int id) throws TicketException {
		Ticket ticketToModify = getTicketById(id);
		if (ticketToModify.getStatus() != de.uniba.rz.entities.Status.NEW) {
			throw new TicketException(
					"Can not reject Ticket as it is currently in status " + ticketToModify.getStatus());
		}
		Ticket ticket = new Ticket(id, null, null, null, null, null,de.uniba.rz.entities.Status.REJECTED);
		de.uniba.rz.entities.Message message = new de.uniba.rz.entities.Message(ticket, null, Constants.UPDATE_TICKET_STATUS);
		de.uniba.rz.entities.Message reply = sendMessage(message);
		return reply.getTicket();
	}

	@Override
	public Ticket closeTicket(int id) throws TicketException {
		Ticket ticketToModify = getTicketById(id);
		if (ticketToModify.getStatus() != de.uniba.rz.entities.Status.ACCEPTED) {
			throw new TicketException(
					"Can not reject Ticket as it is currently in status " + ticketToModify.getStatus());
		}
		Ticket ticket = new Ticket(id, null, null, null, null, null,de.uniba.rz.entities.Status.CLOSED);
		de.uniba.rz.entities.Message message = new de.uniba.rz.entities.Message(ticket, null, Constants.UPDATE_TICKET_STATUS);
		de.uniba.rz.entities.Message reply = sendMessage(message);
		return reply.getTicket();
	}

	/**
	 * Convert message entity to WSDL generated message entity
	 * @param message
	 * @return
	 */
	private Message convertToJAXWSMessage(de.uniba.rz.entities.Message message) {
		

		Message msg = new Message();
		msg.setTicket(convertToJAXWSTicket(message.getTicket()));
		msg.setOperation(message.getOperation());
		
		if(message.getResponse() != null) {
			for(Ticket ticket : message.getResponse()) {
				msg.getResponse().add(convertToJAXWSTicket(ticket));
			}
		}

		
		return msg;
		
	}
	
	/**
	 * Convert WSDL generated message entity to shared message entity
	 * @param message
	 * @return
	 */
	private de.uniba.rz.entities.Message convertToMessage(Message message){
		List<Ticket> tickets = new ArrayList<>();
		
		if(message.getResponse() != null){
			
			for(de.uniba.rz.backend.Ticket ticket : message.getResponse()){
				tickets.add(convertToTicket(ticket));
			}
		}
		
		return new de.uniba.rz.entities.Message(convertToTicket(message.getTicket()), tickets, message.getOperation());
	}
	
	/**
	 * Convert shared ticket entity to  WSDL generated message entity
	 * @param ticket
	 * @return
	 */
	private de.uniba.rz.backend.Ticket convertToJAXWSTicket(Ticket ticket) {
		
		de.uniba.rz.backend.Ticket tkt = new de.uniba.rz.backend.Ticket();
		if(ticket != null) {
			tkt.setId(ticket.getId());
			tkt.setDescription(ticket.getDescription());
			tkt.setReporter(ticket.getReporter());
			tkt.setTopic(ticket.getTopic());
			tkt.setPriority(ticket.getPriority() != null ? de.uniba.rz.backend.Priority.valueOf(ticket.getPriority().toString()) : null);
			tkt.setStatus(ticket.getStatus() != null ? Status.valueOf(ticket.getStatus().toString()) : null);
			tkt.setType(ticket.getType() != null ? de.uniba.rz.backend.Type.valueOf(ticket.getType().toString()) : null);
		}
		return tkt;
	}
	
	/**
	 * Convert WSDL generated ticket entity to shared ticket entity
	 * @param ticket
	 * @return
	 */
	private Ticket convertToTicket(de.uniba.rz.backend.Ticket ticket){
		
		if(ticket != null)
			return new Ticket(ticket.getId()
							, ticket.getReporter()
							, ticket.getTopic()
							, ticket.getDescription()
							, ticket.getType() != null ? Type.valueOf(ticket.getType().toString()) : null
							, ticket.getPriority() != null ? Priority.valueOf(ticket.getPriority().toString()) : null
							, ticket.getStatus() != null ? de.uniba.rz.entities.Status.valueOf(ticket.getStatus().toString()) : null);
		else 
			return new Ticket();
	}
	
}
