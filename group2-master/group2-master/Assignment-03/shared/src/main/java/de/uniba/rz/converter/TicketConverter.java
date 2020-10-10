package de.uniba.rz.converter;

import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.Type;
import de.uniba.rz.io.rpc.*;

public class TicketConverter {

    private TicketConverter(){}

    public static Ticket toTicket(TicketTransferObject ticketProto) {
        return new Ticket(ticketProto.getId(), ticketProto.getReporter(), ticketProto.getTopic(), ticketProto.getDescription(),
                Type.valueOf(ticketProto.getType().getValueDescriptor().getName()
                ), Priority.valueOf(ticketProto.getPriority().name()),
                Status.valueOf(ticketProto.getStatus().name()));
    }

    public static TicketTransferObject toTicketTransferObject(Ticket ticket) {
        return TicketTransferObject.newBuilder()
                .setId(ticket.getId())
                .setReporter(ticket.getReporter())
                .setTopic(ticket.getTopic())
                .setDescription(ticket.getDescription())
                .setType(de.uniba.rz.io.rpc.Type.valueOf(ticket.getType().name()))
                .setPriority(de.uniba.rz.io.rpc.Priority.valueOf(ticket.getPriority().name()))
                .setStatus(de.uniba.rz.io.rpc.Status.valueOf(ticket.getStatus().name()))
                .build();
    }

    public static TicketIDTransferObject toTicketIDTransferObject(int id){
        return TicketIDTransferObject.newBuilder().setId(id).build();
    }

    public static TicketNameTransferObject toTicketNameTransferObject(String name){
        return TicketNameTransferObject.newBuilder().setName(name).build();
    }

    public static TicketNameTypeTransferObject toTicketNameTypeTransferObject(String name, Type type){
        return TicketNameTypeTransferObject.newBuilder()
                .setName(name)
                .setType(de.uniba.rz.io.rpc.Type.valueOf(type.name()))
                .build();
    }

    public static int toTicketID(TicketIDTransferObject request) {
        return request.getId();
    }

    public static TicketIDStatusTransferObject toTicketIDStatusTransferObject(int id, Status status) {
        return TicketIDStatusTransferObject.newBuilder()
                .setId(id)
                .setStatus(de.uniba.rz.io.rpc.Status.valueOf(status.name()))
                .build();
    }
}
