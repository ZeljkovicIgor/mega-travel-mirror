package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.AccPrice;

public interface AccPriceService {
	
	List<AccPrice> findAll();
	AccPrice save(AccPrice accPrice);
	void delete(Long id);
}
