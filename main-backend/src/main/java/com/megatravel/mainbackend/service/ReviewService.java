package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.Review;

import java.util.List;

public interface ReviewService {
	
	List<Review> findAll();
	Review save(Review review);
	void delete(Long id);
	List<Review> unapprovedComments();
	Review approveComment(Long reviewId);

}
