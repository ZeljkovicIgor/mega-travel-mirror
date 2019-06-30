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
	@Autowired
	ReservationService reservationService;
	@Autowired
	MessageService messageService;

	
	@PostConstruct
	private void init(){
		
		User user1=new User();
		user1.setUserType(UserType.ADMIN);
		user1.setUserFirstName("Ivana");
		user1.setUserLastName("Antic");
		user1.setUserPassword("sifra");
		user1.setUserEmail("a@a.com");
		user1.setActivated(true);
		

		User user3=new User();
		user3.setUserType(UserType.ENDUSER);
		user3.setUserFirstName("Petar");
		user3.setUserLastName("Petrovic");
		user3.setUserUsername("pera");
		user3.setUserPassword("sifra2");
		user3.setUserEmail("pera@p.com");
		user3.setActivated(true);
		userService.save(user1);
		userService.save(user3);



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

		acc.setAccLocation(accLocation);
		acc.setAccDescription("Opis agentovog smestaja");

		acc.setAccCategory(category);
		acc.setAccType(apartman);

		acc.setAccCancelPeriod(7);
		acc.setAccAvgRating(3);
		acc.setAccCapacity(5);
		acc.getAccServices().add(pets);
		acc.getAccServices().add(wifi);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date od1 = null;
		Date do1 = null;
		Date od2 = null;
		Date do2 = null;
		Date od3 = null;
		Date do3 = null;
		Date unav1 = null;
		Date unav2 = null;
		Date unav3 = null;
		Date unav4 = null;
		Date accDate = null;
		Date accDate2 = null;
		Date rDate = null;
		Date rStart = null;
		Date rEnd = null;


		try {
			od1 = dateFormat.parse("2019-06-1");
			do1 = dateFormat.parse("2019-06-30 ");
			od2 = dateFormat.parse("2019-07-1");
			do2 = dateFormat.parse("2019-07-31");
			od3 = dateFormat.parse("2019-08-1");
			do3 = dateFormat.parse("2019-08-31");
			unav1 = dateFormat.parse("2019-07-5");
			unav2 = dateFormat.parse("2019-07-10");
			rDate = dateFormat.parse("2019-06-20");
			rStart = dateFormat.parse("2019-07-1");
			rEnd = dateFormat.parse("2019-07-5");

			unav3 = dateFormat.parse("2019-08-10");
			unav4 = dateFormat.parse("2019-08-20");
			accDate = dateFormat.parse("2019-06-15");
			accDate2 = dateFormat.parse("2019-06-25");

		} catch (ParseException e) {

			e.printStackTrace();
		}
		acc.setAccDate(accDate);
		AccPrice accPrice = new AccPrice();
		accPrice.setPriceStartDate(od1);
		accPrice.setPriceEndDate(do1);
		accPrice.setPriceValue(5000);

		AccPrice accPrice2 = new AccPrice();
		accPrice2.setPriceStartDate(od2);
		accPrice2.setPriceEndDate(do2);
		accPrice2.setPriceValue(10000);

		acc.getAccPricePlan().add(accPrice);
		acc.getAccPricePlan().add(accPrice2);

		AccUnavailable accUnavailable1 = new AccUnavailable();
		accUnavailable1.setUnavailableStart(unav1);
		accUnavailable1.setUnavailableEnd(unav2);
		acc.getAccUnavailable().add(accUnavailable1);


		accommodationService.save(acc);

		Accommodation acc2 = new Accommodation();
		acc2.setAccName("Agentovi apartmani 2");
		acc2.setAccAgent(agent);
		acc2.setAccDate(accDate2);
		AccLocation accLocation2 = new AccLocation();
		accLocation2.setCountry("Srbija");
		accLocation2.setCity("Novi Sad");
		accLocation2.setAddress("Bulevar oslobobodjenja");

		acc2.setAccLocation(accLocation2);
		acc2.setAccDescription("Opis agentovog smestaja 2");

		acc2.setAccCategory(category);
		acc2.setAccType(apartman);

		acc2.setAccCancelPeriod(7);
		acc2.setAccAvgRating(3);
		acc2.setAccCapacity(3);
		acc2.getAccServices().add(pets);
		acc2.getAccServices().add(wifi);


		AccPrice accPrice3 = new AccPrice();
		accPrice3.setPriceStartDate(od3);
		accPrice3.setPriceEndDate(do3);
		accPrice3.setPriceValue(3000);



		acc2.getAccPricePlan().add(accPrice3);

		AccUnavailable accUnavailable2 = new AccUnavailable();
		accUnavailable2.setUnavailableStart(unav3);
		accUnavailable2.setUnavailableEnd(unav4);
		acc2.getAccUnavailable().add(accUnavailable2);

		accommodationService.save(acc2);

		Reservation reservation = new Reservation();
		reservation.setRDate(rDate);
		reservation.setREndUser(user3);
		reservation.setRStartDate(rStart);
		reservation.setREndDate(rEnd);
		reservation.setRAccommodation(acc);
		reservation.setRPeople(2);
		reservationService.save(reservation);

		Message  message = new Message();
		message.setMessageDate(new Date());
		message.setMessageReciever(agent);
		message.setMessageSender(user3);
		message.setMessageReservation(reservation);
		message.setStatus(MessageStatus.SENT);
		message.setMessageContent("Poruka za agenta");
		messageService.save(message);

		Review review = new Review();
		review.setAccDate(new Date());
		review.setReviewAccommodation(acc);
		review.setReviewEndUser(user3);
		review.setReviewComment("Komentar usera");
		review.setReviewGrade(4);
		reviewService.save(review);
	}
	
	
}
