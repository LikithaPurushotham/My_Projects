package de.uniba.rz.backend.UDP_Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import de.uniba.rz.backend.TicketStore;
import java.net.SocketTimeoutException;
import de.uniba.rz.backend.RemoteAccess;

public class UdpReceiveTicketRA implements RemoteAccess {

	
	private int serverPort;
	private boolean isActive;
	TicketStore store;
	
	public UdpReceiveTicketRA(int port) {
		this.serverPort = port;
		this.isActive = false;
	}
	@Override
	public void run() {
		
		System.out.println("Server is listening on port : " + serverPort);
		isActive = true;
		try (DatagramSocket serverSocket = new DatagramSocket(null)) {
			// create socket address
			SocketAddress address = new InetSocketAddress(serverPort);
			// and bind the socket to this address
			serverSocket.bind(address);
			// set timeout time to 5000ms
			serverSocket.setSoTimeout(5000);

			while (isActive) {
	
				// prepare packet to receive data
				byte[] data = new byte[65536];
				DatagramPacket packet = new DatagramPacket(data, data.length);
				try {
					// wait for packet
					serverSocket.receive(packet);
					System.out.println("\t [SERVER]: Received Packet. Creating new Thread to handle it.");
					// handle packet externally in another thread
					new PacketHandler(packet, store).start();
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
		isActive = true;
		store = ticketStore;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		this.isActive = false;
		System.out.println("Server Stopped.");
	}

}
