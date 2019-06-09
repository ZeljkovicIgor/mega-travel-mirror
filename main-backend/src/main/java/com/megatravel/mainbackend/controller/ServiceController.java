package com.megatravel.mainbackend.controller;

import com.megatravel.mainbackend.service.AddServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/service")
public class ServiceController{

	@Autowired
	private AddServiceService serviceService;
	
}
