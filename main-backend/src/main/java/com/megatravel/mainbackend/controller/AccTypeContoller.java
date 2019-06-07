package com.megatravel.mainbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.service.AccTypeService;


@RestController
@RequestMapping(value= "/accType")
public class AccTypeContoller {

	@Autowired
	private AccTypeService accTypeService;

}
