package com.megatravel.mainbackend.repository;

import com.megatravel.mainbackend.model.AccPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccPriceRepository extends JpaRepository<AccPrice, Long> {
}
