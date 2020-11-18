
package de.uniba.rz.backend;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.uniba.rz.backend package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SearchMessage_QNAME = new QName("http://backend.rz.uniba.de/", "searchMessage");
    private final static QName _SearchMessageResponse_QNAME = new QName("http://backend.rz.uniba.de/", "searchMessageResponse");
    private final static QName _SendMessage_QNAME = new QName("http://backend.rz.uniba.de/", "sendMessage");
    private final static QName _SendMessageResponse_QNAME = new QName("http://backend.rz.uniba.de/", "sendMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.uniba.rz.backend
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchMessage }
     * 
     */
    public SearchMessage createSearchMessage() {
        return new SearchMessage();
    }

    /**
     * Create an instance of {@link SearchMessageResponse }
     * 
     */
    public SearchMessageResponse createSearchMessageResponse() {
        return new SearchMessageResponse();
    }

    /**
     * Create an instance of {@link SendMessage }
     * 
     */
    public SendMessage createSendMessage() {
        return new SendMessage();
    }

    /**
     * Create an instance of {@link SendMessageResponse }
     * 
     */
    public SendMessageResponse createSendMessageResponse() {
        return new SendMessageResponse();
    }

    /**
     * Create an instance of {@link TicketSearch }
     * 
     */
    public TicketSearch createTicketSearch() {
        return new TicketSearch();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchMessage }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchMessage }{@code >}
     */
    @XmlElementDecl(namespace = "http://backend.rz.uniba.de/", name = "searchMessage")
    public JAXBElement<SearchMessage> createSearchMessage(SearchMessage value) {
        return new JAXBElement<SearchMessage>(_SearchMessage_QNAME, SearchMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchMessageResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchMessageResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://backend.rz.uniba.de/", name = "searchMessageResponse")
    public JAXBElement<SearchMessageResponse> createSearchMessageResponse(SearchMessageResponse value) {
        return new JAXBElement<SearchMessageResponse>(_SearchMessageResponse_QNAME, SearchMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessage }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendMessage }{@code >}
     */
    @XmlElementDecl(namespace = "http://backend.rz.uniba.de/", name = "sendMessage")
    public JAXBElement<SendMessage> createSendMessage(SendMessage value) {
        return new JAXBElement<SendMessage>(_SendMessage_QNAME, SendMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessageResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendMessageResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://backend.rz.uniba.de/", name = "sendMessageResponse")
    public JAXBElement<SendMessageResponse> createSendMessageResponse(SendMessageResponse value) {
        return new JAXBElement<SendMessageResponse>(_SendMessageResponse_QNAME, SendMessageResponse.class, null, value);
    }

}
