package com.megatravel.agentbackend.controller;

import com.megatravel.agentbackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( origins = "http://localhost:4200")
@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping
    public ResponseEntity<?> getAllReviews(){

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/accommodation/{id}")
    public ResponseEntity<?> getAllReviews(@PathVariable(value = "id") long id){

        return new ResponseEntity<>( reviewService.getAccommodationReviews(id),HttpStatus.OK);
    }
}
