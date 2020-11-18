package de.uniba.rz.backend;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Scanner;

/**
 * This is first step after the server is started
 * @author ADMIN
 *
 */
public class UDPRemoteAccess implements RemoteAccess {
	
	int port;
	boolean active = false;
	
	public UDPRemoteAccess(int port) {
		this.port = port;
	}

	@Override
	public void run() {


		if (port == 0) {
			System.out
					.println("Invalid usage. One argument needed: java ServerMain <port>");
		} else {
			try {
				// Start the thread
				System.out.println("\t [SERVER]: Start listening on port " + port
						+ " for messages.");
				active = true;
				TicketStore ticketStore = new UDPTicketStore();
				// try-with-resources, create unbound serverSocket
				// similar is done on client side
				try (DatagramSocket serverSocket = new DatagramSocket(null)) {
					// create socket address
					SocketAddress address = new InetSocketAddress(port);
					serverSocket.bind(address);
					serverSocket.setSoTimeout(600000000);

					while (active) {
						// prepare packet to receive data
						byte[] data = new byte[8192];
						DatagramPacket packet = new DatagramPacket(data, data.length);
						try {

							serverSocket.receive(packet);
							System.out.println("\t [SERVER]: Received Packet. "
									+ "Creating new Thread to handle it.");

							// For each message, a new thread of message handler is started, so that each message can be processed parallely.
							new Thread(new UDPMessageHandler(packet, serverSocket, ticketStore)).start();
							
						} catch (SocketTimeoutException e) {
							System.out.println("Socket timed out");
						}
					}
				} catch (SocketException e) {

					e.printStackTrace();
					System.exit(1);
				} catch (IOException e) {

					e.printStackTrace();
					System.exit(1);
				}
				System.out.println("\t [SERVER]: Stopped.");
			

				// And wait for input
				Scanner scanner = new Scanner(System.in);
				System.out.println("Hit Enter to stop the server.");
				scanner.nextLine();
				scanner.close();

				
			} catch (NumberFormatException e) {
				System.out.println("Portnumber is invalid");
			}
		}
	
		
	}

	@Override
	public void prepareStartup(TicketStore ticketStore) {

		
	}

	@Override
	public void shutdown() {

		
	}

}
