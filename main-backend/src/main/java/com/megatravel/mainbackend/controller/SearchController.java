package com.megatravel.mainbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.service.AccommodationService;
import com.megatravel.mainbackend.service.UserService;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

	 @Autowired
	 private UserService userService;
	
	 @Autowired 
	 private AccommodationService accommodationService;
	
	
}
