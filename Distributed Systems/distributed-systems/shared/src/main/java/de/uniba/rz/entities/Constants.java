package de.uniba.rz.entities;

import java.io.Serializable;

public  class Constants implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 27962154286485967L;

	public static final String STORE_TICKET = "storeTicket";
	
	public static final String UPDATE_TICKET_STATUS = "updateTicketStatus";
	
	public static final String GET_ALL_TICKETS = "getAllTickets";
	
	public static String SERVER_WEB_SERVICE_URL = "http://localhost:8888/TicketMgmt";
	
	public static String SEARCH_WEB_SERVICE_URL = "http://localhost:8889/search";
	
	
}
