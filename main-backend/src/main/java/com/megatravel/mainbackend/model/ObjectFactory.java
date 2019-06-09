
package com.megatravel.mainbackend.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.megatravel.mainbackend.model package. 
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

    private final static QName _Reservation_QNAME = new QName("http://megatravel.com/booking", "reservation");
    private final static QName _Accommodation_QNAME = new QName("http://megatravel.com/booking", "accommodation");
    private final static QName _User_QNAME = new QName("http://megatravel.com/booking", "user");
    private final static QName _Message_QNAME = new QName("http://megatravel.com/booking", "message");
    private final static QName _Category_QNAME = new QName("http://megatravel.com/booking", "category");
    private final static QName _AccType_QNAME = new QName("http://megatravel.com/booking", "acc_type");
    private final static QName _AddService_QNAME = new QName("http://megatravel.com/booking", "add_service");
    private final static QName _Review_QNAME = new QName("http://megatravel.com/booking", "review");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.megatravel.mainbackend.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddService }
     * 
     */
    public AddService createAddService() {
        return new AddService();
    }

    /**
     * Create an instance of {@link AccType }
     * 
     */
    public AccType createAccType() {
        return new AccType();
    }

    /**
     * Create an instance of {@link Review }
     * 
     */
    public Review createReview() {
        return new Review();
    }

    /**
     * Create an instance of {@link Accommodation }
     * 
     */
    public Accommodation createAccommodation() {
        return new Accommodation();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link AccUnavailable }
     * 
     */
    public AccUnavailable createAccUnavailable() {
        return new AccUnavailable();
    }

    /**
     * Create an instance of {@link AccPrice }
     * 
     */
    public AccPrice createAccPrice() {
        return new AccPrice();
    }

    /**
     * Create an instance of {@link AccLocation }
     * 
     */
    public AccLocation createAccLocation() {
        return new AccLocation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking", name = "reservation")
    public JAXBElement<Reservation> createReservation(Reservation value) {
        return new JAXBElement<Reservation>(_Reservation_QNAME, Reservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Accommodation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking", name = "accommodation")
    public JAXBElement<Accommodation> createAccommodation(Accommodation value) {
        return new JAXBElement<Accommodation>(_Accommodation_QNAME, Accommodation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking", name = "user")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Message }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking", name = "message")
    public JAXBElement<Message> createMessage(Message value) {
        return new JAXBElement<Message>(_Message_QNAME, Message.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Category }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking", name = "category")
    public JAXBElement<Category> createCategory(Category value) {
        return new JAXBElement<Category>(_Category_QNAME, Category.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking", name = "acc_type")
    public JAXBElement<AccType> createAccType(AccType value) {
        return new JAXBElement<AccType>(_AccType_QNAME, AccType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking", name = "add_service")
    public JAXBElement<AddService> createAddService(AddService value) {
        return new JAXBElement<AddService>(_AddService_QNAME, AddService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Review }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking", name = "review")
    public JAXBElement<Review> createReview(Review value) {
        return new JAXBElement<Review>(_Review_QNAME, Review.class, null, value);
    }

}
