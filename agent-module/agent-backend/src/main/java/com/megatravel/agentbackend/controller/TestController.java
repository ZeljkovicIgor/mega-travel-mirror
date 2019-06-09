package com.megatravel.agentbackend.controller;

import com.megatravel.agentbackend.client.MegaTravelClient;
import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.model.User;
import com.megatravel.agentbackend.service.UserService;
import com.megatravel.agentbackend.ws.GetAllAccommodationResponse;
import com.megatravel.agentbackend.ws.GetOneAccommodationRequest;
import com.megatravel.agentbackend.ws.GetOneAccommodationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {

	@Autowired
	UserService userService;
	@Autowired
	MegaTravelClient client;

	@GetMapping(value="/test")
	public ResponseEntity<Accommodation> test() {

		GetOneAccommodationRequest request = new GetOneAccommodationRequest();
		request.setAccId(22);
		request.setUserId(11);
		System.out.println(request);
		GetOneAccommodationResponse response = client.getOneAccomodation(request);
		System.out.println(response.getAccommodation());
		Accommodation acc = new Accommodation();
		acc.setAccId(response.getAccommodation().getAccId());
		acc.setAccName(response.getAccommodation().getAccName());
		return new ResponseEntity<Accommodation>(acc, HttpStatus.OK);
	}
	@GetMapping(value="/all")
	public String getAll() {
		return "all";
	}
	@GetMapping(value="/one")
	public String getOne() {
		return "one";
	}
	@PostMapping(value="/add")
	public String add() {
		return "add";
	}
	@DeleteMapping(value="/delete")
	public String delete() {
		return "delete";
	}
	@PutMapping(value="/update")
	public String update() {
		return "update";
	}
}
