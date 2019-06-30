package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.dto.ReservationDto;
import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.model.Reservation;
import com.megatravel.agentbackend.model.User;

import java.util.List;

public interface ReservationService {

    List<Reservation> getAll();
    Reservation getOneById(Long id);
    Reservation getOneByDbId(Long id);
    Reservation addOne(Reservation reservation);
    Reservation editOne(Reservation reservation);
    Reservation confirmReservation(long id);
    boolean deleteOne(Reservation reservation);
    boolean deleteById(Long id);
    void deleteAll();
    void deleteByAccommodation(Accommodation accommodation);
    Reservation createReservation(ReservationDto reservationDto, User agent);
    //convertFromDto();
    //convertToDto();
}
