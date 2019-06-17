package com.megatravel.mainbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.megatravel.mainbackend.model.Reservation;
import com.megatravel.mainbackend.service.ReservationService;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(value="/getReservations", method=RequestMethod.GET)
	public ResponseEntity<List<Reservation>> getReservations(){
		return new ResponseEntity<>(reservationService.findAll(),HttpStatus.OK);	
	}
	
	@RequestMapping(value="/addReservation",method=RequestMethod.POST)
	public ResponseEntity<?> addReservation(@RequestBody Reservation newReservation){
		Reservation reservation=reservationService.save(newReservation);
		if(reservation==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(reservation, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteReservation/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Reservation> deleteReservations(@PathVariable("id")  Long id){
		reservationService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
	}
	
	@RequestMapping(value="/updateReservation/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation updateReservation,@PathVariable("id")  Long id){
		//implementirati
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
