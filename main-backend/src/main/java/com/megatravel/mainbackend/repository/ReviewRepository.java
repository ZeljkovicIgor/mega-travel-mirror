package com.megatravel.mainbackend.repository;

import com.megatravel.mainbackend.model.Accommodation;
import com.megatravel.mainbackend.model.Reservation;
import com.megatravel.mainbackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    void deleteAllByReviewAccommodation(Accommodation reviewAccommodation);
    List<Reservation> findAllByReviewAccommodation(Accommodation accommodation);
}
