package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.AccType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.mainbackend.repository.AccTypeRepository;

@Service
public class AccTypeServiceImpl implements AccTypeService {

	@Autowired 
	public AccTypeRepository accTypeRepository;
	
	
	@Override
	public List<AccType> findAll() {
		// TODO Auto-generated method stub
		return accTypeRepository.findAll();
	}

	@Override
	public AccType save(AccType accType) {
		// TODO Auto-generated method stub
		return accTypeRepository.save(accType);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		accTypeRepository.deleteById(id);
	}
}
