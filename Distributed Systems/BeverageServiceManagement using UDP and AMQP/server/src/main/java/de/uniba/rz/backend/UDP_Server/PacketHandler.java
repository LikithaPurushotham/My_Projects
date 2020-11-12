package de.uniba.rz.backend.UDP_Server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import de.uniba.rz.backend.TicketStore;
import de.uniba.rz.entities.Ticket;

public class PacketHandler extends Thread {
	
	private final DatagramPacket packet;
	private TicketStore ticketStore;

	public PacketHandler(DatagramPacket packet, TicketStore store) {
		this.packet = packet;
		this.ticketStore = store;
	}

	public synchronized void run() {
		System.out.println("\t [PacketHandler [id:"+this.getId()+"]: Handling received packet.");
		// process received packet
		byte[] receivedData = packet.getData();
		try {
			Ticket ticket = (Ticket)deserialize(receivedData);
			synchronized(ticketStore) {
				ticketStore.storeNewTicket(ticket.getReporter(), ticket.getTopic(), ticket.getDescription(), ticket.getType(), ticket.getPriority());
			}			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void SearchTicket() {
		
	}
	
	public Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
	    ByteArrayInputStream in = new ByteArrayInputStream(data);
	    ObjectInputStream is = new ObjectInputStream(in);
	    return is.readObject();
	}
}
