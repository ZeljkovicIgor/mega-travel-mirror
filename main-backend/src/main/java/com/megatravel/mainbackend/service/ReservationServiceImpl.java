package com.megatravel.mainbackend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.megatravel.mainbackend.dto.ReservationDto;
import com.megatravel.mainbackend.model.Reservation;
import com.megatravel.mainbackend.model.User;

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

	@Override
	public List<ReservationDto> convertToDtoList(List<Reservation> reservations) {
		// TODO Auto-generated method stub
		List<ReservationDto> reservationDto = new ArrayList<>();
		for(Reservation r : reservations) {
			reservationDto.add(convertToDto(r));
		}
		return reservationDto;
	}

	private ReservationDto convertToDto(Reservation r) {
		// TODO Auto-generated method stub
		ReservationDto reservationDto=new ReservationDto();
		reservationDto.setrId(r.getRId());
		reservationDto.setrAccommodation(r.getRAccommodation());
		reservationDto.setrDate(r.getRDate());
		reservationDto.setrPrice(r.getRPrice());
		reservationDto.setrStartDate(r.getRStartDate());
		reservationDto.setrEndDate(r.getREndDate());
		reservationDto.setrPeople(r.getRPeople());
		reservationDto.setrEndUser(r.getREndUser());
		reservationDto.setRealized(r.isRealized());
		reservationDto.setCancelled(r.isCancelled());
		return reservationDto;
	}

	@Override
	public List<Reservation> findByUserId(Long id) {
		// TODO Auto-generated method stub
		List<Reservation> res = findAll();
		List<Reservation> retVal= new ArrayList<>();
		for(Reservation r : res) {
			if(r.getREndUser()!=null && r.getREndUser().getUserId()==id){
				retVal.add(r);
			}
		}
		return retVal;
	}
	
	
}
