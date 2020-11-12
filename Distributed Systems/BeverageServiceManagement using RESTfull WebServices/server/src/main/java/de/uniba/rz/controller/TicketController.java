package de.uniba.rz.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import de.uniba.rz.backend.SimpleTicketStore;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Type;
import de.uniba.rz.helpers.PaginationHelpers;
import de.uniba_rz.data_binding.PaginatedTicket;
import de.uniba_rz.data_binding.TicketBinding;

@Path("/tickets")
public class TicketController {

	private static final Logger logger = Logger.getLogger("TicketController");
	
	@POST
	public Response createTicket(TicketBinding newTicket, @Context UriInfo uriInfo) {
		boolean res = SimpleTicketStore.storeNewTicket(newTicket);
		if(!res) {
			throw new WebApplicationException("Bad request ", 400);
		}
		UriBuilder path = uriInfo.getAbsolutePathBuilder();
        path.path(Integer.toString(newTicket.getId()));
		return Response.created(path.build()).build();
	}
	
	@PUT
	@Path("{ticket-id}")
	public TicketBinding updateTicketStatus(@PathParam("ticket-id") int ticketId, TicketBinding updatedTicket) {
		System.out.println("ticket controller Updating a ticket");
		return SimpleTicketStore.updateTicketStatus(ticketId, updatedTicket);
	}

	@GET
	public Response getAllTickets(
			@Context final UriInfo info,
			@QueryParam("page") @DefaultValue("1") final int page,
			@QueryParam("pageLimit") @DefaultValue("5") final int pageLimit,
			@QueryParam("ticket-name") @DefaultValue("") final String tName, 
			@QueryParam("ticket-type") @DefaultValue("") final Type tType
			) {
		logger.info("Pagination parameter: page- " + page + " pageLimit- " + pageLimit + " ticket-name: " + tName + " ticket-type: " + tType);
		
		final PaginationHelpers<TicketBinding> helper;
		
		if(tName!=null && tType!=null) {
			helper = new PaginationHelpers<>(SimpleTicketStore.getTicketsByNameAndType(tName, tType));
		}else if(tName!=null && tType==null) {
			helper = new PaginationHelpers<>(SimpleTicketStore.getTicketsByName(tName));
		}else {
			helper = new PaginationHelpers<>(SimpleTicketStore.getAllTickets());
		}
		final PaginatedTicket response = new PaginatedTicket(helper.getPagination(info, page, pageLimit), helper.getPaginatedList(), info.getRequestUri());
		return Response.ok(response).build();
	}
	
	@GET
	@Path("{ticket-id}")
	public TicketBinding getTicket(@PathParam("ticket-id") int ticketId) {
		System.out.println("ticket controller get single ticket");
		return SimpleTicketStore.getTicketById(ticketId);
	}

}
