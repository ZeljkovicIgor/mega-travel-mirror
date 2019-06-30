package com.megatravel.agentbackend.repository;

import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByRDbId(Long id);
    List<Reservation> findAllByRAccommodation(Accommodation accommodation);
    void deleteAllByRAccommodation(Accommodation accommodation);
}
