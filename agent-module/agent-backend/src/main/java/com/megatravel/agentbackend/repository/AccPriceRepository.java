package com.megatravel.agentbackend.repository;

import com.megatravel.agentbackend.model.AccPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccPriceRepository extends JpaRepository<AccPrice, Long> {
}
