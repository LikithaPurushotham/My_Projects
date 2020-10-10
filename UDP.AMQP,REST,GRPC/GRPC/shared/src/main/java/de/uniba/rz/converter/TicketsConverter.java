package de.uniba.rz.converter;

import de.uniba.rz.entities.Ticket;
import de.uniba.rz.io.rpc.TicketsTransferObject;
import de.uniba.rz.io.rpc.TicketTransferObject;

import java.util.ArrayList;
import java.util.List;

public class TicketsConverter {

    private TicketsConverter(){}

    public static List<Ticket> toTickets(TicketsTransferObject ticketsProto){
        List<Ticket> tickets = new ArrayList<Ticket>();
        ticketsProto.getTicketsList().forEach((TicketTransferObject ticket) -> {
            tickets.add(TicketConverter.toTicket(ticket));
        });
        return tickets;
    }

    public static TicketsTransferObject toTicketsTransferObject(List<Ticket> tickets){
        TicketsTransferObject ticketsProto = null;
        List <TicketTransferObject> ticketTransferObjectList = new ArrayList<>();
        tickets.forEach((Ticket ticket)->{
            ticketTransferObjectList.add(TicketConverter.toTicketTransferObject(ticket));
        });
        ticketsProto = TicketsTransferObject.newBuilder().addAllTickets(ticketTransferObjectList).build();
        return ticketsProto;
    }
}
