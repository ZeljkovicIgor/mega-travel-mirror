package com.megatravel.mainbackend.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.megatravel.mainbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.dto.UserDto;
import com.megatravel.mainbackend.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") Long id){
		User user=userService.findOne(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable("id") Long id){
		
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<User> registerUser(@RequestBody UserDto userDto){
		User user = userService.registerNewUserAccount(userDto);
		if(user!=null) {
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
	
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<User> loginUser(@RequestBody UserDto userDto,HttpSession session,HttpServletRequest request){
		User logged=userService.signIn(userDto);
		
		if(logged!=null ){
			System.out.println("Logged je ime "+ logged.getUserUsername());
			HttpSession newSession = request.getSession();
		    newSession.setAttribute("logged", logged);
			return new ResponseEntity<>(logged,HttpStatus.OK);
			
		}
		
		return new ResponseEntity<>(logged,HttpStatus.NOT_FOUND);
	}
	

																																	
	@RequestMapping(value="/loggoutUser", method=RequestMethod.GET)
	public ResponseEntity<String> logoutUser(HttpSession session,HttpServletRequest request){
			request.getSession().invalidate();
	
			return new ResponseEntity<String>("User logged out",HttpStatus.OK);	
	}
	
	
}
