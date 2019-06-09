package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.AccUnavailable;

import java.util.List;

public interface AccUnavailableService {
	
	
	List<AccUnavailable> findAll();
	AccUnavailable save(AccUnavailable accUnavailable);
	void delete(Long id);
}
