package com.megatravel.mainbackend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.dto.ReservationDto;
import com.megatravel.mainbackend.dto.UserDto;
import com.megatravel.mainbackend.model.Reservation;
import com.megatravel.mainbackend.model.User;
import com.megatravel.mainbackend.service.ReservationService;
import com.megatravel.mainbackend.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ReservationService reservationService;
	
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
	
	@CrossOrigin
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<User> registerUser(@RequestBody UserDto userDto){
		User user = userService.registerNewUserAccount(userDto);
		if(user!=null) {
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
	
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@CrossOrigin
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<User> loginUser(@RequestBody UserDto userDto,HttpSession session,HttpServletRequest request){
		User logged=userService.signIn(userDto);
		
		if(logged!=null ){
			HttpSession newSession = request.getSession();
		    newSession.setAttribute("logged", logged);
			return new ResponseEntity<>(logged,HttpStatus.OK);
			
		}
		
		return new ResponseEntity<>(logged,HttpStatus.NOT_FOUND);
	}
	

	@CrossOrigin
	@RequestMapping(value="/loggoutUser", method=RequestMethod.GET)
	public ResponseEntity<String> logoutUser(HttpSession session,HttpServletRequest request){
			request.getSession().invalidate();
	
			return new ResponseEntity<String>("User logged out",HttpStatus.OK);	
	}
	
	//lista rezervacija krajnjeg korisnika
	@RequestMapping(value="/reservations", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReservationDto>> getUserReservation(HttpServletRequest request){
		User logged =(User) request.getSession().getAttribute("logged");

		List<Reservation> reservationsAll = reservationService.findByUserId(logged.getUserId());
	
		List<Reservation> reservations = new ArrayList<Reservation>();
		for(Reservation r : reservationsAll) {
			if(r.isCancelled()==false) {
				reservations.add(r);
			}
		}
		List<ReservationDto> reservationsDto = reservationService.convertToDtoList(reservations);
		
		return new ResponseEntity<>(reservationsDto,HttpStatus.OK);
	}
	/**
	 * 		BLOKIRANJE, AKTIVIRANJE i BRISANJE obicnih korisnika
	 */
	
	@RequestMapping(value="/deleteEndUser/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteEndUser(@PathVariable("id") Long id, HttpServletRequest request){
		User loggedUser = (User) request.getSession().getAttribute("logged");
		/*
		 * if(loggedUser == null) return new
		 *	ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		 */
		
		User deletedUser = userService.deleteUser(id);
		if(deletedUser == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<User>(deletedUser, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/blockUser/{id}", method=RequestMethod.PUT)
	public ResponseEntity<User> blockUser(@PathVariable("id") Long id, HttpServletRequest request){
		User loggedUser = (User) request.getSession().getAttribute("logged");
		/*
		 * if(loggedUser == null) return new
		 *	ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		 */
		
		User blockedUser = userService.blockActivateUser(id, false);
		if(blockedUser == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<User>(blockedUser, HttpStatus.OK);
	}
	
	@RequestMapping(value="/activateUser/{id}", method=RequestMethod.PUT)
	public ResponseEntity<User> activateUser(@PathVariable("id") Long id, HttpServletRequest request){
		User loggedUser = (User) request.getSession().getAttribute("logged");
		/*
		 * if(loggedUser == null) return new
		 *	ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		 */
		
		User activatedUser = userService.blockActivateUser(id, true);
		if(activatedUser == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<User>(activatedUser, HttpStatus.OK);
	}
	
	/**
	 * 		registracija agenta
	 */
	
	@RequestMapping(value="/registerAgent", method=RequestMethod.POST)
	public ResponseEntity<User> registerAgent(@RequestBody User agent, HttpServletRequest request){
		User loggedUser = (User) request.getSession().getAttribute("logged");
		/*
		 * if(loggedUser == null) return new
		 *	ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		 */
		
		userService.registerAgent(agent);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
