
package de.uniba.rz.search;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.uniba.rz.search package. 
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

    private final static QName _TypeNotAvailableException_QNAME = new QName("http://search.rz.uniba.de/", "TypeNotAvailableException");
    private final static QName _ClientMessage_QNAME = new QName("http://search.rz.uniba.de/", "clientMessage");
    private final static QName _ClientMessageResponse_QNAME = new QName("http://search.rz.uniba.de/", "clientMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.uniba.rz.search
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TypeNotAvailableException }
     * 
     */
    public TypeNotAvailableException createTypeNotAvailableException() {
        return new TypeNotAvailableException();
    }

    /**
     * Create an instance of {@link ClientMessage }
     * 
     */
    public ClientMessage createClientMessage() {
        return new ClientMessage();
    }

    /**
     * Create an instance of {@link ClientMessageResponse }
     * 
     */
    public ClientMessageResponse createClientMessageResponse() {
        return new ClientMessageResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link TypeNotAvailableException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TypeNotAvailableException }{@code >}
     */
    @XmlElementDecl(namespace = "http://search.rz.uniba.de/", name = "TypeNotAvailableException")
    public JAXBElement<TypeNotAvailableException> createTypeNotAvailableException(TypeNotAvailableException value) {
        return new JAXBElement<TypeNotAvailableException>(_TypeNotAvailableException_QNAME, TypeNotAvailableException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientMessage }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientMessage }{@code >}
     */
    @XmlElementDecl(namespace = "http://search.rz.uniba.de/", name = "clientMessage")
    public JAXBElement<ClientMessage> createClientMessage(ClientMessage value) {
        return new JAXBElement<ClientMessage>(_ClientMessage_QNAME, ClientMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientMessageResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientMessageResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://search.rz.uniba.de/", name = "clientMessageResponse")
    public JAXBElement<ClientMessageResponse> createClientMessageResponse(ClientMessageResponse value) {
        return new JAXBElement<ClientMessageResponse>(_ClientMessageResponse_QNAME, ClientMessageResponse.class, null, value);
    }

}
