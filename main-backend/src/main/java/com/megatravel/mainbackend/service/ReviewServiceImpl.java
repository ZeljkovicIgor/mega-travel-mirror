package com.megatravel.mainbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.megatravel.mainbackend.model.Review;
import com.megatravel.mainbackend.repository.ReviewRepository;

public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Override
	public List<Review> findAll() {
		// TODO Auto-generated method stub
		return reviewRepository.findAll();
	}

	@Override
	public Review save(Review review) {
		// TODO Auto-generated method stub
		return reviewRepository.save(review);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		reviewRepository.deleteById(id);
	}
}
