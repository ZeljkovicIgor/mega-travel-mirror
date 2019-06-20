package com.megatravel.agentbackend.controller;

import com.megatravel.agentbackend.client.MegaTravelClient;
import com.megatravel.agentbackend.model.*;
import com.megatravel.agentbackend.service.*;
import com.megatravel.agentbackend.ws.AccommodationSoap;
import com.megatravel.agentbackend.ws.GetOneAccommodationRequest;
import com.megatravel.agentbackend.ws.GetOneAccommodationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;


@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	UserService userService;
	@Autowired
	MegaTravelClient client;
	@Autowired
	AccTypeService accTypeService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	AddServiceService addServiceService;
	@Autowired
	ReservationService reservationService;

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
	public ResponseEntity<List<AccommodationSoap>> getAll() {

		return new ResponseEntity<List<AccommodationSoap>>(client.getAccommodation(3L).getAccommodation(),HttpStatus.OK);
	}
	@GetMapping(value="/one")
	public String getOne() {


		return "one";
	}

	@GetMapping(value="/addTestData")
	public String add() {

		User agent = new User();
		agent.setUserPassword("password");
		agent.setUserBusinessName("Apartmani pera");
		agent.setUserEmail("agent@a.com");
		agent.setUserUsername("agent");
		userService.addOne(agent);


		User user = new User();
		user.setUserPassword("password");
		user.setUserEmail("user@a.com");
		user.setUserUsername("user");
		userService.addOne(user);

		AccType accType = new AccType();
		accType.setAccTypeName("Tip 1");
		accTypeService.addOne(accType);

		AccType accType2 = new AccType();
		accType2.setAccTypeName("Tip 2");
		accTypeService.addOne(accType2);

		Category category = new Category();
		category.setCategoryName("Kategorija 1");
		categoryService.addOne(category);

		Category category2 = new Category();
		category2.setCategoryName("Kategorija 2");
		categoryService.addOne(category2);

		AddService addService = new AddService();
		addService.setServiceName("WiFi");
		addServiceService.addOne(addService);

		AddService addService2 = new AddService();
		addService2.setServiceName("Bazen");
		addServiceService.addOne(addService2);

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
