package com.megatravel.mainbackend.endpoint;

import com.megatravel.mainbackend.model.*;
import com.megatravel.mainbackend.repository.AccommodationRepository;
import com.megatravel.mainbackend.service.*;

import com.megatravel.mainbackend.ws.messages.*;
import com.megatravel.mainbackend.ws.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Endpoint
public class AccommodationEndpoint {

    public static final String NAMESPACE_URI = "http://megatravel.com/booking/ws";

    @Autowired
    private AccommodationService accommodationService;
    @Autowired
    AddServiceService addServiceService;
    @Autowired
    AccTypeService accTypeService;
    @Autowired
    AccLocationService accLocationService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AccPriceService accPriceService;
    @Autowired
    UserService userService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    MessageService messageService;

    @Autowired
    AccommodationRepository accommodationRepository;

    public AccommodationEndpoint(){}



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAccommodationRequest")
    @ResponsePayload
    @Transactional
    public GetAllAccommodationResponse getAllAccommodationResponse(@RequestPayload GetAllAccommodationRequest request){
        User agent = userService.findOne(request.getUserId());
        GetAllAccommodationResponse response = new GetAllAccommodationResponse();

        if (agent == null || agent.getUserType() != UserType.AGENT)
            return response;


        /*
        for (Accommodation accommodation : accList) {
            List<AccPrice> pricePlan = accommodationService.getPricePlan(accommodation.getAccId());
            accommodationSoap.setAccId(accommodation.getAccId());
            accommodationSoap.setAccName(accommodation.getAccName());
            UserSoap agentSoap = new UserSoap();
            agentSoap.setUserId(accommodation.getAccAgent().getUserId());
            agentSoap.setUserBusinessId(accommodation.getAccAgent().getUserBusinessId());
            accommodationSoap.setAccAgent(agentSoap);
            CategorySoap categorySoap = new CategorySoap();
            categorySoap.setCategoryId(accommodation.getAccCategory().getCategoryId());
            categorySoap.setCategoryName(accommodation.getAccCategory().getCategoryName());
            accommodationSoap.setAccCategory(categorySoap);
            List<AccPriceSoap> accPriceSoapList = new ArrayList<>();
            List<AccPrice> accPriceList = accommodation.getAccPricePlan();
            for (AccPrice accPrice : accPriceList) {
                AccPriceSoap accPriceSoap = new AccPriceSoap();
                accPriceSoap.setPriceId(accPrice.getPriceId());
                accPriceSoap.setPriceEndDate(accPrice.getPriceEndDate());
                accPriceSoap.setPriceStartDate(accPrice.getPriceStartDate());
                accPriceSoap.setPriceValue(accPrice.getPriceValue());
                accPriceSoapList.add(accPriceSoap);
            }

            accommodationSoap.setAccPricePlan(accPriceSoapList);

            List<AddServiceSoap> addServiceSoapList = new ArrayList<>();
            List<AddService> addServiceList = accommodation.getAccServices();
            for (AddService addService : addServiceList) {
                AddServiceSoap addServiceSoap = new AddServiceSoap();
                addServiceSoap.setServiceId(addService.getServiceId());
                addServiceSoap.setServiceName(addService.getServiceName());
                addServiceSoapList.add(addServiceSoap);
            }

            //accommodationSoap.setAccServices(addServiceSoapList);

            //accommodationSoapList.add(accommodationSoap);
        }
        */
        List<Accommodation> accList = accommodationService.findByAgentId(agent.getUserId());
        response.getAccommodation().addAll(accList);
        System.out.println("getAllAccEndpoint");
        return response;


    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOneAccommodationRequest")
    @ResponsePayload
    public GetOneAccommodationResponse getOneAccommodationResponse(@RequestPayload GetOneAccommodationRequest request){
        System.out.println("Get one accomodation soap");
        //duplirane klase iz modela
        GetOneAccommodationResponse response = new GetOneAccommodationResponse();
        Accommodation acc = new Accommodation();
        AccommodationSoap accommodation = new AccommodationSoap();
        UserSoap user = new UserSoap();
        user.setUserId(request.getUserId());
        user.setUserFirstName("Pera");
        user.setUserLastName("Peric");
        user.setUserType(UserTypeSoap.AGENT);
        accommodation.setAccId(request.getAccId());
        accommodation.setAccName("SMESTAJ");
        accommodation.setAccDescription("Neki opis smestaja");
        accommodation.setAccAgent(user);

        //response.setAccommodation(accommodation);
        return response;
    }



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUserRequest")
    @ResponsePayload
    @Transactional
    public GetAllUserResponse getAllUsers(@RequestPayload GetAllUserRequest request){
        GetAllUserResponse response = new GetAllUserResponse();
        response.getUser().addAll(userService.getAllUsers());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllReservationRequest")
    @ResponsePayload
    @Transactional
    public GetAllReservationResponse getAllReservations(@RequestPayload GetAllReservationRequest request){
        GetAllReservationResponse response = new GetAllReservationResponse();
        response.getReservation().addAll(reservationService.getAgentReservations(request.getUserId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllReviewRequest")
    @ResponsePayload
    @Transactional
    public GetAllReviewResponse getAllReviews(@RequestPayload GetAllReviewRequest request){
        GetAllReviewResponse response = new GetAllReviewResponse();
        List<Review> reviews = reviewService.getAgentAccReviews(request.getUserId());
        response.getReview().addAll(reviews);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addOneAccommodationRequest")
    @ResponsePayload
    @Transactional
    public AddOneAccommodationResponse addOneAccommodationResponse(@RequestPayload AddOneAccommodationRequest request){
        System.out.println("Stigao request " + request.getAccommodation());
        List<Accommodation> accommodationList = request.getAccommodation();

        Accommodation accommodation = accommodationList.get(0);
        User agent = userService.findOne(accommodation.getAccAgent().getUserId());
        System.out.println("Stigao smestaj "+ accommodation.getAccName());
        System.out.println("Plan cena "+ accommodation.getAccPricePlan().get(0).getPriceStartDate());
        Accommodation saved = accommodationService.save(accommodation);
        AddOneAccommodationResponse response = new AddOneAccommodationResponse();
        response.setAccDBId(saved.getAccId());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "checkAgentRequest")
    @ResponsePayload
    @Transactional
    public CheckAgentResponse checkAgent(@RequestPayload CheckAgentRequest request){
        //izmeniti da agent salje email ili PIB
        String username = request.getUsername();
        String password = request.getPassword();
        System.out.println(username);
        System.out.println(password);
        User agent = userService.findByUsername(username);
        System.out.println(agent.getUserId());
        List<Accommodation> accList =  accommodationService.findByAgentId(agent.getUserId());
        System.out.println(accList);
        CheckAgentResponse response = new CheckAgentResponse();
        response.setAgent(agent);
        response.getAccommodation().addAll(accList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAddServicesRequest")
    @ResponsePayload
    @Transactional
    public GetAddServicesResponse getAddServices(@RequestPayload GetAddServicesRequest request){
        System.out.println("Stigao zahtev za dodatne usluge");
        GetAddServicesResponse response = new GetAddServicesResponse();

        User user = userService.findOne(request.getAgentId());
        if (user.getUserType() != UserType.AGENT){
            response.getAddServce().addAll(new ArrayList<>());
        }else{
            response.getAddServce().addAll(addServiceService.findAll());
        }

        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccTypeRequest")
    @ResponsePayload
    @Transactional
    public GetAccTypeResponse getAddTypes(@RequestPayload GetAccTypeRequest request){
        System.out.println("Stigao zahtev za tipove smestaja");
        GetAccTypeResponse response = new GetAccTypeResponse();

        User user = userService.findOne(request.getAgentId());
        if (user.getUserType() != UserType.AGENT){
            response.getAccType().addAll(new ArrayList<>());
        }else{
            response.getAccType().addAll(accTypeService.findAll());
        }

        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoryRequest")
    @ResponsePayload
    @Transactional
    public GetCategoryResponse getCategories(@RequestPayload GetCategoryRequest request){
        System.out.println("Stigao zahtev za kategorije");
        GetCategoryResponse response = new GetCategoryResponse();

        User user = userService.findOne(request.getAgentId());
        if (user.getUserType() != UserType.AGENT){
            response.getCategory().addAll(new ArrayList<>());
        }else{
            response.getCategory().addAll(categoryService.findAll());
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendReservationRequest")
    @ResponsePayload
    @Transactional
    public SendReservationResponse createReservation(@RequestPayload SendReservationRequest request){
        SendReservationResponse response = new SendReservationResponse();
        Reservation reservation = request.getReservation().get(0);
        Reservation retRes = reservationService.createReservation(reservation);
        if (retRes != null){
            response.setReservationId(retRes.getRId());
            response.setReservationPrice(retRes.getRPrice());
        }else{
            response.setReservationId(0);
        }


        /*
        Accommodation acc = accommodationService.findOne(reservation.getRAccommodation().getAccId());
        List<AccPrice> accPrice = acc.getAccPricePlan();
        List<AccUnavailable> allUnavailable = acc.getAccUnavailable();

        //provera rezervacije

        if(reservationService.checkReservation(accPrice,reservation.getRStartDate(),reservation.getREndDate())
                && !reservationService.checkUnavailable(allUnavailable,reservation.getRStartDate(),reservation.getREndDate())) {
            reservation.setRDate(new Date());
            reservation.setCancelled(false);
            reservation.setREndUser(acc.getAccAgent());
            reservationService.save(reservation);
        }

        response.setReservationId(reservation.getRId());
        */
        return response;


    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "confirmReservationRequest")
    @ResponsePayload
    @Transactional
    public ConfirmReservationResponse confirmReservation(@RequestPayload ConfirmReservationRequest request){
        ConfirmReservationResponse response = new ConfirmReservationResponse();

        System.out.println("Stigao za potvrdu " + request.getReservation().get(0).getRId());
        Reservation reservation = request.getReservation().get(0);
        Reservation res = reservationService.findOne(reservation.getRId());

        if (res == null){
            response.setStatus(false);
        }else{
            res.setRealized(true);
            reservationService.save(res);
            response.setStatus(true);
        }
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteAccommodationsRequest")
    @ResponsePayload
    @Transactional
    public DeleteAccommodationsResponse deleteAccomodation(@RequestPayload DeleteAccommodationsRequest request){
        System.out.println("Stigao za brisanje " + request.getAccommodation().get(0).getAccId());
        DeleteAccommodationsResponse response = new DeleteAccommodationsResponse();
        Accommodation accommodation = accommodationService.findOne(request.getAccommodation().get(0).getAccId());
        //reviewService.deleteByAccommodation(accommodation);
        //reservationService.deleteByAccommodation(accommodation);
        accommodationService.delete(accommodation);
        response.setStatus(true);
        return  response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMessageRequest")
    @ResponsePayload
    @Transactional
    public GetMessageResponse getMessages(@RequestPayload GetMessageRequest request){
        GetMessageResponse response = new GetMessageResponse();
        List<Message> agentSender = messageService.findBySender_id(request.getAgentId());
        List<Message> agentReciever = messageService.findByReciever_id(request.getAgentId());
        response.getMessage().addAll(agentSender);
        response.getMessage().addAll(agentReciever);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendMessageRequest")
    @ResponsePayload
    @Transactional
    public SendMessageResponse sendMessage(@RequestPayload SendMessageRequest request){
        SendMessageResponse response = new SendMessageResponse();
        Message message = request.getMessage().get(0);
        messageService.save(message);
        response.setSent(true);
        return response;
    }

}
