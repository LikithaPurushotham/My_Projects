package de.uniba.rz.app.converter;

import java.util.List;
import java.util.stream.Collectors;

import de.uniba.rz.entities.Message;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.io.rpc.ListOfTicketTransferObject;
import de.uniba.rz.io.rpc.MessageTransferObject;
import de.uniba.rz.io.rpc.MessageTransferObject.Builder;
import de.uniba.rz.io.rpc.TicketTransferObject;

public class MessageConverter {

	public static Message convertToMessage(MessageTransferObject messageTransferObject){
		Ticket ticket = TicketConverter.convertToTicket(messageTransferObject.getTicket());
		
		List<TicketTransferObject> ticketTransferObjects = messageTransferObject.getResponse().getTicketTransferObjectList();
		List<Ticket> response = ticketTransferObjects.stream().map(TicketConverter :: convertToTicket).collect(Collectors.toList());
		
		
		return new Message(ticket, response, messageTransferObject.getOperation());
	}
	
	public static MessageTransferObject convertToMessageTransferObject(Message message){
		
		de.uniba.rz.io.rpc.ListOfTicketTransferObject.Builder responseBuilder = ListOfTicketTransferObject.newBuilder();
		
		if(message.getResponse() != null)
			for(Ticket ticket : message.getResponse()){
				TicketTransferObject transferObject = TicketConverter.convertToTicketTransferObject(ticket);
				responseBuilder.addTicketTransferObject(transferObject);
				
			}
		
		Builder messageBuilder = MessageTransferObject.newBuilder();
		messageBuilder.setTicket(TicketConverter.convertToTicketTransferObject(message.getTicket()));
		messageBuilder.setResponse(responseBuilder);
		messageBuilder.setOperation(message.getOperation() != null ? message.getOperation() : "");
		return messageBuilder.build();
		
	}
}
