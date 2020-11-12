package de.uniba.rz.entities;

import java.io.Serializable;
import java.util.List;

public class MQMessage implements Serializable {
    private List<Ticket> responseTickets;
    private String method;
    private Ticket ticket;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<Ticket> getResponseTickets() {
        return responseTickets;
    }

    public void setResponseTickets(List<Ticket> tickets) {
        this.responseTickets = tickets;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
