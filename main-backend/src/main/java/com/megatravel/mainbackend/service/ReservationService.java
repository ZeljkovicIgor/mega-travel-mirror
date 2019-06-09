package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.Reservation;

import java.util.List;

public interface ReservationService {
	
	List<Reservation> findAll();
	Reservation save(Reservation reservation);
	void delete(Long id);
}
