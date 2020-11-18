package de.uniba.rz.backend;

import java.util.Hashtable;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 * This is first step after the server is started
 * @author ADMIN
 *
 */

public class JMSRemoteAccess implements RemoteAccess {

	private ConnectionFactory connectionFactory;
	private Destination destination;
	private boolean active;
	String connFactoryLookup;
	String destinationLookup;
	Context context;
	
	
	public JMSRemoteAccess(String connFactoryLookup, String destinationLookup) {
 
		this.connFactoryLookup = connFactoryLookup;
		this.destinationLookup = destinationLookup;
	}
	
	
	@Override
	public void run() {
		System.out.println("\t [RECEIVER]: Start waiting for messages");
		active = true;

		try (JMSContext jmsContext = connectionFactory.createContext()) {

			// a consumer is created to get data from queue. Here destination is the queue.
			JMSConsumer consumer = jmsContext.createConsumer(destination);
			TicketStore ticketStore = new JMSTicketStore();
			while (active) {
				// get data from consumer. As mentioned on client side, data is sent as ObjectMessage in JMS.
				ObjectMessage om = (ObjectMessage) consumer.receive();
				System.out.println("\t Message Recieved. Creating new Thread ");
				new Thread(new JMSMessageHandler(om, ticketStore, jmsContext)).start();
				
			}
		} catch (NamingException e) {

			e.printStackTrace();
		} 
		System.out.println("\t [RECEIVER]: Stopped.");
		
	}

	@Override
	public void prepareStartup(TicketStore ticketStore) {
		Hashtable<String, String> contextParams = new Hashtable<>();

		try {

			// similar to client side implementation
			contextParams.put(Context.INITIAL_CONTEXT_FACTORY,
					"com.sun.jndi.fscontext.RefFSContextFactory");

			contextParams.put(Context.PROVIDER_URL, "file:///D:/IdsMQFolder");

			context = new InitialContext(contextParams);
			
			connectionFactory = (ConnectionFactory) context.lookup(connFactoryLookup);
			destination = (Destination) context.lookup(destinationLookup);
		} catch (NamingException e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void shutdown() {
		active = false;
		try {
			context.close();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		
	}

}
