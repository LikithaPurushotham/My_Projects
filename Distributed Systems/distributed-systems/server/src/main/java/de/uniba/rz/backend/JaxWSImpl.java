package de.uniba.rz.backend;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.jws.WebService;

import de.uniba.rz.entities.Message;
import de.uniba.rz.entities.TicketSearch;

@WebService(endpointInterface="de.uniba.rz.backend.JaxWsInterface")
public class JaxWSImpl implements JaxWsInterface {

	public static TicketStore ticketStore = new JaxWSTicketStore();
	
	@Override
	public Message sendMessage(Message message) {
		
		try {
			ExecutorService executorService = Executors.newCachedThreadPool();
			Future<Message> response = executorService.submit( new JaxWSMessageHandler(ticketStore, message));
			return response.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		return new Message();
		
	}

	@Override
	public Message searchMessage(TicketSearch ticketSearch)  {
		try {
			
			
			ExecutorService executorService = Executors.newCachedThreadPool();
			
			// get searched response
			Future<Message> response = executorService.submit( new JaxWSSearchHandler(ticketStore, ticketSearch));
			return response.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		return new Message();
	}

	
}
