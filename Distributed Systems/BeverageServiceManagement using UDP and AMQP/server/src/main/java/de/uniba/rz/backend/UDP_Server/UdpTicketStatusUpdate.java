package de.uniba.rz.backend.UDP_Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import de.uniba.rz.backend.RemoteAccess;
import de.uniba.rz.backend.TicketStore;
import de.uniba.rz.entities.Status;

public class UdpTicketStatusUpdate implements RemoteAccess {

	private int serverPort;
	private boolean isActive;
	TicketStore ticketStore;
	
	public UdpTicketStatusUpdate(int port) {
		this.serverPort = port;
		this.isActive = false;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Server is listening on port : " + serverPort);
		isActive = true;
		try (DatagramSocket serverSocket = new DatagramSocket(null)) {
			// create socket address and bind the socket to this address
			SocketAddress address = new InetSocketAddress(serverPort);
			serverSocket.bind(address);
			
			while (isActive) {
				// prepare packet to receive data
				byte[] data = new byte[100];
				DatagramPacket packet = new DatagramPacket(data, data.length);
				try {
					// wait for packet
					serverSocket.receive(packet);
					String receiveData = new String(packet.getData());
					System.out.println("\t [SERVER]: Received Packet. update ticketing status." + receiveData + receiveData.length());
					String receivedData = receiveData.replaceAll("\\s+", "");
					System.out.println("\t [SERVER]: Received Packet. update ticketing status." + receivedData + receivedData.length());
					String ticketStatus[] = receiveData.split(" ");
					synchronized(ticketStore) {
						ticketStore.getAllTickets().forEach((ticket)->{
							if(ticket.getId() == Integer.parseInt(ticketStatus[0])) {
								System.out.println("------ setting up ticket.... " + ticketStatus[0] + ticketStatus[1]);
								switch(ticketStatus[1]) {
									case "ACCEPTED":
										ticket.setStatus(Status.ACCEPTED);
										break;
									case "REJECTED":
										ticket.setStatus(Status.REJECTED);
										break;
									case "CLOSED":
										ticket.setStatus(Status.CLOSED);
										break;
									default:
										System.out.println("------ setting up ticket.... " + ticketStatus[0] + ticketStatus[1]);								}
								
							}
						});
					}
				} catch (SocketTimeoutException e) {
					
				}
			}
		} catch (SocketException e) {
			// dummy exception handling - do NOT do this in your Assignment!
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			// dummy exception handling - do NOT do this in your Assignment!
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void prepareStartup(TicketStore ticketStore) {
		// TODO Auto-generated method stub
		isActive = true;
		this.ticketStore = ticketStore;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		this.isActive = false;
		System.out.println("Server Stopped.");
	}

}
