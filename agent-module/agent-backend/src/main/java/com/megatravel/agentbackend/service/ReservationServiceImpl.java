package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.dto.ReservationDto;
import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.model.Reservation;
import com.megatravel.agentbackend.model.User;
import com.megatravel.agentbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    AccommodationService accommodationService;
    @Autowired
    UserService userService;
    @Autowired
    SoapService soapService;

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getOneById(Long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public Reservation getOneByDbId(Long id) {
        return reservationRepository.findByRDbId(id);
    }

    @Override
    public Reservation addOne(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation editOne(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation confirmReservation(long id) {
        Reservation res = getOneById(id);
        if(soapService.confirmReservation(res)){
            res.setRealized(true);
            return reservationRepository.save(res);
        }
            return null;
    }

    @Override
    public boolean deleteOne(Reservation reservation) {
        reservationRepository.delete(reservation);
        return (reservationRepository.existsById(reservation.getRId())?true:false);
    }

    @Override
    public boolean deleteById(Long id) {
        reservationRepository.deleteById(id);
        return (reservationRepository.existsById(id)?true:false);
    }

    @Override
    public void deleteAll() {
        reservationRepository.deleteAll();
    }

    @Override
    public Reservation createReservation(ReservationDto reservationDto, User agent) {
        System.out.println(reservationDto.getrAccommodationId());
        Accommodation acc = accommodationService.getOneById(reservationDto.getrAccommodationId());
        User a = userService.getOneByUsername(agent.getUserUsername());
        System.out.println(acc.getAccName());
        Reservation reservation = new Reservation();
        reservation.setRPeople(reservationDto.getrPeople());
        reservation.setRDate(reservationDto.getrDate());
        reservation.setREndDate(reservationDto.getrEndDate());
        reservation.setRStartDate(reservationDto.getrStartDate());
        reservation.setREndUser(acc.getAccAgent());
        reservation.setRAccommodation(acc);
        System.out.println(reservation.getRAccommodation().getAccName());
        System.out.println(reservation.getRAccommodation().getAccAgent().getUserUsername());


        reservation = soapService.createReservation(reservation);
        if (reservation == null)
            return null;
        else
            reservationRepository.save(reservation);
            return reservation;
    }

    @Override
    public void deleteByAccommodation(Accommodation accommodation) {
        reservationRepository.deleteAllByRAccommodation(accommodation);
    }

    @Override
    public List<Reservation> findByAccommodation(Accommodation accommodation) {
        return reservationRepository.findAllByRAccommodation(accommodation);
    }
}
