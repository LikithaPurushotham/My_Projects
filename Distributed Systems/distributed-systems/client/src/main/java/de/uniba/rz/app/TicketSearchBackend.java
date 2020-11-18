package de.uniba.rz.app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.ws.WebServiceException;

import de.uniba.rz.app.exceptions.CustomException;
import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.entities.Type;
import de.uniba.rz.search.Message;
import de.uniba.rz.search.SearchWebService;
import de.uniba.rz.search.SearchWebServiceImplService;
import de.uniba.rz.search.TicketSearch;
import de.uniba.rz.search.TypeNotAvailableException_Exception;

/**
 * Defines the actions the GUI is calling to search for {@link Ticket}s
 */
public interface TicketSearchBackend {
	
	

	/**
	 * Method to search for a Ticket based on the provided information
	 * 
	 * @param name The name of the ticket to be searched
	 * @return a list of {@link Ticket} that fulfill the requested attributes
	 * @throws TicketException if something failed
	 * @throws CustomException 
	 * @throws MalformedURLException 
	 */
	default List<Ticket> getTicketsByName(String name) throws TicketException, CustomException {
		URL url;
		List<Ticket> tickets = null;
		try {
			url = new URL("http://localhost:8889/search?wsdl");
			
			
			SearchWebServiceImplService searchWebServiceImplService = new SearchWebServiceImplService(url);
			SearchWebService searchWebService = searchWebServiceImplService.getSearchWebServiceImplPort();
			
			TicketSearch ticketSearch = new TicketSearch();
			ticketSearch.setSearchString(name);
			Message message = searchWebService.clientMessage(ticketSearch);
			
			tickets = message.getResponse().stream().map(t -> convertToTicket(t)).collect(Collectors.toList());
		} catch (MalformedURLException e) {
			throw new WebServiceException("Unable to connect to web service");
		} catch (TypeNotAvailableException_Exception e) {
			throw new CustomException("Data for requested type not available");
		}
		
		return tickets;	
	}
	
	/**
	 * Method to search for a Ticket based on the provided information
	 * 
	 * @param name The name of the ticket to be searched
	 * @param type The {@link Type} of the ticket to be searched
	 * @return a list of {@link Ticket} that fulfill the requested attributes
	 * @throws TicketException if something failed
	 * @throws CustomException 
	 * @throws MalformedURLException 
	 */
	default List<Ticket> getTicketsByNameAndType(String name, Type type) throws TicketException, CustomException {
		
		URL url;
		List<Ticket> tickets = null;
		try {
			url = new URL("http://localhost:8889/search?wsdl");
			SearchWebServiceImplService searchWebServiceImplService = new SearchWebServiceImplService(url);
			SearchWebService searchWebService = searchWebServiceImplService.getSearchWebServiceImplPort();
			
			TicketSearch ticketSearch = new TicketSearch();
			ticketSearch.setSearchString(name);
			ticketSearch.setSearchType(de.uniba.rz.search.Type.valueOf(type.name()));
			Message message = searchWebService.clientMessage(ticketSearch);
			tickets = message.getResponse().stream().map(t -> convertToTicket(t)).collect(Collectors.toList());
			
		} catch (MalformedURLException e) {
			throw new WebServiceException("Unable to connect to web service");
		} catch (TypeNotAvailableException_Exception e) {
			throw new CustomException("Data for requested type not available");
		}
		
		return tickets;
	}
	
	/**
	 * Method to convert from WSDL Generated Ticket entity to custom Ticket entity
	 * 
	 * @param ticket WSDL Generated Ticket entity 
	 * @return 
	 */
	
	default Ticket convertToTicket(de.uniba.rz.search.Ticket ticket){
		
		if(ticket != null)
			return new Ticket(ticket.getId()
							, ticket.getReporter()
							, ticket.getTopic()
							, ticket.getDescription()
							, Type.valueOf(ticket.getType().toString())
							, Priority.valueOf(ticket.getPriority().toString())
							, de.uniba.rz.entities.Status.valueOf(ticket.getStatus().toString()));
		else 
			return new Ticket();
	}
}