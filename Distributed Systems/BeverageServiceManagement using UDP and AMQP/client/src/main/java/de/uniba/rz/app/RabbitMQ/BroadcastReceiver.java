package de.uniba.rz.app.RabbitMQ;

import com.rabbitmq.client.*;
import de.uniba.rz.entities.Constants;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class BroadcastReceiver implements Runnable {
    BroadcastReceiver(){}
    private final ConnectionFactory connFactory = new ConnectionFactory();

    @Override
    public void run() {
        try (Connection connection = connFactory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare("broadcast", "fanout");
            // creates queue with unique name when queue declare is called with no queuename param.
            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, "broadcast", "");

            channel.basicConsume(queueName, true, "myConsumerTag", new DefaultConsumer(channel) {

                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String message = new String(body);
                    System.out.println("Change in ticketstore. Refresh the client...");
                }
            });

            while (!Thread.currentThread().isInterrupted()) {

            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

