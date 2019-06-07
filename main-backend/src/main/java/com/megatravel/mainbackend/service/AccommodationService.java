package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.Accommodation;

public interface AccommodationService {
	
	List<Accommodation> findAll();
	Accommodation save(Accommodation accommodation);
	void delete(Long id);
	
}
