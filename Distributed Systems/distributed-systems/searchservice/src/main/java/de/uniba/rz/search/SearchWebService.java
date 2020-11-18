package de.uniba.rz.search;

import javax.jws.WebMethod;
import javax.jws.WebService;

import de.uniba.rz.entities.Message;
import de.uniba.rz.entities.TicketSearch;
import de.uniba.rz.search.exceptions.TypeNotAvailableException;

@WebService
public interface SearchWebService {
	
	@WebMethod
	public Message clientMessage(TicketSearch searchMessage) throws TypeNotAvailableException;
}
