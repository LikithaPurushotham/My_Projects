package de.uniba.rz.jaxRS;

import java.net.URI;
import java.util.Properties;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import de.uniba.rz.backend.RemoteAccess;
import de.uniba.rz.backend.TicketStore;

public class JaxRsServerStart implements RemoteAccess{
    private static Properties properties = Configuration.loadProperties();
    private TicketStore ticketStoreMain;
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String serverUri = properties.getProperty("serverUri");

        URI baseUri = UriBuilder.fromUri(serverUri).build();
        ResourceConfig config = ResourceConfig.forApplicationClass(TicketApi.class);
        JdkHttpServerFactory.createHttpServer(baseUri, config);
        System.out.println("Server ready to serve your JAX-RS requests... " + serverUri);
	}

	@Override
	public void prepareStartup(TicketStore ticketStore) {
		// TODO Auto-generated method stub
		ticketStoreMain = ticketStore;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}
}
