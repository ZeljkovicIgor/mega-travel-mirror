package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.model.Review;
import com.megatravel.agentbackend.repository.ReservationRepository;
import com.megatravel.agentbackend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    AccommodationService accommodationService;

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getOneById(Long id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public Review getOneByDbId(Long id) {
        return reviewRepository.findByReviewDbId(id);
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
    public List<Review> getAccommodationReviews(long accommodtaionId) {
        List<Review> reviewList = new ArrayList<>();
        Accommodation  accommodation = accommodationService.getOneById(accommodtaionId);
        reviewList = reviewRepository.findByReviewAccommodation(accommodation);
        return reviewList;
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

    @Override
    public void deleteAll() {
        reviewRepository.deleteAll();
    }
}
