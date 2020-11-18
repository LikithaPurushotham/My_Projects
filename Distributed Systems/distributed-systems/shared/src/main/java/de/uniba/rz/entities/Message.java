package de.uniba.rz.entities;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Message")
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3244557663184193505L;
	
	@XmlElement(name="ticket")
	public Ticket ticket;

	@XmlElement(name="response")
	public List<Ticket> response;
	
	@XmlElement(name="operation")
	public String operation;
	
	
	
	public Message(Ticket ticket, List<Ticket> response, String operation) {

		this.ticket = ticket;
		this.response = response;
		this.operation = operation;
	}
	
	public Message() {

	}
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public List<Ticket> getResponse() {
		return response;
	}
	public void setResponse(List<Ticket> response) {
		this.response = response;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
}
