package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.AccLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.mainbackend.repository.AccLocationRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccLocationServiceImpl implements AccLocationService {

	@Autowired
	public AccLocationRepository accLocationRepository;
	@Override
	public List<AccLocation> findAll() {
		// TODO Auto-generated method stub
		return accLocationRepository.findAll();
	}

	@Override
	public AccLocation save(AccLocation accLocation) {
		// TODO Auto-generated method stub
		return accLocationRepository.save(accLocation);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		accLocationRepository.deleteById(id);
	}

}
