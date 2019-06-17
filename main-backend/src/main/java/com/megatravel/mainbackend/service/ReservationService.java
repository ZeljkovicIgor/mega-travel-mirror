package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.dto.ReservationDto;
import com.megatravel.mainbackend.model.Reservation;

import java.util.List;

public interface ReservationService {
	
	List<Reservation> findAll();
	Reservation save(Reservation reservation);
	Reservation findOne(Long id);
	void delete(Long id);
	Reservation update(Long id, Reservation reservation);
	List<ReservationDto> convertToDtoList(List<Reservation> reservations);
	
	List<Reservation> findByUserId(Long id);
}
