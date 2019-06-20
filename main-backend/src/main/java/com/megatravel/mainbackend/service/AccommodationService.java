package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.AccPrice;
import com.megatravel.mainbackend.model.Accommodation;

import java.util.List;

public interface AccommodationService {
	
	List<Accommodation> findAll();
	Accommodation save(Accommodation accommodation);
	void delete(Long id);
	Accommodation findOne(Long id);
	List<Accommodation> findByAgentId(Long agentId);
	List<AccPrice> getPricePlan(Long accId);


	
}
