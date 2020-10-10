package de.uniba.rz.backend.AMQPServer;

import com.rabbitmq.client.*;
import de.uniba.rz.backend.RemoteAccess;
import de.uniba.rz.backend.TicketStore;
import de.uniba.rz.backend.UnknownTicketException;
import de.uniba.rz.entities.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

public class AMQPRemoteAccess implements RemoteAccess {
    private String hostname;
    private String queue;
    private TicketStore tks;
    private  String reply_to;
    private final ConnectionFactory connFactory = new ConnectionFactory();

    public AMQPRemoteAccess(String hostname, String queue){
        this.hostname = hostname;
        this.queue = queue;
    }

    public byte[] prepare(MQMessage message) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(message);
        oos.flush();
        byte[] messageData = bos.toByteArray();
        return messageData;
    }

    @Override
    public void prepareStartup(TicketStore ticketStore) {
        this.tks = ticketStore;
    }

    @Override
    public void shutdown() {
        Thread.currentThread().interrupt();
    }

    @Override
    public void run() {
        // Data structure exchanging data between the receiver's thread and the dispatcher thread
        final BlockingQueue<byte []> blockingQueue = new ArrayBlockingQueue<byte[]>(1, true);
        // Note: Could be omitted because localhost is set be default
        connFactory.setHost(this.hostname);

        System.out.println("AMQP listener started");

        try (Connection connection = connFactory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(this.queue, true, false, false, null);
            channel.exchangeDeclare("broadcast", "fanout");

            // Ensure that we will only get one message at a time from RabbitMQ
            channel.basicQos(1);

            /*
             * This method registers a consumer on the queue by the usage of the consumerTag and a callback object.
             * We pass the callback object DefaultConsumer, which implements the interface Consumer.
             * A dispatcher thread within the Java Client Library will call the methods
             * within this interface, for example, handleDelivery(...). Hence, we have to provide an implementation
             * to achieve a certain behavior.
             *
             * NOTE: PushQueueReceiver will not call the implemented methods of that interface!
             * These methods are called by the thread pool of the dispatcher (one per connection)!
             */
            // TODO: think of an appropriate strategy to handle the acknowledgement
            channel.basicConsume(this.queue, true, "myConsumerTag", new DefaultConsumer(channel) {

                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    try {
                        // After receiving, add the message to a thread-safe data structure, like a BlockingQueue
                        blockingQueue.put(body);
                        reply_to = properties.  getReplyTo();
                        System.out.println(properties.getReplyTo());
                    } catch (InterruptedException e) {
                        // Preserve the interrupt for the caller (channel's thread pool)
                        Thread.currentThread().interrupt();
                    }
                }
            });

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    /* The PushQueueReceiver thread will wait until a message becomes available.
                     * Because we will receive messages asynchronously, this may need an indefinite amount of time.
                     * PushQueueReceiver will be suspended (by calling take()) from the CPU while it is waiting for a message (No Pull-API!)
                     */
                    ByteArrayInputStream in = new ByteArrayInputStream(blockingQueue.take());
                    ObjectInputStream is = new ObjectInputStream(in);
                    MQMessage receivedMessage = (MQMessage) is.readObject();
                    is.close();
                    MQMessage response = new MQMessage();
                    switch(receivedMessage.getMethod()){
                        case Constants.ADD:
                            Ticket receivedTicket = receivedMessage.getTicket();
                            response.setTicket(tks.storeNewTicket(receivedTicket.getReporter(),receivedTicket.getTopic(),receivedTicket.getDescription(),
                                    receivedTicket.getType(),receivedTicket.getPriority()));
                            channel.basicPublish("broadcast", "", null, Constants.UPDATE_AVAILABLE.getBytes());
                            break;
                        case Constants.GETALL:
                            response.setResponseTickets(tks.getAllTickets());
                            break;
                        case Constants.GETFROMID:
                            for (Ticket ticket : tks.getAllTickets()) {
                                if (ticket.getId() == Integer.parseInt(receivedMessage.getMessage())) {
                                    response.setTicket(ticket);
                                    break;
                                }
                            }
                            if(response.getTicket()==null){
                                response.setMessage("Ticket ID is unknown");
                            }
                            break;
                        case Constants.ACCEPT:
                            for (Ticket ticket : tks.getAllTickets()) {
                                if (ticket.getId() == Integer.parseInt(receivedMessage.getMessage())) {
                                    if (ticket.getStatus() == Status.NEW) {
                                        tks.updateTicketStatus(ticket.getId(), Status.ACCEPTED);
                                        ticket.setStatus(Status.ACCEPTED);
                                        response.setTicket(ticket);
                                        channel.basicPublish("broadcast", "", null, Constants.UPDATE_AVAILABLE.getBytes());
                                    }else{
                                        response.setMessage("Cannot accept Ticket as it is currently in status " + ticket.getStatus());
                                    }
                                    break;
                                }
                            }
                            break;
                        case Constants.REJECT:
                            for (Ticket ticket : tks.getAllTickets()) {
                                if (ticket.getId() == Integer.parseInt(receivedMessage.getMessage())) {
                                    if (ticket.getStatus() == Status.NEW) {
                                        tks.updateTicketStatus(ticket.getId(), Status.REJECTED);
                                        ticket.setStatus(Status.REJECTED);
                                        response.setTicket(ticket);
                                        channel.basicPublish("broadcast", "", null, Constants.UPDATE_AVAILABLE.getBytes());
                                    }else{
                                        response.setMessage("Cannot reject Ticket as it is currently in status " + ticket.getStatus());
                                    }
                                    break;
                                }
                            }
                            break;
                        case Constants.CLOSE:
                            for (Ticket ticket : tks.getAllTickets()) {
                                if (ticket.getId() == Integer.parseInt(receivedMessage.getMessage())) {
                                    if (ticket.getStatus() == Status.ACCEPTED) {
                                        tks.updateTicketStatus(ticket.getId(), Status.CLOSED);
                                        ticket.setStatus(Status.CLOSED);
                                        response.setTicket(ticket);
                                        channel.basicPublish("broadcast", "", null, Constants.UPDATE_AVAILABLE.getBytes());
                                    }else{
                                        response.setMessage("Cannot close Ticket as it is currently in status " + ticket.getStatus());
                                    }
                                    break;
                                }
                            }
                            break;

                    }
                    channel.basicPublish("", reply_to, null, prepare(response));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (UnknownTicketException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            // TODO: Think of an appropriate exception handling strategy (e.g., retrying, logging, ...)
            e.printStackTrace();
        } catch (TimeoutException e) {
            // TODO: Think of an appropriate exception handling strategy (e.g., retrying, logging, ...)
            e.printStackTrace();
        }
    }
}

