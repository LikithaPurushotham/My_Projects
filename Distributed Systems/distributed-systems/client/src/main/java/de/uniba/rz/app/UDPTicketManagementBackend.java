package de.uniba.rz.app;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import de.uniba.rz.entities.Constants;
import de.uniba.rz.entities.Message;
import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.entities.Type;

/**
 * Client side implementation for first assignment UDP part
 * @author ADMIN
 *
 */
public class UDPTicketManagementBackend implements TicketManagementBackend{
	
	String ipAddress;	// ip address of server to which the client will try connecting
	Integer port;	// port of server to which the client will try connecting
	AtomicInteger id = new AtomicInteger(); // atomic integer that will be incremented in atomic or thread safe manner. i.e wont fail during concurrent increments
	
	public UDPTicketManagementBackend(String ipAddress, Integer port) {
		 this.ipAddress = ipAddress;
		 this.port = port;
		 
	}

	public Message sendMessage(Object message){

		System.out.println("\t [Sender]: Trying to send message '");
		Message response = null;

		try (DatagramSocket sock = new DatagramSocket(null)) { // initializing datagramm socket
			
			// create address of recipient
			SocketAddress serverAddress = new InetSocketAddress(ipAddress, port); // creating socket address with ip address and port of server
			sock.connect(serverAddress); // connect to server
			
			// create packet
			ByteArrayOutputStream bStream = new ByteArrayOutputStream(); // data is sent as bytes or byte arrays across the network. 
																		//  Since complex objects cannot be directly converted to byte array therefore they have to be first serialized. Refer Serialization online. 
			ObjectOutput oo = new ObjectOutputStream(bStream); 
			oo.writeObject(message);
			oo.close();

			byte[] serializedMessage = bStream.toByteArray(); // Convert object stream to byte array
			
			DatagramPacket packet = new DatagramPacket(serializedMessage,
					serializedMessage.length, serverAddress); // Creating a datagram packet. This is packet is sent across the network which contains the data.

			// send packet
			sock.send(packet); 
			
			byte[] receiveData = new byte[8192]; // byte array created for response data
			
			 DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); // datagram packet created for response data
		     sock.receive(receivePacket);  // response recieved
		     
		     byte[] recievedBytes = receivePacket.getData(); // data is extracted from data gram packet
				
		     ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(recievedBytes)); // same as we sent data, just reverse the process 
		     response = (Message) iStream.readObject();
		     iStream.close();
		     
		     sock.close();
		     
		      
		} catch (IOException e) {
			// dummy exception handling
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return response;
	}
	
	@Override
	public void triggerShutdown() {
		
		
	}

	@Override
	/*
	 * Method to create new ticket
	 */
	public Ticket createNewTicket(String reporter, String topic, String description, Type type, Priority priority)
			throws TicketException {
		Ticket ticket = new Ticket(id.getAndIncrement(), reporter, topic, description, type, priority);
		Message Message = new Message(ticket, null, Constants.STORE_TICKET);
		sendMessage(Message);
		return ticket;
	}

	@Override
	/*
	 * Method to get all tickets
	 */
	public List<Ticket> getAllTickets() throws TicketException {

		List<Ticket> tickets = new ArrayList<>();
		Message Message = new Message(null, null, Constants.GET_ALL_TICKETS);
		Message response = sendMessage(Message);
		tickets.addAll(response.getResponse());
		return tickets;
	}

	@Override
	/*
	 * Method to get tickets by id
	 */
	public Ticket getTicketById(int id) throws TicketException {
		List<Ticket> tickets = getAllTickets();
		Ticket ticket = null;
		if(!tickets.isEmpty()){
			ticket = tickets.stream().filter(t -> t.getId() == id).collect(Collectors.toList()).get(0);
		}
			
		return ticket;
	}

	@Override
	/*
	 * Method to accept the ticket created
	 */
	public Ticket acceptTicket(int id) throws TicketException {
		Ticket ticketToModify = getTicketById(id);
		if (ticketToModify.getStatus() != Status.NEW) {
			throw new TicketException(
					"Can not reject Ticket as it is currently in status " + ticketToModify.getStatus());
		}
		Ticket ticket = new Ticket(id, null, null, null, null, null,Status.ACCEPTED);
		Message message = new Message(ticket, null, Constants.UPDATE_TICKET_STATUS);
		Message reply = sendMessage(message);
		return reply.getTicket();
	}

	@Override
	/*
	 * Method to reject the ticket created
	 */
	public Ticket rejectTicket(int id) throws TicketException {
		
		Ticket ticketToModify = getTicketById(id);
		if (ticketToModify.getStatus() != Status.NEW) {
			throw new TicketException(
					"Can not reject Ticket as it is currently in status " + ticketToModify.getStatus());
		}
		Ticket ticket = new Ticket(id, null, null, null, null, null,Status.REJECTED);
		Message message = new Message(ticket, null, Constants.UPDATE_TICKET_STATUS);
		Message reply = sendMessage(message);
		return reply.getTicket();

	}

	@Override
	/*
	 * Method to close accepted tickets
	 */
	public Ticket closeTicket(int id) throws TicketException {
		
		Ticket ticketToModify = getTicketById(id);
		if (ticketToModify.getStatus() != Status.ACCEPTED) {
			throw new TicketException(
					"Can not reject Ticket as it is currently in status " + ticketToModify.getStatus());
		}
		Ticket ticket = new Ticket(id, null, null, null, null, null,Status.CLOSED);
		Message message = new Message(ticket, null, Constants.UPDATE_TICKET_STATUS);
		Message reply = sendMessage(message);
		return reply.getTicket();
	}

}
