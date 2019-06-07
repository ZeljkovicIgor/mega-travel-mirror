package com.megatravel.mainbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.service.ReservationService;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
}
