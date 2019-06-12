package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.AccType;

import java.util.List;

public interface AccTypeService {
	
	List<AccType> findAll();
	AccType save(AccType accType);
	void delete(Long id);
	AccType update(Long id, AccType accType);
	
}
