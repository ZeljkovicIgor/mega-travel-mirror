package com.megatravel.agentbackend.repository;

import com.megatravel.agentbackend.model.AccType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccTypeRepository extends JpaRepository<AccType, Long> {
}
