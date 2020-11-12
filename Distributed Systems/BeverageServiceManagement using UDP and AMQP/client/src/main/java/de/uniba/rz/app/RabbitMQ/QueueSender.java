package de.uniba.rz.app.RabbitMQ;

import com.rabbitmq.client.*;
import de.uniba.rz.entities.MQMessage;

import java.io.*;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

public class QueueSender {

    private final String hostname;
    private final String routingKey;
    private MQMessage receivedMessage;
    private final ConnectionFactory connFactory = new ConnectionFactory();
    private String replyQueue = null;

    public QueueSender(String hostname, String routingKey) {
        this.hostname = hostname;
        this.routingKey = routingKey;
    }

    private byte[] prepare(MQMessage message) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(message);
        oos.flush();
        byte[] messageData = bos.toByteArray();
        return messageData;
    }

    private MQMessage deserialize(byte[] receivedBytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(receivedBytes);
        ObjectInputStream is = new ObjectInputStream(in);
        MQMessage receivedMessage = (MQMessage) is.readObject();
        is.close();
        return receivedMessage;
    }

    public MQMessage sendMessage(MQMessage message) {
        BlockingQueue<byte []> blockingQueue = new ArrayBlockingQueue<byte[]>(1, true);
        // Note: Could be omitted because localhost is set be default
        connFactory.setHost(hostname);
        try (Connection connection = connFactory.newConnection();) {
            Channel channel = connection.createChannel();
            if(replyQueue == null){
                //To create a queue with unique name, we generate random name with UUID
                // Then we check if any queue with that name already existsa and if not we declare the queue.
                try{
                    while(true){
                        replyQueue = UUID.randomUUID().toString();
                        channel.queueDeclarePassive(replyQueue);
                    }
                }catch (IOException e){
                    channel = connection.createChannel();
                    channel.queueDeclare( replyQueue,false, false, false, null );
                }
            }

            /*
             * Note that the declared queue is automatically bound to the pre-declared (default) exchange of RabbitMQ.
             * The address of the exchange is an empty string ("") and the type is always "direct".
             * The name of the queue will be the binding key that is evaluated against the routing key determining an incoming message's destination.
             * That implies that it is impossible to send a message directly to the queue from the client's side.
             * The message always has to pass an exchange.
             */
            channel.queueDeclare(routingKey, true, false, false, null);
            /*
             * Alternative - Passive Declaration: Just check if the queue has already been created.
             * This is non-operational (no-op) and may cause an IOException if there is no queue.
             * Passive declaration does no redeclaration
             */
            //channel.queueDeclarePassive(routingKey);

            // It might be a good practice to define a custom exchange with an explicit binding of the previously declared queue.
            // TODO: What are the necessary steps to that and which type of exchange should be used?
           // channel.queueDeclare(replyQueue, false, false, false, null);
            // Send message to the default exchange ("") with the queueName as routing key
            channel.basicPublish("", routingKey,new AMQP.BasicProperties(null,null,null,2,null,null,
                    replyQueue,null,null,null,null,null,null,null), prepare(message));
            channel.basicConsume(replyQueue, true, "clientReceiver", new DefaultConsumer(channel) {

                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    try {
                       blockingQueue.put(body);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            receivedMessage=deserialize(blockingQueue.take());
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return receivedMessage;
    }
}