package com.megatravel.mainbackend;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.megatravel.mainbackend.model.User;
import com.megatravel.mainbackend.model.UserType;
import com.megatravel.mainbackend.service.UserService;

@Component
public class TestData {

	@Autowired
	private UserService userService;
	
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
	}
	
	
}
