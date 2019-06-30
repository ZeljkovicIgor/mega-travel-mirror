package com.megatravel.mainbackend.service;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.megatravel.mainbackend.dto.ReservationDto;
import com.megatravel.mainbackend.model.AccPrice;
import com.megatravel.mainbackend.model.AccUnavailable;
import com.megatravel.mainbackend.model.Accommodation;
import com.megatravel.mainbackend.model.Reservation;
import com.megatravel.mainbackend.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.mainbackend.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	public ReservationRepository reservationRepository;
	@Autowired
	AccommodationService accommodationService;

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
		return reservationRepository.findById(id).get();
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
	@Override
	public ReservationDto convertToDto(Reservation r) {
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
	public List<Reservation> getAgentReservations(Long id) {
		List<Reservation> retList = new ArrayList<>();
		List<Accommodation> accommodationList = accommodationService.findByAgentId(id);
		for (Accommodation accommodation : accommodationList) {
			retList.addAll(reservationRepository.findAllByRAccommodation(accommodation));
		}
		return retList;
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
	
	@Override
	public long betweenDates(Date firstDate, Date secondDate)
	{
	    return ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
	}

	@Override
	public boolean checkReservation(List<AccPrice> accPrice,Date startDate, Date endDate) {

		for(AccPrice a: accPrice) {
			if(!startDate.before(a.getPriceStartDate()) && endDate.after(a.getPriceEndDate())) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean checkUnavailable(List<AccUnavailable> allUnavailable,Date startDate, Date endDate) {
		for(AccUnavailable a: allUnavailable) {
			if(!startDate.before(a.getUnavailableStart()) && !endDate.after(a.getUnavailableEnd())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public float getAccPrice(List<AccPrice> accPrice, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		for(AccPrice a: accPrice) {
			if(startDate.after(a.getPriceStartDate()) && endDate.before(a.getPriceEndDate())) {
				return a.getPriceValue();
			}
		}
		return 0;
	}

	@Override
	public void deleteByAccommodation(Accommodation accommodation) {
		reservationRepository.deleteAllByRAccommodation(accommodation);
	}

	@Override
	public Reservation createReservation(Reservation reservation) {
		Accommodation accommodation = accommodationService.findOne(reservation.getRAccommodation().getAccId());
		List<Reservation> reservationList = reservationRepository.findAllByRAccommodation(accommodation);
		List<AccUnavailable> unavList = accommodation.getAccUnavailable();
		List<AccPrice> priceList = accommodation.getAccPricePlan();
		//rezervacija veca od kapaciteta
		if (reservation.getRPeople() > accommodation.getAccCapacity() || reservation.getRStartDate().before(new Date()) || reservation.getRPeople() < 1 ){
			return null;
		}
		boolean resOkFlag =  true;
		boolean unavOkFlag = true;
		float terminPrice = 0;
		float reservationPrice = 0;
		long days = ChronoUnit.DAYS.between(reservation.getRStartDate().toInstant(), reservation.getREndDate().toInstant());

		for (Reservation res : reservationList) {
			if((reservation.getRStartDate().before(res.getRStartDate()) && reservation.getREndDate().before(res.getREndDate())
			) || (reservation.getRStartDate().after(res.getREndDate()) && reservation.getREndDate().after(res.getREndDate()))){
				continue;
			}else{
				resOkFlag = false;
			}
		}

		for (AccUnavailable accUnav : unavList) {
			if((reservation.getRStartDate().before(accUnav.getUnavailableStart()) && reservation.getREndDate().before(accUnav.getUnavailableEnd())
			) || (reservation.getRStartDate().after(accUnav.getUnavailableEnd()) && reservation.getREndDate().after(accUnav.getUnavailableEnd()))){
				continue;
			}else{
				resOkFlag = false;
			}
		}
		//ako je sve ok proveri cenu
		if(resOkFlag && unavOkFlag){

			for (AccPrice accPrice : priceList) {
				if(reservation.getRStartDate().after(accPrice.getPriceStartDate()) && reservation.getREndDate().before(accPrice.getPriceEndDate()))
					terminPrice = accPrice.getPriceValue();
			}
		}
		//rezervacija van termina
		if (terminPrice == 0){
			return null;
		}
		reservationPrice = reservation.getRPeople() * terminPrice * days;
		reservation.setRPrice(reservationPrice);
		reservation.setRealized(false);
		reservation.setCancelled(false);
		save(reservation);
		return reservation;

	}

	@Override
	public List<Reservation> findByAccommodation(Accommodation accommodation) {
		return reservationRepository.findAllByRAccommodation(accommodation);
	}
}
