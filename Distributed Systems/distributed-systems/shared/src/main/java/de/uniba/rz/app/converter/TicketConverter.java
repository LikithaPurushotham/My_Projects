package de.uniba.rz.app.converter;


import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.Type;
import de.uniba.rz.io.rpc.TicketTransferObject;
import de.uniba.rz.io.rpc.TicketTransferObject.Builder;
import de.uniba.rz.io.rpc.TicketTransferObject.PriorityTransferObject;
import de.uniba.rz.io.rpc.TicketTransferObject.StatusTransferObject;
import de.uniba.rz.io.rpc.TicketTransferObject.TypeTransferObject;

public class TicketConverter {

	public static Ticket convertToTicket(TicketTransferObject ticketTransferObject) {
		
		return new Ticket(ticketTransferObject.getId(), 
									ticketTransferObject.getReporter(),
									ticketTransferObject.getTopic(),
									ticketTransferObject.getDescription(),
									TypeTransferObject.valueOf(Type.class, ticketTransferObject.getType().toString()),
									PriorityTransferObject.valueOf(Priority.class, ticketTransferObject.getPriority().toString()),
									StatusTransferObject.valueOf(Status.class, ticketTransferObject.getStatus().toString()));
	}
	
	public static TicketTransferObject convertToTicketTransferObject (Ticket ticket){

		Builder builder =  TicketTransferObject.newBuilder();
		if(ticket != null){
			builder.setId(ticket.getId() != 0 ? ticket.getId() : 0);
			builder.setDescription(ticket.getDescription() != null ? ticket.getDescription() : "");
			builder.setReporter(ticket.getReporter() != null ? ticket.getReporter() : "" );
			builder.setTopic(ticket.getTopic() != null ? ticket.getTopic() : "");
			builder.setType(ticket.getType() != null ? TypeTransferObject.valueOf(ticket.getType().toString()) : TypeTransferObject.BUG);
			builder.setPriority(ticket.getPriority() != null ? PriorityTransferObject.valueOf(ticket.getPriority().toString()) : PriorityTransferObject.CRITICAL);
			builder.setStatus(ticket.getStatus() != null ? StatusTransferObject.valueOf(ticket.getStatus().toString()) : StatusTransferObject.NEW);
		}
		
		return builder.build();
		
	}
}
