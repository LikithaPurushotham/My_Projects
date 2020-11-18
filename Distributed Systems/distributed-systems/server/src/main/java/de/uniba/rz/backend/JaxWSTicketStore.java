package de.uniba.rz.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.entities.Type;

public class JaxWSTicketStore implements TicketStore {
	
	public static Map<Integer, Ticket> dataStore = new HashMap<>();
	AtomicInteger id = new AtomicInteger();

	@Override
	public Ticket storeNewTicket(String reporter, String topic, String description, Type type, Priority priority) {
	
		Ticket newTicket = new Ticket(id.getAndIncrement(), reporter, topic, description, type, priority);
		dataStore.put(newTicket.getId(), newTicket);

		return (Ticket) newTicket.clone();
	
	}

	@Override
	public void updateTicketStatus(int ticketId, Status newStatus)
		throws UnknownTicketException, IllegalStateException, TicketException {
		if(!dataStore.containsKey(ticketId)){
			throw new TicketException("Ticket Id is unknown");
		}
	
		Ticket oldTicket = dataStore.get(ticketId);
		oldTicket.setStatus(newStatus);

	}

	@Override
	public List<Ticket> getAllTickets() {
		return dataStore.entrySet().stream().map(entry -> (Ticket) entry.getValue().clone())
			.collect(Collectors.toList());
	}
	
	public List<Ticket> getTicketsByName(String searchString){
		List<Ticket> tickets = new ArrayList<>();
		for(Integer ticketId : dataStore.keySet()){
			Ticket ticket = dataStore.get(ticketId);
			if(ticket.getReporter().equalsIgnoreCase(searchString) || ticket.getTopic().equalsIgnoreCase(searchString) || ticket.getDescription().equalsIgnoreCase(searchString)){
				tickets.add(ticket);
			}
		}
		return tickets;
	}
	
	public List<Ticket> getTicketsByNameAndType(String searchString, Type type){
		List<Ticket> tickets = new ArrayList<>();
		for(Integer ticketId : dataStore.keySet()){
			Ticket ticket = dataStore.get(ticketId);
			if((ticket.getReporter().equalsIgnoreCase(searchString) || ticket.getTopic().equalsIgnoreCase(searchString) || ticket.getDescription().equalsIgnoreCase(searchString))
					&& ticket.getType().equals(type)){
				tickets.add(ticket);
			}
		}
		return tickets;
	}
	
	

}
