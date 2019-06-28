package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.*;
import com.megatravel.agentbackend.ws.AccTypeSoap;
import com.megatravel.agentbackend.ws.AddServiceSoap;
import com.megatravel.agentbackend.ws.CategorySoap;

import java.util.List;

public interface SoapService {

    void logInSync(String username, String password);
    List<User> getUsers(User agent);
    List<AccTypeSoap> getAccTypes(User agent);
    List<CategorySoap> getCategories(User agent);
    List<AddServiceSoap> getAddServices(User agent);
    Accommodation sendOneAccommodation(Accommodation accommodation);
    Reservation sendReservation(Reservation reservation);
}
