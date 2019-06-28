package com.megatravel.mainbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.megatravel.mainbackend.model.Review;
import com.megatravel.mainbackend.repository.ReviewRepository;

@Service
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

	@Override
	public List<Review> unapprovedComments() {
		List<Review> allReviews = reviewRepository.findAll();
		List<Review> unapproved = new ArrayList<>();
		allReviews.forEach(review -> {
			if(!review.isCommentApproved())
				unapproved.add(review);
		});
		
		return unapproved;
	}

	@Override
	public Review approveComment(Long reviewId) {
		Review review = reviewRepository.getOne(reviewId);
		if(review == null)
			return null;
		
		review.setCommentApproved(true);
		return reviewRepository.save(review);
	}

	@Override
	public List<Review> sortReviewByAsc() {
		// TODO Auto-generated method stub
		return reviewRepository.findAll(Sort.by(Sort.Direction.ASC, "reviewGrade"));
	}

	@Override
	public List<Review> sortReviewByDesc() {
		// TODO Auto-generated method stub
		return  reviewRepository.findAll(Sort.by(Sort.Direction.DESC, "reviewGrade"));
	}
}
