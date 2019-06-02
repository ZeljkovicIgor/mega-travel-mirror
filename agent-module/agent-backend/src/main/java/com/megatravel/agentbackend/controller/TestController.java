package com.megatravel.agentbackend.controller;

import com.megatravel.agentbackend.model.User;
import com.megatravel.agentbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {

	@Autowired
	UserService userService;


	@GetMapping(value="/test")
	public String testController() {
		User user = new User();
		user.setUserFirstName("Pera");
		user.setUserLastName("Peric");
		userService.addUser(user);
		return "test";
	}
	@GetMapping(value="/all")
	public String getAll() {
		return "all";
	}
	@GetMapping(value="/one")
	public String getOne() {
		return "one";
	}
	@PostMapping(value="/add")
	public String add() {
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
