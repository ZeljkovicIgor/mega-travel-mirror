package com.megatravel.mainbackend.repository;

import com.megatravel.mainbackend.model.AccPrice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccPriceRepository extends JpaRepository<AccPrice, Long> {
	 List<AccPrice> findByOrderByPriceValueAsc();
}
