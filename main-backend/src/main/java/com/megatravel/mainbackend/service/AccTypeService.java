package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.AccType;

public interface AccTypeService {
	
	List<AccType> findAll();
	AccType save(AccType accType);
	void delete(Long id);
	
}
