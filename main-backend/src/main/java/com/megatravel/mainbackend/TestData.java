package com.megatravel.mainbackend;

import javax.annotation.PostConstruct;

import com.megatravel.mainbackend.model.*;
import com.megatravel.mainbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	}
	
	
}
