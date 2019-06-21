package com.megatravel.mainbackend.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.model.Message;
import com.megatravel.mainbackend.model.MessageStatus;
import com.megatravel.mainbackend.model.Reservation;
import com.megatravel.mainbackend.model.User;
import com.megatravel.mainbackend.service.MessageService;
import com.megatravel.mainbackend.service.ReservationService;
import com.megatravel.mainbackend.service.UserService;


@RestController
@RequestMapping(value = "/message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReservationService reservationService;

	@RequestMapping(value = "/send/{idR}/{idRes}",method = RequestMethod.POST)
	public ResponseEntity<Message> sendMessage(@RequestBody Message message,@PathVariable("idR") Long idR,@PathVariable("idRes") Long idRes,HttpServletRequest request){
		User loggedUser = (User) request.getSession().getAttribute("logged");
		Reservation r = reservationService.findOne(idRes);
		if(loggedUser==null && r==null) {
			new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		message.setMessageDate(new Date());
		message.setMessageSender(loggedUser);
		message.setMessageReservation(r);
		message.setStatus(MessageStatus.SENT);
		message.setMessageReciever(userService.findOne(idR));
		messageService.save(message);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Message> deleteMessage(@PathVariable("id") Long id){
		
		messageService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//poslate poruke
	@RequestMapping(value="/getSendMessages", method=RequestMethod.GET)
	public ResponseEntity<List<Message>> getMessagesSender(HttpServletRequest request){
		User loggedUser = (User) request.getSession().getAttribute("logged");
		List<Message> ret =messageService.findBySender_id(loggedUser.getUserId()); 
	
		return new ResponseEntity<>(ret,HttpStatus.OK);
	}
	
	//primljene poruke
	@RequestMapping(value="/getRecievedMessages", method=RequestMethod.GET)
	public ResponseEntity<List<Message>> getMessagesReciever(HttpServletRequest request){
		User loggedUser = (User) request.getSession().getAttribute("logged");
		List<Message> ret =messageService.findByReciever_id(loggedUser.getUserId()); 
		
		return new ResponseEntity<>(ret,HttpStatus.OK);
	}
	
}
