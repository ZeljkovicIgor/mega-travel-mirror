package com.megatravel.agentbackend.repository;

import com.megatravel.agentbackend.model.AccUnavailable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccUnavailableRepository extends JpaRepository<AccUnavailable, Long> {
}
