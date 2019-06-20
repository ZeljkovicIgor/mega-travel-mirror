package com.megatravel.agentbackend.controller;

import com.megatravel.agentbackend.dto.ReservationDto;
import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.model.Reservation;
import com.megatravel.agentbackend.service.AccommodationService;
import com.megatravel.agentbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    AccommodationService accommodationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations(){

        return new ResponseEntity<>(reservationService.getAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody ReservationDto reservationDto){
        Accommodation acc = accommodationService.getOneById(reservationDto.getrAccommodationId());
        Reservation reservation = new Reservation();
        reservation.setRAccommodation(acc);
        reservation.setCancelled(false);
        reservation.setRealized(false);
        reservation.setRDate(reservationDto.getrDate());
        reservation.setRStartDate(reservationDto.getrStartDate());
        reservation.setREndDate(reservationDto.getrEndDate());
        reservation.setRPeople(reservationDto.getrPeople());
        reservation.setRPrice(reservationDto.getrPrice());
        //uzeti prijavljenog agenta
        reservation.setREndUser(acc.getAccAgent());
        Reservation saved = reservationService.addOne(reservation);
        if (saved != null){
            return new ResponseEntity<>(saved,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PutMapping(value = "/confirm/{id}")
    public ResponseEntity<Reservation> confirmReservation(@PathVariable(value = "id") long id){
        Reservation res = reservationService.confirmReservation(id);
        if (res != null){
            return new ResponseEntity<>(res, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
