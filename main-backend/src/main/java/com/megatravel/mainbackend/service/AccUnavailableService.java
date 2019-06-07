package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.AccUnavailable;

public interface AccUnavailableService {
	
	
	List<AccUnavailable> findAll();
	AccUnavailable save(AccUnavailable accUnavailable);
	void delete(Long id);
}
