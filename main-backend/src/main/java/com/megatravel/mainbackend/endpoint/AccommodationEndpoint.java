package com.megatravel.mainbackend.endpoint;

import com.megatravel.mainbackend.model.Accommodation;
import com.megatravel.mainbackend.model.User;
import com.megatravel.mainbackend.service.AccommodationService;

import com.megatravel.mainbackend.service.UserService;
import com.megatravel.mainbackend.ws.messages.*;
import com.megatravel.mainbackend.ws.model.AccommodationSoap;
import com.megatravel.mainbackend.ws.model.UserSoap;
import com.megatravel.mainbackend.ws.model.UserTypeSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class AccommodationEndpoint {

    public static final String NAMESPACE_URI = "http://megatravel.com/booking/ws";
    private AccommodationService accommodationService;
    @Autowired
    private UserService userService;
    public AccommodationEndpoint(){}

    //Intellij preporucuje constructor DI
    @Autowired
    public AccommodationEndpoint(AccommodationService accommodationService, UserService userService){
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
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "checkAgentRequest")
    @ResponsePayload
    public CheckAgentResponse checkAgent(@RequestPayload CheckAgentRequest request){
        //izmeniti da agent salje email ili PIB
        String username = request.getUsername();
        String password = request.getPassword();
        System.out.println("username");
        System.out.println("password");
        User agent = userService.findByEmail(username + "@agent.com");

        System.out.println(agent);
        CheckAgentResponse response = new CheckAgentResponse();
        response.setAgent(agent);
        return response;
    }


}
