package com.megatravel.mainbackend.endpoint;

import com.megatravel.mainbackend.service.AccommodationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccommodationEndpoint {
/*
    public static final String NAMESPACE_URI = "http://megatravel.com/booking/ws";
    private AccommodationService accommodationService;

    public AccommodationEndpoint(){}

    //Intellij preporucuje constructor DI
    @Autowired
    public AccommodationEndpoint(AccommodationService accommodationService){
        this.accommodationService = accommodationService;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAccommodationRequest")
    @ResponsePayload
    public GetAllAccommodationResponse getAllAccommodationResponse(@RequestPayload GetAllAccommodationRequest request){
        GetAllAccommodationResponse response = new GetAllAccommodationResponse();
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
        com.megatravel.mainbackend.ws.Accommodation accommodation = new com.megatravel.mainbackend.ws.Accommodation();
        com.megatravel.mainbackend.ws.User user = new User();
        user.setUserId(request.getUserId());
        user.setUserFirstName("Pera");
        user.setUserLastName("Peric");
        user.setUserType(UserType.AGENT);
        accommodation.setAccId(request.getAccId());
        accommodation.setAccName("SMESTAJ");
        accommodation.setAccDescription("Neki opis smestaja");
        accommodation.setAccAgent(user);

        response.setAccommodation(accommodation);
        return response;
    }

 */
}
