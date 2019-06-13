package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.mainbackend.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	public ReservationRepository reservationRepository;
	
	@Override
	public List<Reservation> findAll() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

	@Override
	public Reservation save(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationRepository.save(reservation);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		reservationRepository.deleteById(id);
	}

	@Override
	public Reservation update(Long id, Reservation reservation) {
		// TODO Auto-generated method stub
		if(!reservationRepository.findById(id).isPresent()) {
			return null;
		}
		reservation.setRId(id);
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation findOne(Long id) {
		// TODO Auto-generated method stub
		return reservationRepository.getOne(id);
	}
	
	
}
