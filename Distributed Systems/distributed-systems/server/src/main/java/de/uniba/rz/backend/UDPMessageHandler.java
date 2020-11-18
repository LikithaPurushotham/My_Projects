package de.uniba.rz.backend;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.List;

import de.uniba.rz.entities.Constants;
import de.uniba.rz.entities.Message;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;

public class UDPMessageHandler extends Constants implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2902680453447661114L;
	private DatagramPacket datagramPacket;
	private DatagramSocket serverSocket;
	private TicketStore ticketStore;
	
	public UDPMessageHandler(DatagramPacket datagramPacket, DatagramSocket serverSocket, TicketStore ticketStore) {
		
		this.datagramPacket = datagramPacket;
		this.serverSocket = serverSocket;
		this.ticketStore = ticketStore;
	}
	
	@Override
	public void run() {

		try {
			handleresponse();
		} catch (TicketException e) {
			e.printStackTrace();
		}
	}
	
	private void handleresponse() throws TicketException{
		
		// handle packet externally in another thread
		byte[] recievedBytes = datagramPacket.getData();
		
		ObjectInputStream iStream;
		try {
			iStream = new ObjectInputStream(new ByteArrayInputStream(recievedBytes));
			Message message = (Message) iStream.readObject();
			iStream.close();
			
			String operation = message.getOperation();
			
			 
			Message response = new Message();
			switch(operation) {
			
				case STORE_TICKET:
					Ticket ticket = ticketStore.storeNewTicket(message.getTicket().getReporter(), message.getTicket().getTopic(), message.getTicket().getDescription(), message.getTicket().getType(), message.getTicket().getPriority());
					response.setResponse(Arrays.asList(ticket));
					break;
				
				case GET_ALL_TICKETS:
					List<Ticket> tickets = ticketStore.getAllTickets();
					response.setResponse(tickets);
					break;
					
				case UPDATE_TICKET_STATUS:
					ticketStore.updateTicketStatus(message.getTicket().getId(), message.getTicket().getStatus());
					response.setResponse(Arrays.asList(message.getTicket()));
					break;
				
				default :
					System.out.println("Invalid operation");
				
					
					
			}
			
			ByteArrayOutputStream bStream = new ByteArrayOutputStream();
			ObjectOutput oo = new ObjectOutputStream(bStream); 
			oo.writeObject(response);
			oo.close();

			byte[] serializedMessage = bStream.toByteArray();
			
			DatagramPacket packet = new DatagramPacket(serializedMessage,
					serializedMessage.length, datagramPacket.getAddress(),datagramPacket.getPort());

			// send packet
			serverSocket.send(packet);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (UnknownTicketException e) {
			e.printStackTrace();
		}
		
	}

}
