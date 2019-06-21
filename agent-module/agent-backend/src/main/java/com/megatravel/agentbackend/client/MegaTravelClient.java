package com.megatravel.agentbackend.client;

import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.ws.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class MegaTravelClient extends WebServiceGatewaySupport {

    public AddOneAccommodationResponse addOneAccommodation(AccommodationSoap accommodationSoap){
        AddOneAccommodationRequest request = new AddOneAccommodationRequest();
        request.getAccommodation().add(accommodationSoap);
        return (AddOneAccommodationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
    public GetOneAccommodationResponse getOneAccomodation(GetOneAccommodationRequest request){
        return (GetOneAccommodationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public CheckAgentResponse getAgent(String username, String password){
        CheckAgentRequest agentRequest = new CheckAgentRequest();
        agentRequest.setUsername(username);
        agentRequest.setPassword(password);
        CheckAgentResponse response = (CheckAgentResponse) getWebServiceTemplate().marshalSendAndReceive(agentRequest);
        return response;
    }

    public GetAllAccommodationResponse getAccommodation(Long agentId){

        GetAllAccommodationRequest request = new GetAllAccommodationRequest();
        request.setUserId(agentId);
        GetAllAccommodationResponse response = new GetAllAccommodationResponse();
        response = (GetAllAccommodationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        System.out.println(response);
        return response;
    }

}
