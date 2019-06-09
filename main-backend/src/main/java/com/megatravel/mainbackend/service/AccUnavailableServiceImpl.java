package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.AccUnavailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.mainbackend.repository.AccUnavailableRepository;

@Service
public class AccUnavailableServiceImpl implements AccUnavailableService {

	@Autowired
	public AccUnavailableRepository accUnavailableRepository;
	
	@Override
	public List<AccUnavailable> findAll() {
		// TODO Auto-generated method stub
		return accUnavailableRepository.findAll();
	}

	@Override
	public AccUnavailable save(AccUnavailable accUnavailable) {
		// TODO Auto-generated method stub
		return accUnavailableRepository.save(accUnavailable);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		accUnavailableRepository.deleteById(id);
	}
}
