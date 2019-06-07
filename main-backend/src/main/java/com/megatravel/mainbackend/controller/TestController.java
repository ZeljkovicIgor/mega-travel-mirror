package com.megatravel.mainbackend.controller;

import java.util.List;

import com.megatravel.mainbackend.model.Message;
import com.megatravel.mainbackend.model.User;
import com.megatravel.mainbackend.model.UserType;
import com.megatravel.mainbackend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.service.UserService;

@RestController
@RequestMapping(value="/api")
public class TestController {

	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers(){
				
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public ResponseEntity<User> addUser(){
		User user = new User();
		user.setUserFirstName("Pera");
		user.setUserLastName("Peric");
		user.setUserType(UserType.ADMIN);

		return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
	}

}
