package com.megatravel.mainbackend;

import javax.annotation.PostConstruct;

import com.megatravel.mainbackend.model.*;
import com.megatravel.mainbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		a1.setAccAgent(user2);
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

		AddService addService = new AddService();
		addService.setServiceName("Parking");
		addServiceService.save(addService);
		addService = new AddService();
		addService.setServiceName("WiFi");
		AddService wifi = addServiceService.save(addService);
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
		AddService pets = addServiceService.save(addService);
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
		AccType apartman = accTypeService.save(accType);

		Accommodation acc = new Accommodation();
		acc.setAccName("Agentovi apartmani");
		acc.setAccAgent(agent);

		AccLocation accLocation = new AccLocation();
		accLocation.setCountry("Srbija");
		accLocation.setCity("Novi Sad");
		accLocation.setAddress("Bulevar oslobobodjenja");
		accLocationService.save(accLocation);

		acc.setAccLocation(accLocation);
		acc.setAccDescription("Opis agentovog smestaja");

		acc.setAccCategory(category);
		acc.setAccType(apartman);

		acc.setAccCancelPeriod(7);
		acc.setAccAvgRating(3);
		acc.setAccCapacity(3);
		acc.getAccServices().add(pets);
		acc.getAccServices().add(wifi);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date datum1 = null;
		Date datum2 = null;
		Date datum3 = null;
		Date datum4 = null;
		Date datum5=null;
		try {
			datum1 = dateFormat.parse("2019-07-25 00:00");
			datum2 = dateFormat.parse("2019-07-30 00:00");
			datum3 = dateFormat.parse("2019-08-25 00:00");
			datum4 = dateFormat.parse("2019-08-27 00:00");
			datum5 = dateFormat.parse("2019-06-25 00:00");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		AccPrice accPrice = new AccPrice();
		accPrice.setPriceStartDate(datum1);
		accPrice.setPriceEndDate(datum2);
		accPrice.setPriceValue(5000);

		AccPrice accPrice2 = new AccPrice();
		accPrice2.setPriceStartDate(datum3);
		accPrice2.setPriceEndDate(datum4);
		accPrice2.setPriceValue(10000);

		acc.getAccPricePlan().add(accPrice);
		acc.getAccPricePlan().add(accPrice2);

		AccUnavailable accUnavailable1 = new AccUnavailable();
		accUnavailable1.setUnavailableStart(datum1);
		accUnavailable1.setUnavailableEnd(datum2);
		acc.getAccUnavailable().add(accUnavailable1);


		accommodationService.save(acc);

		Accommodation acc2 = new Accommodation();
		acc2.setAccName("Agentovi apartmani");
		acc2.setAccAgent(agent);

		AccLocation accLocation2 = new AccLocation();
		accLocation2.setCountry("Srbija");
		accLocation2.setCity("Novi Sad");
		accLocation2.setAddress("Bulevar oslobobodjenja");
		accLocationService.save(accLocation2);

		acc2.setAccLocation(accLocation2);
		acc2.setAccDescription("Opis agentovog smestaja");

		acc2.setAccCategory(category);
		acc2.setAccType(apartman);

		acc2.setAccCancelPeriod(7);
		acc2.setAccAvgRating(3);
		acc2.setAccCapacity(3);
		acc2.getAccServices().add(pets);
		acc2.getAccServices().add(wifi);


		AccPrice accPrice3 = new AccPrice();
		accPrice3.setPriceStartDate(datum1);
		accPrice3.setPriceEndDate(datum2);
		accPrice3.setPriceValue(5000);

		AccPrice accPrice4 = new AccPrice();
		accPrice4.setPriceStartDate(datum3);
		accPrice4.setPriceEndDate(datum4);
		accPrice4.setPriceValue(10000);

		acc2.getAccPricePlan().add(accPrice3);
		acc2.getAccPricePlan().add(accPrice4);

		AccUnavailable accUnavailable2 = new AccUnavailable();
		accUnavailable2.setUnavailableStart(datum1);
		accUnavailable2.setUnavailableEnd(datum2);
		acc2.getAccUnavailable().add(accUnavailable2);

		accommodationService.save(acc2);


	}
	
	
}
