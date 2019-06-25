package com.megatravel.agentbackend.client;

import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.model.Reservation;
import com.megatravel.agentbackend.model.User;
import com.megatravel.agentbackend.ws.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;

public class MegaTravelClient extends WebServiceGatewaySupport {
    //Accommodations
    public AddOneAccommodationResponse addOneAccommodation(AccommodationSoap accommodationSoap){
        AddOneAccommodationRequest request = new AddOneAccommodationRequest();
        request.getAccommodation().add(accommodationSoap);
        return (AddOneAccommodationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
    public GetOneAccommodationResponse getOneAccomodation(GetOneAccommodationRequest request){
        return (GetOneAccommodationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
    public DeleteAccommodationsResponse deleteAccommodations(List<AccommodationSoap> accommodationSoapList){
        //Salje listu smestaja za brisanje, u vecini slucajeva ce to biti lista sa jednim elementom jer se radi sinhronizacija
        //posle svakog brisanja.
        DeleteAccommodationsRequest request = new DeleteAccommodationsRequest();
        request.getAccommodation().addAll(accommodationSoapList);
        return (DeleteAccommodationsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
    public EditOneAccommodationResponse editOneAccommodation(AccommodationSoap accommodationSoap){
        EditOneAccommodationRequest request = new EditOneAccommodationRequest();
        request.getAccommodation().add(accommodationSoap);
        return (EditOneAccommodationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
    //Messages
    GetMessageResponse getAllMessages(UserSoap agent){
        GetMessageRequest request = new GetMessageRequest();
        request.setAgentId(agent.getUserId());
        return (GetMessageResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
    SendMessageResponse sendMessage(MessageSoap messageSoap){
        SendMessageRequest request = new SendMessageRequest();
        request.setMessage(messageSoap);
        return (SendMessageResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }


    //Reservations

    public CreateReservationResponse createReservation(ReservationSoap reservationSoap){
        CreateReservationRequest request = new CreateReservationRequest();
        request.setReservation(reservationSoap);
        return (CreateReservationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public ConfirmReservationResponse confirmReservation(ReservationSoap reservationSoap){
        ConfirmReservationRequest request = new ConfirmReservationRequest();
        request.setReservation(reservationSoap);
        return (ConfirmReservationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    //Accomodation type

    GetAccTypeResponse getAllAccommodationTypes(User agent){
        GetAccTypeRequest request = new GetAccTypeRequest();
        request.setAgentId(agent.getUserDbId());
        return(GetAccTypeResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    //Accommodation category
    GetCategoryResponse getAllCategories(User agent){
        GetCategoryRequest request = new GetCategoryRequest();
        request.setAgentId(agent.getUserDbId());
        return (GetCategoryResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    //Adtional services

    GetAddServicesResponse getAllAddServices(User agent){
        GetAddServicesRequest request = new GetAddServicesRequest();
        request.setAgentId(agent.getUserDbId());
        return  (GetAddServicesResponse) getWebServiceTemplate().marshalSendAndReceive(request);
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
