package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.Review;
import com.megatravel.agentbackend.repository.ReservationRepository;
import com.megatravel.agentbackend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getOneById(Long id) {
        return reviewRepository.getOne(id);
    }

    @Override
    public Review addOne(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review editOne(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public boolean deleteOne(Review review) {
        reviewRepository.delete(review);
        return (reviewRepository.existsById(review.getReviewId())?true:false);
    }

    @Override
    public boolean deleteById(Long id) {
        reviewRepository.deleteById(id);
        return (reviewRepository.existsById(id)?true:false);
    }
}
