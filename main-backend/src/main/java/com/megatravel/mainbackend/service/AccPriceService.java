package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.AccPrice;

import java.util.List;

public interface AccPriceService {
	
	List<AccPrice> findAll();
	AccPrice save(AccPrice accPrice);
	void delete(Long id);
}
