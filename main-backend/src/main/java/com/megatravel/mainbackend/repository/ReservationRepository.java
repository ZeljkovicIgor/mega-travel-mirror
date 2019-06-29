package com.megatravel.mainbackend.repository;

import com.megatravel.mainbackend.model.Accommodation;
import com.megatravel.mainbackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByRAccommodation(Accommodation rAccommodation);
    void deleteAllByRAccommodation(Accommodation rAccommodation);

}
