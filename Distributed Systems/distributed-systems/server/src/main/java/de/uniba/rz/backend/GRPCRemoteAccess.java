package de.uniba.rz.backend;

import java.io.IOException;

import de.uniba.rz.io.rpc.MessageTransferObject;
import de.uniba.rz.io.rpc.TicketManagementServiceGrpc.TicketManagementServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;



/**
 * This is first step after the server is started
 * @author ADMIN
 *
 */
public class GRPCRemoteAccess implements RemoteAccess{
	
	
	private final int port;
    private final Server server;
    private static TicketStore ticketStore;
    
    
	public GRPCRemoteAccess(int port) {
		this.port = port;
		this.server = ServerBuilder.forPort(port).addService(new GRPCImpl()).build();
		GRPCRemoteAccess.ticketStore = new GRPCTicketStore();
		
	}

	
	static class GRPCImpl extends TicketManagementServiceImplBase {

		/*
		 * The message sent from client side is retrieved in this method. After processing, it is returned back to client via responseObserver.
		 * (non-Javadoc)
		 * @see de.uniba.rz.io.rpc.TicketManagementServiceGrpc.TicketManagementServiceImplBase#send(de.uniba.rz.io.rpc.MessageTransferObject, io.grpc.stub.StreamObserver)
		 */
        @Override
        public void send(MessageTransferObject request, StreamObserver<MessageTransferObject> responseObserver) {
            System.out.println("Receiving message ");
            if(request != null){
            	
            	// For each message, new thread for message handler is created for parallel processing.
            	new Thread(new GRPCMessageHandler(request, ticketStore, responseObserver)).start();
            }

        }
    }
	
	@Override
	public void run() {
		 if (server != null) {
	            try {
					server.awaitTermination();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	      }		
	}

	@Override
	public void prepareStartup(TicketStore ticketStore) {
		try {
			server.start();
			System.out.println("Server started and listened on port " + this.port);
		} catch (IOException e) {
			 System.err.println("*** shutting down gRPC server since JVM is shutting down");
             server.shutdown();
             System.err.println("*** server shut down");
             e.printStackTrace();
		}
	}

	@Override
	public void shutdown() {
		 if (server != null) {
	            server.shutdown();
		 }
		
	}

}
