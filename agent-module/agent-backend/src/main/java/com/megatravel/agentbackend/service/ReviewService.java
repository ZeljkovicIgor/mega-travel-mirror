package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAll();
    Review getOneById(Long id);
    Review getOneByDbId(Long id);
    Review addOne(Review review);
    Review editOne(Review review);
    List<Review> getAccommodationReviews(long accommodationId);
    boolean deleteOne(Review review);
    boolean deleteById(Long id);
    void deleteAll();
    //convertFromDto();
    //convertToDto();
}
