package com.megatravel.mainbackend;

import javax.annotation.PostConstruct;

import com.megatravel.mainbackend.model.*;
import com.megatravel.mainbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

@Component
public class TestData {

	@Autowired
	private UserService userService;
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
	private ReviewService reviewService;
	
	@PostConstruct
	private void init(){
		
		User user1=new User();
		user1.setUserType(UserType.ADMIN);
		user1.setUserFirstName("Ivana");
		user1.setUserLastName("Antic");
		user1.setUserPassword("sifra");
		user1.setUserEmail("a@a.com");
		user1.setActivated(true);
		
		User user2=new User();
		user2.setUserType(UserType.AGENT);
		user2.setUserFirstName("Petae");
		user2.setUserLastName("Petrovic");
		user2.setUserPassword("sifra2");
		user2.setUserEmail("p@p.com");
		user2.setActivated(true);
		
		User user3=new User();
		user3.setUserType(UserType.ENDUSER);
		user3.setUserFirstName("Petae");
		user3.setUserLastName("Petrovic");
		user3.setUserPassword("sifra2");
		user3.setUserEmail("p@p.com");
		user3.setActivated(true);
		userService.save(user1);
		userService.save(user2);
		userService.save(user3);
		Accommodation a1= new Accommodation();
		a1.setAccName("sMESTAJ 1");
		accommodationService.save(a1);
		
		Review r = new Review();
		r.setReviewComment("neki komentar");
		r.setReviewEndUser(user3);
		r.setCommentApproved(false);
		r.setReviewAccommodation(a1);
		//r.setReviewAccommodation(accommodationService.findOne(one));
		Review r2 = new Review();
		r2.setReviewComment("neki kom");
		r2.setReviewEndUser(user3);
		r2.setCommentApproved(false);
		r2.setReviewAccommodation(a1);
		reviewService.save(r);
		reviewService.save(r2);

		//Test data Gema


		User agent = new User();
		agent.setUserType(UserType.AGENT);
		agent.setUserFirstName("Mika");
		agent.setUserLastName("Mikic");
		agent.setUserUsername("agent");
		agent.setUserPassword("password");
		agent.setUserBusinessId("12345");
		agent.setUserBusinessName("Apartmani MIKA");
		agent.setUserAddress("Cirpanova 6");
		agent.setUserEmail("agent@agent.com");
		agent.setActivated(true);
		userService.save(agent);

		AddService addService1 = new AddService();
		AddService addService2 = new AddService();
		AddService addService3 = new AddService();
		AddService addService4 = new AddService();
		AddService addService5 = new AddService();
		AddService addService6 = new AddService();
		AddService addService7 = new AddService();
		AddService addService8 = new AddService();
		AddService addService9 = new AddService();

		AddService addService = new AddService();
		addService.setServiceName("Parking");
		addServiceService.save(addService);
		addService = new AddService();
		addService.setServiceName("WiFi");
		addServiceService.save(addService);
		addService = new AddService();
		addService.setServiceName("Dorucak");
		addServiceService.save(addService);
		addService = new AddService();
		addService.setServiceName("Polupansion");
		addServiceService.save(addService);
		addService = new AddService();
		addService.setServiceName("Pansion");
		addServiceService.save(addService);
		addService = new AddService();
		addService.setServiceName("All inclusive");
		addServiceService.save(addService);
		addService = new AddService();
		addService.setServiceName("Pet frendly");
		addServiceService.save(addService);
		addService = new AddService();
		addService.setServiceName("TV");
		addServiceService.save(addService);
		addService = new AddService();
		addService.setServiceName("Kuhinja");
		addServiceService.save(addService);
		addService = new AddService();
		addService.setServiceName("Privatno kupatilo");
		addServiceService.save(addService);


		Category category = new Category();
		Category category1 = new Category();
		Category category2 = new Category();
		Category category3 = new Category();
		Category category4 = new Category();
		Category category5 = new Category();

		category.setCategoryName("0"); //ovo znaci da je nekategorisan
		category1.setCategoryName("1"); //predstavlja broj zvezdica
		category2.setCategoryName("2");
		category3.setCategoryName("3");
		category4.setCategoryName("4");
		category5.setCategoryName("5");

		categoryService.save(category);
		categoryService.save(category1);
		categoryService.save(category2);
		categoryService.save(category3);
		categoryService.save(category4);
		categoryService.save(category5);

		AccType accType = new AccType();
		accType.setAccTypeName("Hotel");
		accTypeService.save(accType);
		accType = new AccType();
		accType.setAccTypeName("Bed & Breakfast");
		accTypeService.save(accType);
		accType = new AccType();
		accType.setAccTypeName("Apartman");
		accTypeService.save(accType);


	}
	
	
}
