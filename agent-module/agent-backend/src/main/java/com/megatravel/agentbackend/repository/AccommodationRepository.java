package com.megatravel.agentbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megatravel.agentbackend.model.Accommodation;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

}
