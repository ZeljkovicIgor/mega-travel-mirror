package com.megatravel.mainbackend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.model.Review;
import com.megatravel.mainbackend.service.ReviewService;



@RestController
@RequestMapping(value = "/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	//	get neodobrene komentare
	@RequestMapping(value="/getUnapprovedComments", method=RequestMethod.GET)
	public ResponseEntity<List<Review>> getUnapprovedComments(HttpServletRequest request){
		/*
		 * User logged = (User) request.getSession().getAttribute("logged");
		 * if(logged.getUserType() != UserType.ADMIN) return new
		 * ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		 */
		
		return new ResponseEntity<List<Review>>(reviewService.unapprovedComments(), HttpStatus.OK);
	}
	
	//	odobri komentar
	@RequestMapping(value="/approveComment/{reviewId}", method=RequestMethod.PUT)
	public ResponseEntity<Review> approveComment(@PathVariable("reviewId") Long reviewId, HttpServletRequest request){
		/*
		 * User logged = (User) request.getSession().getAttribute("logged");
		 * if(logged.getUserType() != UserType.ADMIN) return new
		 * ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		 */
		Review review = reviewService.approveComment(reviewId);
		if(review == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//	mozda bi bilo zgodno i da postoji atribut koji kaze da li je admin pregledao komentar...tako da mu se ti ne prikazuju
	
}
