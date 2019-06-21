package com.megatravel.mainbackend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.model.Message;
import com.megatravel.mainbackend.model.User;
import com.megatravel.mainbackend.service.MessageService;


@RestController
@RequestMapping(value = "/message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
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
