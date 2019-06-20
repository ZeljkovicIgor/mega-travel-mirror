package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.Reservation;
import com.megatravel.agentbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getOneById(Long id) {
        return reservationRepository.getOne(id);
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
        Reservation res = reservationRepository.getOne(id);
        if (res != null){
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
}
