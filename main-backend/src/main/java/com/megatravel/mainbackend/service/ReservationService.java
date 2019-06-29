package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.dto.ReservationDto;
import com.megatravel.mainbackend.model.AccPrice;
import com.megatravel.mainbackend.model.AccUnavailable;
import com.megatravel.mainbackend.model.Accommodation;
import com.megatravel.mainbackend.model.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationService {
	
	List<Reservation> findAll();
	Reservation save(Reservation reservation);
	Reservation findOne(Long id);
	void delete(Long id);
	Reservation update(Long id, Reservation reservation);
	List<ReservationDto> convertToDtoList(List<Reservation> reservations);
	
	List<Reservation> findByUserId(Long id);
	ReservationDto convertToDto(Reservation r);
	long betweenDates(Date firstDate, Date secondDate);
	boolean checkReservation(List<AccPrice> accPrice,Date startDate, Date endDate);
	boolean checkUnavailable(List<AccUnavailable> allUnavailable,Date startDate, Date endDate);
	float getAccPrice(List<AccPrice> accPrice,Date startDate, Date endDate) ;
	List<Reservation> getAgentReservations(Long id);
	void deleteByAccommodation(Accommodation accommodation);

}
