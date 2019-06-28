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
    AccommodationRepository accommodationRepository;

    public AccommodationEndpoint(){}



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAccommodationRequest")
    @ResponsePayload
    @Transactional
    public GetAllAccommodationResponse getAllAccommodationResponse(@RequestPayload GetAllAccommodationRequest request){
        GetAllAccommodationResponse response = new GetAllAccommodationResponse();
        List<Accommodation> accList = accommodationService.findByAgentId(request.getUserId());
        List<AccommodationSoap> accommodationSoaps = new ArrayList<>();
        AccommodationSoap accommodationSoap1 = new AccommodationSoap();
        AccommodationSoap accommodationSoap2 = new AccommodationSoap();
        AccommodationSoap accommodationSoap3 = new AccommodationSoap();
        accommodationSoap1.setAccId(1l);
        accommodationSoap2.setAccId(2l);
        accommodationSoap3.setAccId(3l);
        accommodationSoap1.setAccName("Smestaj 1");
        accommodationSoap2.setAccName("Smestaj 2");
        accommodationSoap3.setAccName("Smestaj 3");
        accommodationSoaps.add(accommodationSoap1);
        accommodationSoaps.add(accommodationSoap2);
        accommodationSoaps.add(accommodationSoap3);
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
        response.setAccommodation(accommodationSoaps);

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

        response.setAccommodation(accommodation);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addOneAccommodationRequest")
    @ResponsePayload
    public AddOneAccommodationResponse addOneAccommodationResponse(@RequestPayload AddOneAccommodationRequest request){
        System.out.println("Stigao request " + request.getAccommodation());
        List<Accommodation> accommodationList = request.getAccommodation();
        Accommodation accommodation = accommodationList.get(0);
        System.out.println("Stigao smestaj "+ accommodation.getAccName());
        System.out.println("Plan cena "+ accommodation.getAccPricePlan().get(0).getPriceStartDate());
        Accommodation saved = accommodationService.save(accommodation);
        AddOneAccommodationResponse response = new AddOneAccommodationResponse();
        response.setAccDBId(saved.getAccId());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "checkAgentRequest")
    @ResponsePayload
    public CheckAgentResponse checkAgent(@RequestPayload CheckAgentRequest request){
        //izmeniti da agent salje email ili PIB
        String username = request.getUsername();
        String password = request.getPassword();
        System.out.println(username);
        System.out.println(password);
        User agent = userService.findByUsername(username);
        System.out.println(agent);
        CheckAgentResponse response = new CheckAgentResponse();
        response.setAgent(agent);
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


}
