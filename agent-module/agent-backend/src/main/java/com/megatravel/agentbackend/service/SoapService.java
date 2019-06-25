package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.model.Reservation;

public interface SoapService {

    Accommodation sendOneAccommodation(Accommodation accommodation);
    Reservation sendReservation(Reservation reservation);
}
