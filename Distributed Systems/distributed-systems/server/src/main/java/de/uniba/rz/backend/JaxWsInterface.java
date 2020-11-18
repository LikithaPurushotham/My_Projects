package de.uniba.rz.backend;

import javax.jws.WebMethod;
import javax.jws.WebService;

import de.uniba.rz.entities.Message;
import de.uniba.rz.entities.TicketSearch;

@WebService
public interface JaxWsInterface {

	@WebMethod
	public Message sendMessage(Message message);
	
	@WebMethod
	public Message searchMessage(TicketSearch ticketSearch);
}
