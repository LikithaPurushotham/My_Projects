package de.uniba.rz.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.Type;
import de.uniba_rz.data_binding.TicketBinding;

/**
 * This is a basic implementation of the <code>TicketStore</code> interface for
 * testing purposes only.
 *
 * Caution: This class is neither thread-safe nor does it perform any checks in
 * the updateTicketStatus method
 *
 * Do not use this class in the assignment solution but provide an own
 * implementation of <code>TicketStore</code>!
 */

public class SimpleTicketStore implements TicketStore{

	private static int nextTicketId = 0;
	private static List<TicketBinding> ticketList = new ArrayList<>();

	public static boolean storeNewTicket(TicketBinding newTicket) {
		System.out.println(" Creating new Ticket from Reporter: " + newTicket.toString());
		newTicket.setId(++nextTicketId);
		newTicket.setStatus(Status.NEW);
		ticketList.add(newTicket);
		if(ticketList == null) {
			return false;
		}
		return true;
	}
	
	public static TicketBinding updateTicketStatus(int ticketId, TicketBinding updatedStatus) {
		System.out.println("Updating the ticket");
		TicketBinding temp = null;
		for (TicketBinding ticket : ticketList) {
			if (ticket.getId() == ticketId) {
				ticket.setStatus(updatedStatus.getStatus());
				temp = ticket;
			}
		}
		return temp;
	}
	
	public static List<TicketBinding> getTicketsByName(String name){
		List<TicketBinding> nList = ticketList.stream()
				.filter(ticket -> ticket.getTopic().toLowerCase().contains(name.toLowerCase()) 
				|| ticket.getReporter().toLowerCase().contains(name.toLowerCase()) 
				|| ticket.getDescription().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
		nList.sort((i1,i2)->i1.getPriority().compareTo(i2.getPriority()));
		return nList;
	}
	
	public static List<TicketBinding> getTicketsByNameAndType(String name, Type tType){
		List<TicketBinding> nList = ticketList.stream()
				.filter(ticket -> 
				(ticket.getType().equals(tType) && 
				(ticket.getTopic().toLowerCase().contains(name.toLowerCase()) 
				|| ticket.getReporter().toLowerCase().contains(name.toLowerCase()) 
				|| ticket.getDescription().toLowerCase().contains(name.toLowerCase()))
			)).collect(Collectors.toList());
		nList.sort((i1,i2)->i1.getPriority().compareTo(i2.getPriority()));
		return nList;
	}
//	public static TicketBinding updateTicketStatus(int ticketId, Status updatedStatus) {
//		System.out.println("Updating the ticket");
//		TicketBinding temp = null;
//		for (TicketBinding ticket : ticketList) {
//			if (ticket.getId() == ticketId) {
//				ticket.setStatus(updatedStatus);
//				temp = ticket;
//			}
//		}
//		return temp;
//	}

	public static List<TicketBinding> getAllTickets() {
		System.out.println(" getting list of tickets form store. ");
		return ticketList;
	}
	
	public static TicketBinding getTicketById(int id) {
		return ticketList.stream().filter(t->t.getId()==id).findFirst().orElse(null);
	}
	
}
