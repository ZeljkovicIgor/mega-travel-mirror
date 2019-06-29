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
    //Accommodations
    public GetAllAccommodationResponse getAllAccommodations(User agent){
        GetAllAccommodationRequest request = new GetAllAccommodationRequest();
        request.setUserId(agent.getUserDbId());
        return (GetAllAccommodationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
    //Messages
    public GetMessageResponse getAllMessages(User agent){
        GetMessageRequest request = new GetMessageRequest();
        request.setAgentId(agent.getUserDbId());
        return (GetMessageResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
    public SendMessageResponse sendMessage(MessageSoap messageSoap){
        SendMessageRequest request = new SendMessageRequest();
        request.getMessage().add(messageSoap);
        return (SendMessageResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }


    //Reservations

    public CreateReservationResponse createReservation(ReservationSoap reservationSoap){
        CreateReservationRequest request = new CreateReservationRequest();
        request.getReservation().add(reservationSoap);
        return (CreateReservationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }


    public SendReservationResponse sendReservation(ReservationSoap reservationSoap){
        SendReservationRequest request = new SendReservationRequest();
        request.getReservation().add(reservationSoap);
        return (SendReservationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public ConfirmReservationResponse confirmReservation(ReservationSoap reservationSoap){
        ConfirmReservationRequest request = new ConfirmReservationRequest();
        request.getReservation().add(reservationSoap);
        return (ConfirmReservationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
    public GetAllReservationResponse getAllReservations(User agent){
        GetAllReservationRequest request = new GetAllReservationRequest();
        request.setUserId(agent.getUserDbId());
        return (GetAllReservationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
    //Accomodation type

    public GetAccTypeResponse getAllAccommodationTypes(User agent){
        GetAccTypeRequest request = new GetAccTypeRequest();
        request.setAgentId(agent.getUserDbId());
        return(GetAccTypeResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    //Accommodation category
    public GetCategoryResponse getAllCategories(User agent){
        GetCategoryRequest request = new GetCategoryRequest();
        request.setAgentId(agent.getUserDbId());
        return (GetCategoryResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
    //Reviews
    public GetAllReviewResponse getAllReviews(User agent){
        GetAllReviewRequest request = new GetAllReviewRequest();
        request.setUserId(agent.getUserDbId());
        return (GetAllReviewResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    //Adtional services

    public GetAddServicesResponse getAllAddServices(User agent){
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

    public GetAllAccommodationResponse getAccommodation(User agent){

        GetAllAccommodationRequest request = new GetAllAccommodationRequest();
        request.setUserId(agent.getUserDbId());
        GetAllAccommodationResponse response = (GetAllAccommodationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        System.out.println(response);
        return response;
    }
    public GetAllUserResponse getAllUsers(User agent){
        GetAllUserRequest request = new GetAllUserRequest();
        request.setUserId(agent.getUserDbId());
        GetAllUserResponse response = (GetAllUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        return response;
    }

}
