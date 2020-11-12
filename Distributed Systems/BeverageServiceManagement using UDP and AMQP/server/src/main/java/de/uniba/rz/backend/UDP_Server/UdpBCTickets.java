package de.uniba.rz.backend.UDP_Server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import de.uniba.rz.backend.RemoteAccess;
import de.uniba.rz.backend.TicketStore;

public class UdpBCTickets implements RemoteAccess {

	private int serverPort;
	private boolean isActive;
	TicketStore ticketStore;
	
	public UdpBCTickets(int port){
		this.serverPort = port;
		this.isActive = false;
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		System.out.println("Server is listening on port : " + serverPort);
		isActive = true;
		try (DatagramSocket serverSocket = new DatagramSocket(null)) {
			// create socket address
			SocketAddress address = new InetSocketAddress(serverPort);
			// and bind the socket to this address
			serverSocket.bind(address);
			while (isActive) {
				byte[] ini = new byte[1];
				DatagramPacket packet = new DatagramPacket(ini, ini.length);
				serverSocket.receive(packet);
				System.out.println("Request received for data......... " + serverPort);
				try {
					 ByteArrayOutputStream outPut = new ByteArrayOutputStream();
				     ObjectOutputStream objoutPut = new ObjectOutputStream(outPut); 
				     synchronized(ticketStore) {
				    	 objoutPut.writeObject(ticketStore.getAllTickets());
					     objoutPut.flush(); 
				     }
				     byte[] messageData = outPut.toByteArray();
				     DatagramPacket packet1 = new DatagramPacket(messageData, messageData.length, packet.getSocketAddress());
				     //serverSocket.setBroadcast(true);
				     serverSocket.send(packet1);
				     ticketStore.getAllTickets().forEach((ticket)->{
				    	 System.out.println("\t [SERVER]: send ticket list Packet." + ticket.toString());
				     });
				} catch (SocketTimeoutException e) {
					// swallow timeout
					e.printStackTrace();
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
	public void prepareStartup(TicketStore tStore) {
		// TODO Auto-generated method stub
		isActive = true;
		ticketStore = tStore;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		this.isActive = false;
		System.out.println("Server Stopped.");
	}

}
