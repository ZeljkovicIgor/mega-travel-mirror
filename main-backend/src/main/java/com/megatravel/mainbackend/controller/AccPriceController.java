package com.megatravel.mainbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.service.AccPriceService;


@RestController
@RequestMapping(value= "/accPrice")
public class AccPriceController {

	@Autowired
	private AccPriceService accPriceService;
	
}
