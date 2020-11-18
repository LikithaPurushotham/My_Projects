package de.uniba.rz.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.NamingException;

/**
 * This class is start point of server.
 * 
 * From here the control goes to classes implementing RemoteAccess as per the program arguments 
 * i.e. if program argument has gRPC, the control will to gRPCRemoteAccess which implements RemoteAccess
 * @author ADMIN
 *
 */
public class TicketServerMain {

	public static void main(String[] args) throws IOException, NamingException {
		TicketStore simpleTestStore = new SimpleTicketStore();

		// Returns the object of implementation of RemoteAccess as per the program arguments
		List<RemoteAccess> remoteAccessImplementations = getAvailableRemoteAccessImplementations(args);

		// Starting remote access implementations:
		for (RemoteAccess implementation : remoteAccessImplementations) {
			implementation.prepareStartup(simpleTestStore);
			// If you see RemoteAccess interface, it extends runnable. i.e. Its multi threaded and For each implementation, a new thread is started.
			new Thread(implementation).start();
		}

		// This is for server shutdown... Ignore
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

	/*
	 * This method returns the object of implementation of remote access as per the program arguments
	 */
	private static List<RemoteAccess> getAvailableRemoteAccessImplementations(String[] args) {
		List<RemoteAccess> implementations = new ArrayList<>();
		
		
		switch (args[0]){
			case "udp" :
				return Arrays.asList(new UDPRemoteAccess(Integer.parseInt(args[1])));
			
			case "jms" :
				return Arrays.asList(new JMSRemoteAccess(args[1], args[2]));
				
			case "gRPC" :
				return Arrays.asList(new GRPCRemoteAccess(Integer.parseInt(args[1])));
				
			case "jax" :
				return Arrays.asList(new JaxWSRemoteAccess());
				
		} 
			

		return implementations;
	}
}
