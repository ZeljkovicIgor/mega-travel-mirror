package com.megatravel.mainbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.model.User;
import com.megatravel.mainbackend.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers(){
				
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	

}
