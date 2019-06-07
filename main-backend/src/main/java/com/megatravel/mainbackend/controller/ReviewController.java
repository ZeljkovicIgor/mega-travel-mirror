package com.megatravel.mainbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.service.ReviewService;



@RestController
@RequestMapping(value = "/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
}
