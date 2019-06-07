package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.Reservation;

public interface ReservationService {
	
	List<Reservation> findAll();
	Reservation save(Reservation reservation);
	void delete(Long id);
}
