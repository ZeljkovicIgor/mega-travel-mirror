package com.megatravel.mainbackend.repository;

import com.megatravel.mainbackend.model.AccLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccLocationRepository extends JpaRepository<AccLocation, Long> {
}
