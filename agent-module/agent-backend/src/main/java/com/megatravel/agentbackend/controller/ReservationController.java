package com.megatravel.agentbackend.controller;

import com.megatravel.agentbackend.dto.ReservationDto;
import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.model.Reservation;
import com.megatravel.agentbackend.model.User;
import com.megatravel.agentbackend.service.AccommodationService;
import com.megatravel.agentbackend.service.ReservationService;
import com.megatravel.agentbackend.service.UserService;
import org.joda.time.Days;
import org.joda.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    AccommodationService accommodationService;
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations(){

        return new ResponseEntity<>(reservationService.getAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody ReservationDto reservationDto, HttpServletRequest request){
        User agent = (User) request.getSession().getAttribute("agent");
        if (agent == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        System.out.println(reservationDto.getrAccommodationId());


        Reservation reservation = reservationService.createReservation(reservationDto , agent);


        if (reservation != null){
            return new ResponseEntity<>(reservation,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "/confirm/{id}")
    public ResponseEntity<Reservation> confirmReservation(@PathVariable(value = "id") long id, HttpServletRequest request){
        User agent = (User) request.getSession().getAttribute("agent");
        if (agent == null )
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        Reservation res = reservationService.confirmReservation(id);
        if (res != null){
            return new ResponseEntity<>(res, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
