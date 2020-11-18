package de.uniba.rz.search;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import de.uniba.rz.backend.JaxWSImplService;
import de.uniba.rz.backend.JaxWsInterface;
import de.uniba.rz.entities.Message;
import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketSearch;
import de.uniba.rz.entities.Type;
import de.uniba.rz.search.exceptions.TypeNotAvailableException;

@WebService(endpointInterface = "de.uniba.rz.search.SearchWebService")
public class SearchWebServiceImpl implements SearchWebService {

private JaxWsInterface jaxWsInterface;
	
	public SearchWebServiceImpl() {
		try {
			URL url = new URL("http://localhost:8888/TicketMgmt?wsdl");
			JaxWSImplService jaxWSImplService = new JaxWSImplService(url);
			this.jaxWsInterface = jaxWSImplService.getJaxWSImplPort();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Message clientMessage(TicketSearch searchMessage) throws TypeNotAvailableException {
		
		de.uniba.rz.backend.TicketSearch ticketSearch =  convertToJaxWSTicketSearch(searchMessage);
		de.uniba.rz.backend.Message message = jaxWsInterface.searchMessage(ticketSearch);
		if(searchMessage.getSearchType() != null && message.getResponse().isEmpty()){
			throw new TypeNotAvailableException();
		}
		return convertToMessage(message);
	}
	
	private de.uniba.rz.backend.TicketSearch convertToJaxWSTicketSearch (TicketSearch ticketSearch){
		
		de.uniba.rz.backend.TicketSearch search = new de.uniba.rz.backend.TicketSearch();
		search.setSearchString(ticketSearch.getSearchString());
		
		if(ticketSearch.getSearchType() != null)
			search.setSearchType(de.uniba.rz.backend.Type.valueOf(ticketSearch.getSearchType().name()));
		
		return search;
	}	
	
	private Message convertToMessage(de.uniba.rz.backend.Message message){
		List<Ticket> tickets = new ArrayList<>();
		
		if(message.getResponse() != null){
			
			for(de.uniba.rz.backend.Ticket ticket : message.getResponse()){
				tickets.add(convertToTicket(ticket));
			}
		}
		
		return new de.uniba.rz.entities.Message(convertToTicket(message.getTicket()), tickets, message.getOperation());
	}
	
	private Ticket convertToTicket(de.uniba.rz.backend.Ticket ticket){
		
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
