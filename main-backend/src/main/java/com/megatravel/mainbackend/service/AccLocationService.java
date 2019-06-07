package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.AccLocation;



public interface AccLocationService {

	List<AccLocation> findAll();
	AccLocation save(AccLocation accLocation);
	void delete(Long id);
}
