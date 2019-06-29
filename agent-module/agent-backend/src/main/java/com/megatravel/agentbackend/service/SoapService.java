package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.dto.ReservationDto;
import com.megatravel.agentbackend.model.*;
import com.megatravel.agentbackend.ws.AccTypeSoap;
import com.megatravel.agentbackend.ws.AddServiceSoap;
import com.megatravel.agentbackend.ws.CategorySoap;

import java.util.List;

public interface SoapService {

    boolean logInSync(String username, String password);
    List<User> getUsers(User agent);
    List<AccTypeSoap> getAccTypes(User agent);
    List<CategorySoap> getCategories(User agent);
    List<AddServiceSoap> getAddServices(User agent);
    List<Accommodation> getAllAccommodations(User agent);
    List<Reservation> getAllReservations(User agent);
    List<Message> getAllMessages(User agent);
    List<Review> getAllReviews(User agent);
    Accommodation createOneAccommodation(Accommodation accommodation);
    Reservation createReservation(Reservation reservation);
    boolean confirmReservation(Reservation reservation);
    Message sendMessage(Message message);
    boolean deleteAccommodation(Accommodation accommodation);
}
