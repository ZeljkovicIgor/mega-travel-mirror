package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.AccLocation;

import java.util.List;


public interface AccLocationService {

	List<AccLocation> findAll();
	AccLocation save(AccLocation accLocation);
	void delete(Long id);
}
