package de.uniba.rz.backend;

import javax.xml.ws.Endpoint;

import de.uniba.rz.entities.Constants;

public class JaxWSRemoteAccess implements RemoteAccess {

	@Override
	public void run() {
		Endpoint endpoint = Endpoint.create(new JaxWSImpl());
		endpoint.publish(Constants.SERVER_WEB_SERVICE_URL+"?wsdl");
		System.out.println("Server ready to serve your JAX-WS requests...");
		
	}

	@Override
	public void prepareStartup(TicketStore ticketStore) {
		
	}

	@Override
	public void shutdown() {
		
	}

}
