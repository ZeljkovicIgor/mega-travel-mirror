package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.AccPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.mainbackend.repository.AccPriceRepository;

@Service
public class AccPriceServiceImpl implements AccPriceService {

	
	@Autowired
	public AccPriceRepository accPriceRepository;
	
	@Override
	public List<AccPrice> findAll() {
		// TODO Auto-generated method stub
		return accPriceRepository.findAll();
	}

	@Override
	public AccPrice save(AccPrice accPrice) {
		// TODO Auto-generated method stub
		return accPriceRepository.save(accPrice);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		accPriceRepository.deleteById(id);
	}
}
