package com.megatravel.agentbackend.client;

import com.megatravel.agentbackend.ws.GetAllAccommodationRequest;
import com.megatravel.agentbackend.ws.GetAllAccommodationResponse;
import com.megatravel.agentbackend.ws.GetOneAccommodationRequest;
import com.megatravel.agentbackend.ws.GetOneAccommodationResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class MegaTravelClient extends WebServiceGatewaySupport {

    public GetOneAccommodationResponse getOneAccomodation(GetOneAccommodationRequest request){
        return (GetOneAccommodationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
