package de.uniba.rz.app.RabbitMQ;

import de.uniba.rz.app.TicketManagementBackend;
import de.uniba.rz.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MQTicketManagementBackend implements TicketManagementBackend {

    AtomicInteger nextId;
    String hostname;
    String routingKey;
    QueueSender qs;

    public MQTicketManagementBackend(String hostname, String routingKey) {
        this.hostname=hostname;
        this.routingKey=routingKey;
        nextId = new AtomicInteger(1);
        qs = new QueueSender(hostname, routingKey);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver();
        new Thread(broadcastReceiver).start();
    }

    @Override
    public Ticket createNewTicket(String reporter, String topic, String description, Type type, Priority priority) throws TicketException {
        Ticket newTicket = new Ticket(nextId.getAndIncrement(), reporter, topic, description, type, priority);
        MQMessage msg = new MQMessage();
        msg.setTicket(newTicket);
        msg.setMethod(Constants.ADD);
        MQMessage received = qs.sendMessage(msg);
        return received.getTicket();
    }

    @Override
    public List<Ticket> getAllTickets() throws TicketException {
        MQMessage msg = new MQMessage();
        msg.setMethod(Constants.GETALL);
        MQMessage received = qs.sendMessage(msg);
        return received.getResponseTickets();
    }

    @Override
    public Ticket getTicketById(int id) throws TicketException {
       MQMessage msg = new MQMessage();
       msg.setMethod(Constants.GETFROMID);
       msg.setMessage(String.valueOf(id));
       MQMessage received = qs.sendMessage(msg);
       if(received.getTicket()!= null){
           return received.getTicket();
       }else {
           throw new TicketException(received.getMessage());
       }
    }

    @Override
    public Ticket acceptTicket(int id) throws TicketException {
        MQMessage msg = new MQMessage();
        msg.setMethod(Constants.ACCEPT);
        msg.setMessage(String.valueOf(id));
        MQMessage received = qs.sendMessage(msg);
        if(received.getTicket()!= null){
            return received.getTicket();
        }else {
            throw new TicketException(received.getMessage());
        }
    }

    @Override
    public Ticket rejectTicket(int id) throws TicketException {
        MQMessage msg = new MQMessage();
        msg.setMethod(Constants.REJECT);
        msg.setMessage(String.valueOf(id));
        MQMessage received = qs.sendMessage(msg);
        if(received.getTicket()!= null){
            return received.getTicket();
        }else {
            throw new TicketException(received.getMessage());
        }
    }

    @Override
    public Ticket closeTicket(int id) throws TicketException {
        MQMessage msg = new MQMessage();
        msg.setMethod(Constants.CLOSE);
        msg.setMessage(String.valueOf(id));
        MQMessage received = qs.sendMessage(msg);
        if(received.getTicket()!= null){
            return received.getTicket();
        }else {
            throw new TicketException(received.getMessage());
        }
    }

    @Override
    public void triggerShutdown() {

    }
}
