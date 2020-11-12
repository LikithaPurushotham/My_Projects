package de.uniba.rz.jaxRsClient;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.uniba.rz.app.TicketManagementBackend;
import de.uniba.rz.app.TicketSearchBackend;
import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.entities.Type;
import de.uniba_rz.data_binding.PaginatedTicket;
import de.uniba_rz.data_binding.TicketBinding;

public class JaxRsClientTicketManagement implements TicketManagementBackend, TicketSearchBackend {

	Client client;
	String link = "http://localhost:5000";
	
	public JaxRsClientTicketManagement(){
		client = ClientBuilder.newClient();
	}
	
	@Override
	public void triggerShutdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public Ticket createNewTicket(String reporter, String topic, String description, Type type, Priority priority)
			throws TicketException {
		// TODO Auto-generated method stub
		TicketBinding nTicket = new TicketBinding(0,topic,reporter,priority,type,description);
		Entity<TicketBinding> entity = Entity.xml(nTicket);
		Response response = client.target(link).path("/tickets")
		.request(MediaType.APPLICATION_XML)
		.header("Content-Type", "application/xml")
		.post(entity);
		System.out.println("URL:::::::: " + response.getLocation());
		response = client.target(response.getLocation())
		.request(MediaType.APPLICATION_XML)
		.header("Content-Type","application/xml")
		.get();
		return xmlToPojo(response.readEntity(TicketBinding.class));
	}

	@Override
	public List<Ticket> getAllTickets() throws TicketException {
		// TODO Auto-generated method stub
		PaginatedTicket paginatedTicket;
		Response response = client.target(link).path("/tickets")
		.request(MediaType.APPLICATION_XML)
		.header("Content-Type", "application/xml")
		.get();

		List<TicketBinding> ticketBindList = new ArrayList<>();
		paginatedTicket = response.readEntity(PaginatedTicket.class);
		ticketBindList = paginatedTicket.getTickets();
		return xmlToPojo(ticketBindList);
	}
	
	public List<Ticket> xmlToPojo(List<TicketBinding> tbList){
		List<Ticket> ticketList = new ArrayList<>();
		if(tbList!=null)
		tbList.forEach(tbind -> {
			ticketList.add(xmlToPojo(tbind));
		});
		return ticketList;
	}

	public Ticket xmlToPojo(TicketBinding tbind) {
		return new Ticket(tbind.getId(),tbind.getReporter(), tbind.getTopic(),tbind.getDescription(), tbind.getType(), tbind.getPriority(),tbind.getStatus());
	}
	
	public TicketBinding pojoToXml(Ticket t) {
		return new TicketBinding(t.getId(),t.getTopic(),t.getReporter(),t.getPriority(),t.getType(),t.getStatus(),t.getDescription());
	}
	
	@Override
	public Ticket getTicketById(int id) throws TicketException {
		// TODO Auto-generated method stub
		Response response = client.target(link).path("/tickets").path("/"+id)
				.request(MediaType.APPLICATION_XML)
				.header("Content-Type","application/xml")
				.get();
		return xmlToPojo(response.readEntity(TicketBinding.class));
	}

	@Override
	public Ticket acceptTicket(int id) throws TicketException {
		// TODO Auto-generated method stub
		Ticket ticket = getTicketById(id);
		ticket.setStatus(Status.ACCEPTED);
		TicketBinding uTicket = pojoToXml(ticket);
		Entity<TicketBinding> entity = Entity.xml(uTicket);
		Response response = client.target(link).path("/tickets").path("/"+id)
				.request(MediaType.APPLICATION_XML)
				.header("Content-Type","application/xml")
				.put(entity);
		return xmlToPojo(response.readEntity(TicketBinding.class));
	}

	
	@Override
	public Ticket rejectTicket(int id) throws TicketException {
		// TODO Auto-generated method stub
		Ticket ticket = getTicketById(id);
		ticket.setStatus(Status.REJECTED);
		TicketBinding uTicket = pojoToXml(ticket);
		Entity<TicketBinding> entity = Entity.xml(uTicket);
		Response response = client.target(link).path("/tickets").path("/"+id)
				.request(MediaType.APPLICATION_XML)
				.header("Content-Type","application/xml")
				.put(entity);
		return xmlToPojo(response.readEntity(TicketBinding.class));
	}

	@Override
	public Ticket closeTicket(int id) throws TicketException {
		// TODO Auto-generated method stub
		Ticket ticket = getTicketById(id);
		ticket.setStatus(Status.CLOSED);
		TicketBinding uTicket = pojoToXml(ticket);
		Entity<TicketBinding> entity = Entity.xml(uTicket);
		Response response = client.target(link).path("/tickets").path("/"+id)
				.request(MediaType.APPLICATION_XML)
				.header("Content-Type","application/xml")
				.put(entity);
		return xmlToPojo(response.readEntity(TicketBinding.class));
	}

	@Override
	public List<Ticket> getTicketsByName(String page, String limit, String name) throws TicketException {
		// TODO Auto-generated method stub
		PaginatedTicket paginatedTicket;
		Response response = client.target(link).path("/tickets")
			.queryParam("page", page)
			.queryParam("pageLimit", limit)
			.queryParam("ticket-name", name)
			.request(MediaType.APPLICATION_XML)
			.header("Content-Type", "application/xml")
			.get();

			List<TicketBinding> ticketBindList = new ArrayList<>();
			paginatedTicket = response.readEntity(PaginatedTicket.class);
			ticketBindList = paginatedTicket.getTickets();
		return xmlToPojo(ticketBindList);
	}

	@Override
	public List<Ticket> getTicketsByNameAndType(String page, String limit, String name, Type type) throws TicketException {
		// TODO Auto-generated method stub
		PaginatedTicket paginatedTicket;
		Response response = client.target(link).path("/tickets")
			.queryParam("page", page)
			.queryParam("pageLimit", limit)
			.queryParam("ticket-name", name)
			.queryParam("ticket-type", type)
			.request(MediaType.APPLICATION_XML)
			.header("Content-Type", "application/xml")
			.get();

			List<TicketBinding> ticketBindList = new ArrayList<>();
			paginatedTicket = response.readEntity(PaginatedTicket.class);
			ticketBindList = paginatedTicket.getTickets();
		return xmlToPojo(ticketBindList);
	}
	
	

}
