package com.megatravel.agentbackend.repository;

import com.megatravel.agentbackend.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    Accommodation findByAccDbId(Long id);

}
