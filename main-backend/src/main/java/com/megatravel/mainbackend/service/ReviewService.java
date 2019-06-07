package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.Review;

public interface ReviewService {
	
	List<Review> findAll();
	Review save(Review review);
	void delete(Long id);

}
