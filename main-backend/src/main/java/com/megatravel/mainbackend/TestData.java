package com.megatravel.mainbackend;

import javax.annotation.PostConstruct;

import com.megatravel.mainbackend.model.Accommodation;
import com.megatravel.mainbackend.model.User;
import com.megatravel.mainbackend.model.UserType;
import com.megatravel.mainbackend.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.megatravel.mainbackend.service.UserService;

@Component
public class TestData {

	@Autowired
	private UserService userService;
	@Autowired
	private AccommodationService accommodationService;
	@PostConstruct
	private void init(){
		
		User user1=new User();
		user1.setUserType(UserType.ENDUSER);
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
		
		userService.save(user1);
		userService.save(user2);

		User agent = new User();
		agent.setUserUsername("agent");
		agent.setUserPassword("password");
		agent.setUserType(UserType.AGENT);
		agent.setUserEmail("agent@agent.com");
		agent.setActivated(true);
		agent.setUserBusinessId("12345");
		User saved = userService.save(agent);
		Accommodation acc1= new Accommodation();
		acc1.setAccAgent(userService.findOne(saved.getUserId()));
		acc1.setAccName("Smestaj 1");
		acc1.setAccDescription("Neki opis 1");
		Accommodation acc2= new Accommodation();
		acc2.setAccAgent(userService.findOne(saved.getUserId()));
		acc2.setAccName("Smestaj 2");
		acc2.setAccDescription("Neki opis 2");
		accommodationService.save(acc1);
		accommodationService.save(acc2);
	}
	
	
}
