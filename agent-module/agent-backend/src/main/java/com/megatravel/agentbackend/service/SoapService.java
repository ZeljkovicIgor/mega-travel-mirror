package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.model.Reservation;
import com.megatravel.agentbackend.model.User;

public interface SoapService {

    void logInSync(User agent);
    Accommodation sendOneAccommodation(Accommodation accommodation);
    Reservation sendReservation(Reservation reservation);
}
