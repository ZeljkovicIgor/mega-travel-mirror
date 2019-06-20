package com.megatravel.mainbackend.controller;

import com.megatravel.mainbackend.model.*;
import com.megatravel.mainbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value= "/accommodation")
public class AccommodationController {

	@Autowired
	private AccommodationService accommodationService;
	@Autowired
	AddServiceService addServiceService;
	@Autowired
	AccTypeService accTypeService;
	@Autowired
	AccLocationService accLocationService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	AccPriceService accPriceService;
	@Autowired
	UserService userService;

	@GetMapping(value = "/test1")
	private ResponseEntity<Accommodation> test(){

		User agent = new User();
		agent.setUserUsername("agent");
		agent.setUserPassword("password");
		agent.setUserType(UserType.AGENT);
		agent.setUserEmail("agent@agent.com");
		agent.setActivated(true);
		agent.setUserBusinessId("12345");
		User saved = userService.save(agent);

		AddService addService = new AddService();
		addService.setServiceName("WIFI");
		addService = addServiceService.save(addService);

		AccPrice accPrice = new AccPrice();
		Date startDate = new Date();
		accPrice.setPriceStartDate(startDate);
		accPrice.setPriceEndDate(startDate);
		accPrice.setPriceValue(5000);
		//accPrice = accPriceService.save(accPrice);

		AccPrice accPrice2 = new AccPrice();
		accPrice2.setPriceStartDate(startDate);
		accPrice2.setPriceEndDate(startDate);
		accPrice2.setPriceValue(10000);
		accPrice2 = accPriceService.save(accPrice2);

		AccType accType = new AccType();
		accType.setAccTypeName("Hotel");
		accType = accTypeService.save(accType);
		System.out.println("ID tipa " + accType.getAccTypeId());

		AccLocation accLocation = new AccLocation();
		accLocation.setAddress("Neka adresa 1");
		accLocation.setCity("Novi Sad");
		accLocation.setCountry("Srbija");
		accLocation = accLocationService.save(accLocation);
		System.out.println("ID Lokacije " + accLocation.getLocId());
		Category category = new Category();
		category.setCategoryName("Neka kategorija");
		category = categoryService.save(category);
		System.out.println("ID kategorije " + category.getCategoryId());
		Accommodation acc1= new Accommodation();
		acc1.setAccAgent(userService.findOne(saved.getUserId()));
		acc1.setAccName("Smestaj 1");
		acc1.setAccDescription("Neki opis 1");
		acc1.setAccCategory(category);
		acc1.setAccLocation(accLocation);

		List<AccPrice> prices1 = new ArrayList<>();
		prices1.add(accPrice);
		acc1.setAccPricePlan(prices1);

		List<AccUnavailable>  accUnavailable = new ArrayList<>();
		acc1.setAccUnavailable(accUnavailable);



		Accommodation acc2= new Accommodation();
		acc2.setAccAgent(userService.findOne(saved.getUserId()));
		acc2.setAccName("Smestaj 2");
		acc2.setAccDescription("Neki opis 2");

		List<AccPrice> prices2 = new ArrayList<>();
		prices2.add(accPrice2);
		acc2.setAccPricePlan(prices2);

		acc2.setAccPricePlan(prices2);
		accommodationService.save(acc2);
		return new ResponseEntity<Accommodation>(accommodationService.save(acc1), HttpStatus.OK);
	}

	@GetMapping(value = "/test2")
	public ResponseEntity<List<Accommodation>> test2(){

		List<Accommodation> accommodationList = accommodationService.findAll();
		return new ResponseEntity<List<Accommodation>>(accommodationService.findAll(), HttpStatus.OK);
	}
}
