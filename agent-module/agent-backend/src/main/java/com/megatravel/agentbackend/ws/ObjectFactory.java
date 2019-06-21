
package com.megatravel.agentbackend.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.megatravel.agentbackend.ws package. 
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

    private final static QName _AccommodationSoap_QNAME = new QName("http://megatravel.com/booking/ws", "accommodationSoap");
    private final static QName _ReviewSoap_QNAME = new QName("http://megatravel.com/booking/ws", "reviewSoap");
    private final static QName _ReservationSoap_QNAME = new QName("http://megatravel.com/booking/ws", "reservationSoap");
    private final static QName _UserSoap_QNAME = new QName("http://megatravel.com/booking/ws", "userSoap");
    private final static QName _AddServiceSoap_QNAME = new QName("http://megatravel.com/booking/ws", "add_serviceSoap");
    private final static QName _CategorySoap_QNAME = new QName("http://megatravel.com/booking/ws", "categorySoap");
    private final static QName _AccTypeSoap_QNAME = new QName("http://megatravel.com/booking/ws", "acc_typeSoap");
    private final static QName _MessageSoap_QNAME = new QName("http://megatravel.com/booking/ws", "messageSoap");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.megatravel.agentbackend.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMessageRequest }
     * 
     */
    public GetMessageRequest createGetMessageRequest() {
        return new GetMessageRequest();
    }

    /**
     * Create an instance of {@link GetCategoryResponse }
     * 
     */
    public GetCategoryResponse createGetCategoryResponse() {
        return new GetCategoryResponse();
    }

    /**
     * Create an instance of {@link AddServiceSoap }
     * 
     */
    public AddServiceSoap createAddServiceSoap() {
        return new AddServiceSoap();
    }

    /**
     * Create an instance of {@link MessageSoap }
     * 
     */
    public MessageSoap createMessageSoap() {
        return new MessageSoap();
    }

    /**
     * Create an instance of {@link GetAllAccommodationResponse }
     * 
     */
    public GetAllAccommodationResponse createGetAllAccommodationResponse() {
        return new GetAllAccommodationResponse();
    }

    /**
     * Create an instance of {@link AccommodationSoap }
     * 
     */
    public AccommodationSoap createAccommodationSoap() {
        return new AccommodationSoap();
    }

    /**
     * Create an instance of {@link DeleteAccommodationsRequest }
     * 
     */
    public DeleteAccommodationsRequest createDeleteAccommodationsRequest() {
        return new DeleteAccommodationsRequest();
    }

    /**
     * Create an instance of {@link EditOneAccommodationRequest }
     * 
     */
    public EditOneAccommodationRequest createEditOneAccommodationRequest() {
        return new EditOneAccommodationRequest();
    }

    /**
     * Create an instance of {@link GetAccTypeResponse }
     * 
     */
    public GetAccTypeResponse createGetAccTypeResponse() {
        return new GetAccTypeResponse();
    }

    /**
     * Create an instance of {@link AccTypeSoap }
     * 
     */
    public AccTypeSoap createAccTypeSoap() {
        return new AccTypeSoap();
    }

    /**
     * Create an instance of {@link CategorySoap }
     * 
     */
    public CategorySoap createCategorySoap() {
        return new CategorySoap();
    }

    /**
     * Create an instance of {@link AddAccommodationsResponse }
     * 
     */
    public AddAccommodationsResponse createAddAccommodationsResponse() {
        return new AddAccommodationsResponse();
    }

    /**
     * Create an instance of {@link GetMessageResponse }
     * 
     */
    public GetMessageResponse createGetMessageResponse() {
        return new GetMessageResponse();
    }

    /**
     * Create an instance of {@link ConfirmReservationRequest }
     * 
     */
    public ConfirmReservationRequest createConfirmReservationRequest() {
        return new ConfirmReservationRequest();
    }

    /**
     * Create an instance of {@link ReservationSoap }
     * 
     */
    public ReservationSoap createReservationSoap() {
        return new ReservationSoap();
    }

    /**
     * Create an instance of {@link AddAccommodationsRequest }
     * 
     */
    public AddAccommodationsRequest createAddAccommodationsRequest() {
        return new AddAccommodationsRequest();
    }

    /**
     * Create an instance of {@link GetAllAccommodationRequest }
     * 
     */
    public GetAllAccommodationRequest createGetAllAccommodationRequest() {
        return new GetAllAccommodationRequest();
    }

    /**
     * Create an instance of {@link GetAddServicesRequest }
     * 
     */
    public GetAddServicesRequest createGetAddServicesRequest() {
        return new GetAddServicesRequest();
    }

    /**
     * Create an instance of {@link CheckAgentResponse }
     * 
     */
    public CheckAgentResponse createCheckAgentResponse() {
        return new CheckAgentResponse();
    }

    /**
     * Create an instance of {@link UserSoap }
     * 
     */
    public UserSoap createUserSoap() {
        return new UserSoap();
    }

    /**
     * Create an instance of {@link AddOneAccommodationRequest }
     * 
     */
    public AddOneAccommodationRequest createAddOneAccommodationRequest() {
        return new AddOneAccommodationRequest();
    }

    /**
     * Create an instance of {@link DeleteAccommodationsResponse }
     * 
     */
    public DeleteAccommodationsResponse createDeleteAccommodationsResponse() {
        return new DeleteAccommodationsResponse();
    }

    /**
     * Create an instance of {@link GetAccTypeRequest }
     * 
     */
    public GetAccTypeRequest createGetAccTypeRequest() {
        return new GetAccTypeRequest();
    }

        /**
     * Create an instance of {@link CreateReservationResponse }
     *
     */
    public CreateReservationResponse createCreateReservationResponse() {
        return new CreateReservationResponse();
    }

    /**
     * Create an instance of {@link EditOneAccommodationResponse }
     * 
     */
    public EditOneAccommodationResponse createEditOneAccommodationResponse() {
        return new EditOneAccommodationResponse();
    }

    /**
     * Create an instance of {@link SendMessageRequest }
     * 
     */
    public SendMessageRequest createSendMessageRequest() {
        return new SendMessageRequest();
    }

    /**
     * Create an instance of {@link GetOneAccommodationRequest }
     * 
     */
    public GetOneAccommodationRequest createGetOneAccommodationRequest() {
        return new GetOneAccommodationRequest();
    }

    /**
     * Create an instance of {@link CheckAgentRequest }
     * 
     */
    public CheckAgentRequest createCheckAgentRequest() {
        return new CheckAgentRequest();
    }

    /**
     * Create an instance of {@link GetOneAccommodationResponse }
     * 
     */
    public GetOneAccommodationResponse createGetOneAccommodationResponse() {
        return new GetOneAccommodationResponse();
    }

    /**
     * Create an instance of {@link ConfirmReservationResponse }
     * 
     */
    public ConfirmReservationResponse createConfirmReservationResponse() {
        return new ConfirmReservationResponse();
    }

    /**
     * Create an instance of {@link ReviewSoap }
     * 
     */
    public ReviewSoap createReviewSoap() {
        return new ReviewSoap();
    }

    /**
     * Create an instance of {@link GetAddServicesResponse }
     * 
     */
    public GetAddServicesResponse createGetAddServicesResponse() {
        return new GetAddServicesResponse();
    }

    /**
     * Create an instance of {@link AddOneAccommodationResponse }
     * 
     */
    public AddOneAccommodationResponse createAddOneAccommodationResponse() {
        return new AddOneAccommodationResponse();
    }

    /**
     * Create an instance of {@link GetCategoryRequest }
     * 
     */
    public GetCategoryRequest createGetCategoryRequest() {
        return new GetCategoryRequest();
    }

    /**
     * Create an instance of {@link SendMessageResponse }
     * 
     */
    public SendMessageResponse createSendMessageResponse() {
        return new SendMessageResponse();
    }

    /**
     * Create an instance of {@link AccPriceSoap }
     * 
     */
    public AccPriceSoap createAccPriceSoap() {
        return new AccPriceSoap();
    }

    /**
     * Create an instance of {@link AccLocationSoap }
     * 
     */
    public AccLocationSoap createAccLocationSoap() {
        return new AccLocationSoap();
    }

    /**
     * Create an instance of {@link AccUnavailableSoap }
     * 
     */
    public AccUnavailableSoap createAccUnavailableSoap() {
        return new AccUnavailableSoap();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccommodationSoap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking/ws", name = "accommodationSoap")
    public JAXBElement<AccommodationSoap> createAccommodationSoap(AccommodationSoap value) {
        return new JAXBElement<AccommodationSoap>(_AccommodationSoap_QNAME, AccommodationSoap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReviewSoap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking/ws", name = "reviewSoap")
    public JAXBElement<ReviewSoap> createReviewSoap(ReviewSoap value) {
        return new JAXBElement<ReviewSoap>(_ReviewSoap_QNAME, ReviewSoap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservationSoap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking/ws", name = "reservationSoap")
    public JAXBElement<ReservationSoap> createReservationSoap(ReservationSoap value) {
        return new JAXBElement<ReservationSoap>(_ReservationSoap_QNAME, ReservationSoap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserSoap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking/ws", name = "userSoap")
    public JAXBElement<UserSoap> createUserSoap(UserSoap value) {
        return new JAXBElement<UserSoap>(_UserSoap_QNAME, UserSoap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddServiceSoap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking/ws", name = "add_serviceSoap")
    public JAXBElement<AddServiceSoap> createAddServiceSoap(AddServiceSoap value) {
        return new JAXBElement<AddServiceSoap>(_AddServiceSoap_QNAME, AddServiceSoap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategorySoap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking/ws", name = "categorySoap")
    public JAXBElement<CategorySoap> createCategorySoap(CategorySoap value) {
        return new JAXBElement<CategorySoap>(_CategorySoap_QNAME, CategorySoap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccTypeSoap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking/ws", name = "acc_typeSoap")
    public JAXBElement<AccTypeSoap> createAccTypeSoap(AccTypeSoap value) {
        return new JAXBElement<AccTypeSoap>(_AccTypeSoap_QNAME, AccTypeSoap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageSoap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://megatravel.com/booking/ws", name = "messageSoap")
    public JAXBElement<MessageSoap> createMessageSoap(MessageSoap value) {
        return new JAXBElement<MessageSoap>(_MessageSoap_QNAME, MessageSoap.class, null, value);
    }

}
