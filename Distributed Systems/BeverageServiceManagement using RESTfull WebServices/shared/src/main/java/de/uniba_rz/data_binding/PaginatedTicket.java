package de.uniba_rz.data_binding;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;
import java.util.List;

@XmlRootElement
@XmlType(propOrder = {"pagination", "tickets", "href"})
public class PaginatedTicket {
	
	private Pagination pagination;
    private List<TicketBinding> tickets;

    private URI href;

    public PaginatedTicket() {

    }

	public PaginatedTicket(Pagination pagination, List<TicketBinding> tickets, URI href) {
		super();
		this.pagination = pagination;
		this.tickets = tickets;
		this.href = href;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public List<TicketBinding> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketBinding> ticket) {
		this.tickets = ticket;
	}

	public URI getHref() {
		return href;
	}

	public void setHref(URI href) {
		this.href = href;
	}

}
