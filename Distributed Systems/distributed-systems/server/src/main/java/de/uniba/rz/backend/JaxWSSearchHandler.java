package de.uniba.rz.backend;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import de.uniba.rz.entities.Message;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketSearch;

/**
 * Implementation to handle search messages
 * @author ADMIN
 *
 */
public class JaxWSSearchHandler implements Callable<Message> {

	private TicketStore ticketStore;
	private TicketSearch ticketSearch;
	
	public JaxWSSearchHandler(TicketStore ticketStore, TicketSearch ticketSearch) {
		this.ticketSearch =  ticketSearch;
		this.ticketStore = ticketStore;
	}
	
	@Override
	public Message call() throws Exception {
		
		Message response = new Message();
		List<Ticket> allTickets = ticketStore.getAllTickets();
		if(ticketSearch.getSearchType() == null) {
			response.setResponse(allTickets.stream().filter(t -> t.getReporter().equalsIgnoreCase(ticketSearch.getSearchString()) || t.getTopic().equalsIgnoreCase(ticketSearch.getSearchString()) || t.getDescription().equalsIgnoreCase(ticketSearch.getSearchString())).collect(Collectors.toList()));
		} else {
			response.setResponse(allTickets.stream().filter(t -> (t.getReporter().equalsIgnoreCase(ticketSearch.getSearchString()) || t.getTopic().equalsIgnoreCase(ticketSearch.getSearchString()) || t.getDescription().equalsIgnoreCase(ticketSearch.getSearchString())) && t.getType().equals(ticketSearch.getSearchType())).collect(Collectors.toList()));
		}
		
		// sorting the response on the basis of priority
		Collections.sort(response.getResponse(), new Comparator<Ticket>() {

			@Override
			public int compare(Ticket o1, Ticket o2) {
				return o1.getPriority().compareTo(o2.getPriority());
			}

		});	
		
		return response;
	}

	
}
