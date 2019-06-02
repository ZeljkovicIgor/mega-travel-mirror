package com.megatravel.agentbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megatravel.agentbackend.model.AccType;

@Repository
public interface AccTyperRepository extends JpaRepository<AccType, Long> {

}
