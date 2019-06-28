package com.megatravel.mainbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.model.AddService;
import com.megatravel.mainbackend.service.AddServiceService;


@RestController
@RequestMapping(value= "/addServices")
public class AddServicesController {

	@Autowired
	private AddServiceService addServiceService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<AddService>> getAddServices(){
		return new ResponseEntity<>(addServiceService.findAll(), HttpStatus.OK);
	}
	
}
