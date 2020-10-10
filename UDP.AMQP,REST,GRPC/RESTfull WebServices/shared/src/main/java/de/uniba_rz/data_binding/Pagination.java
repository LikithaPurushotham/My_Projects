package de.uniba_rz.data_binding;

import java.net.URI;
import java.util.logging.Logger;

import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"page", "noOfPages", "first", "previous", "next", "last"})
public class Pagination {
	 private static final Logger logger = Logger.getLogger("Pagination");

	    private int page;
	    private int noOfPages;

	    private URI first;
	    private URI previous;
	    private URI next;
	    private URI last;
	    
	
	    public Pagination() {

	    }

	    public Pagination(final URI path, final int currentPage, final int pageLimit, final int collectionSize) {
	        logger.info("in pagination path: "+ path + "current Page: " + currentPage + "Page Limit: " + pageLimit + "Size: " + collectionSize);
	        this.page = currentPage;
	        this.noOfPages = (int) Math.ceil((double) collectionSize / (double) pageLimit);

	        this.first = UriBuilder.fromUri(path).queryParam("page", 1).queryParam("pageLimit", pageLimit).build();
	        this.last = UriBuilder.fromUri(path).queryParam("page", this.noOfPages).queryParam("pageLimit", pageLimit).build();
	        this.previous = UriBuilder.fromUri(path).queryParam("page", Math.max((this.page - 1), 1)).queryParam("pageLimit", pageLimit).build();
	        this.next = UriBuilder.fromUri(path).queryParam("page", Math.min((this.page + 1), this.noOfPages)).queryParam("pageLimit", pageLimit).build();
	    }

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public int getNoOfPages() {
			return noOfPages;
		}

		public void setNoOfPages(int noOfPages) {
			this.noOfPages = noOfPages;
		}

		public URI getFirst() {
			return first;
		}

		public void setFirst(URI first) {
			this.first = first;
		}

		public URI getPrevious() {
			return previous;
		}

		public void setPrevious(URI previous) {
			this.previous = previous;
		}

		public URI getNext() {
			return next;
		}

		public void setNext(URI next) {
			this.next = next;
		}

		public URI getLast() {
			return last;
		}

		public void setLast(URI last) {
			this.last = last;
		}

		public static Logger getLogger() {
			return logger;
		}

}
