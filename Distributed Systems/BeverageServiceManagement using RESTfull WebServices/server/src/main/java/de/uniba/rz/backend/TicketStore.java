package de.uniba.rz.backend;


import java.util.List;
import de.uniba_rz.data_binding.TicketBinding;

public interface TicketStore {

	static boolean storeNewTicket(TicketBinding ticket) {return false;}
    
    static TicketBinding updateTicketStatus(int ticketId, TicketBinding updatedStatus) throws UnknownTicketException, IllegalStateException {return null;}

    static List<TicketBinding> getAllTickets() {return null;};

}
