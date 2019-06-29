package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.Accommodation;
import com.megatravel.mainbackend.model.Review;

import java.util.List;

public interface ReviewService {
	
	List<Review> findAll();
	Review save(Review review);
	void delete(Long id);
	List<Review> unapprovedComments();
	Review approveComment(Long reviewId);


	
	
	List<Review> sortReviewByAsc();
	List<Review> sortReviewByDesc();
    List<Review> getAgentAccReviews(Long id);
    void deleteByAccommodation(Accommodation accommodation);
}
