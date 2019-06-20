package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> getAll();
    Reservation getOneById(Long id);
    Reservation addOne(Reservation reservation);
    Reservation editOne(Reservation reservation);
    Reservation confirmReservation(long id);
    boolean deleteOne(Reservation reservation);
    boolean deleteById(Long id);
    //convertFromDto();
    //convertToDto();
}
