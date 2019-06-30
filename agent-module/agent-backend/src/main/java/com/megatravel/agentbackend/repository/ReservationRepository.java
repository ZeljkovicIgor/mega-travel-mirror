package com.megatravel.agentbackend.repository;

import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByRDbId(Long id);
    void deleteAllByRAccommodation(Accommodation accommodation);
}
