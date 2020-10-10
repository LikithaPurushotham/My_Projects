package de.uniba.rz.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import de.uniba.rz.backend.AMQPServer.AMQPRemoteAccess;
import de.uniba.rz.backend.UDP_Server.UdpBCTickets;
import de.uniba.rz.backend.UDP_Server.UdpReceiveTicketRA;
//import de.uniba.rz.backend.udp.remote.implementation.UdpRemoteAccess;
import de.uniba.rz.backend.UDP_Server.UdpTicketStatusUpdate;

public class TicketServerMain {

	public static void main(String[] args) throws IOException, NamingException {
		TicketStore simpleTestStore = new SimpleTicketStore();

		List<RemoteAccess> remoteAccessImplementations = getAvailableRemoteAccessImplementations(args);
		
		// Starting remote access implementations:
		for (RemoteAccess implementation : remoteAccessImplementations) {
			implementation.prepareStartup(simpleTestStore);
			new Thread(implementation).start();
		}
		 
		try (BufferedReader shutdownReader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Press enter to shutdown system.");
			shutdownReader.readLine();
			System.out.println("Shutting down...");
	
			// Shuttung down all remote access implementations
			for (RemoteAccess implementation : remoteAccessImplementations) {
				implementation.shutdown();
			}
			System.out.println("completed. Bye!");
		}
	}

	private static List<RemoteAccess> getAvailableRemoteAccessImplementations(String[] args) {
		List<RemoteAccess> implementations = new ArrayList<>();
		System.out.println("Server listening. ");
		// TODO Add your implementations of the RemoteAccess interface
		// e.g.:
		//implementations.add(new UdpRemoteAccess(Integer.parseInt(args[0])));
        implementations.add(new UdpReceiveTicketRA(8081));
        implementations.add(new UdpBCTickets(8082));
        implementations.add(new UdpTicketStatusUpdate(8083));
        // Default Push-API for AMQP provided
        implementations.add(new AMQPRemoteAccess(args[0],args[1]));
		return implementations;
	}
}
