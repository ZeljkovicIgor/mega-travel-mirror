package com.megatravel.agentbackend.repository;

import com.megatravel.agentbackend.model.AccLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccLocationRepository extends JpaRepository<AccLocation, Long> {
}
