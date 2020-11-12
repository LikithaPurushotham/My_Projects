package de.uniba.rz.app.UDP_Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import de.uniba.rz.app.TicketManagementBackend;
import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.entities.Type;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;


public class UdpTicketClient implements TicketManagementBackend {
	
	HashMap<Integer, Ticket> udpTicketStore = new HashMap<>();
	private String host;

	AtomicInteger nextId;
	public UdpTicketClient(String host) {
		nextId = new AtomicInteger(1);
		this.host = host;
	}

	@Override
	public void triggerShutdown() {
		// TODO Auto-generated method stub

	}
	
	public void sendCreateTicket(Ticket ticket) {
		//System.out.println("\t [Sender]: Trying to send message '"+ticket+"'");
		// try-with-resources - automatically closes the socket sock
		try (DatagramSocket sock = new DatagramSocket(null)) {
			// create address of recipient
			SocketAddress serverAddress = new InetSocketAddress(host, 8081);

			  ByteArrayOutputStream outPut = new ByteArrayOutputStream();
		      ObjectOutputStream ObjOutS = new ObjectOutputStream(outPut);
		      ObjOutS .writeObject(ticket);
		      ObjOutS .flush();
			// create packet
			byte[] messageData = outPut.toByteArray();
			DatagramPacket packet = new DatagramPacket(messageData, messageData.length, serverAddress);
			// send packet
			sock.send(packet);
		} catch (IOException e) {
			// dummy exception handling
			e.printStackTrace();
		}

	}
	
	@Override
	public Ticket createNewTicket(String reporter, String topic, String description, Type type, Priority priority)
			throws TicketException {
		Ticket newTicket = new Ticket(nextId.getAndIncrement(), reporter, topic, description, type, priority);
		//udpTicketStore.put(newTicket.getId(), newTicket);
		sendCreateTicket(newTicket);
		return (Ticket) newTicket.clone();
	}

	@Override
	public List<Ticket> getAllTickets() throws TicketException {
		System.out.println("Request for ticket list.... ");
		
			try (DatagramSocket sock = new DatagramSocket(null)) {
				// create address of recipient
				SocketAddress serverAddress = new InetSocketAddress(host, 8082);
				DatagramPacket req = new DatagramPacket(new byte[1], 1, serverAddress);
				sock.send(req);
				
				byte[] data = new byte[65536];
				DatagramPacket packet = new DatagramPacket(data, data.length);
				while(true) {
					try {
						sock.receive(packet);
						try {
							byte[] receivedData = packet.getData();
							System.out.println(receivedData);
							List<Ticket> tempList = deserialize(receivedData);
							tempList.forEach((temp)->{
								udpTicketStore.put(temp.getId(), temp);
								System.out.println("[Ticket]: " + temp.toString() + udpTicketStore.size());
							});
							System.out.println("[Total ----- Ticket]: " + udpTicketStore.size());
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (SocketTimeoutException e) {
						// swallow timeout
						 e.printStackTrace();
						System.out.println("[Ticket]: received count " + udpTicketStore.size());
					}
					return udpTicketStore.entrySet().stream().map(entry -> (Ticket) entry.getValue().clone())
							.collect(Collectors.toList());
				}
			} catch (IOException e) {
				// dummy exception handling
				e.printStackTrace();
			}
			System.out.println("[Ticket]: received count " + udpTicketStore.size());
			return udpTicketStore.entrySet().stream().map(entry -> (Ticket) entry.getValue().clone())
					.collect(Collectors.toList());
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Ticket> deserialize(byte[] data) throws IOException, ClassNotFoundException {
		System.out.println("converting object list.");
	    ByteArrayInputStream in = new ByteArrayInputStream(data);
	    ObjectInputStream is = new ObjectInputStream(in);
	    return (List<Ticket>)is.readObject();
	}
	
	@Override
	public Ticket getTicketById(int id) throws TicketException {
		// TODO Auto-generated method stub
		if (!udpTicketStore.containsKey(id)) {
			throw new TicketException("Ticket ID is unknown");
		}

		return (Ticket) getTicketByIdInteral(id).clone();
	}
	private Ticket getTicketByIdInteral(int id) throws TicketException {
		if (!udpTicketStore.containsKey(id)) {
			throw new TicketException("Ticket ID is unknown");
		}

		return udpTicketStore.get(id);
	}
	
	public void sendUpdateTicket(String updatedTicket) {
		System.out.println("\t [Sender]: Trying to update ticket '"+updatedTicket+"'");
		// try-with-resources - automatically closes the socket sock
		try (DatagramSocket sock = new DatagramSocket(null)) {
			// create address of recipient
			SocketAddress serverAddress = new InetSocketAddress(host, 8083);
			byte[] messageData = updatedTicket.getBytes();
			DatagramPacket packet = new DatagramPacket(messageData, messageData.length, serverAddress);
			// send packet
			sock.send(packet);
		} catch (IOException e) {
			// dummy exception handling
			e.printStackTrace();
		}

	}

	@Override
	public Ticket acceptTicket(int id) throws TicketException {
		// TODO Auto-generated method stub
		Ticket ticketToModify = getTicketByIdInteral(id);
		if (ticketToModify.getStatus() != Status.NEW) {
			throw new TicketException(
					"Can not accept Ticket as it is currently in status " + ticketToModify.getStatus());
		}

		sendUpdateTicket(id + " " +Status.ACCEPTED + " ");
		ticketToModify.setStatus(Status.ACCEPTED);
		return (Ticket) ticketToModify.clone();
	}

	@Override
	public Ticket rejectTicket(int id) throws TicketException {
		// TODO Auto-generated method stub
		Ticket ticketToModify = getTicketByIdInteral(id);
		if (ticketToModify.getStatus() != Status.NEW) {
			throw new TicketException(
					"Can not reject Ticket as it is currently in status " + ticketToModify.getStatus());
		}

		sendUpdateTicket(id + " " +Status.REJECTED + " ");
		ticketToModify.setStatus(Status.REJECTED);
		return (Ticket) ticketToModify.clone();
	}

	@Override
	public Ticket closeTicket(int id) throws TicketException {
		// TODO Auto-generated method stub
		Ticket ticketToModify = getTicketByIdInteral(id);
		if (ticketToModify.getStatus() != Status.ACCEPTED) {
			throw new TicketException(
					"Can not close Ticket as it is currently in status " + ticketToModify.getStatus());
		}

		sendUpdateTicket(id + " " +Status.CLOSED + " ");
		ticketToModify.setStatus(Status.CLOSED);
		return (Ticket) ticketToModify.clone();
	}

}
