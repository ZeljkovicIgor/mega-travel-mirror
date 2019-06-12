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
		return accTypeRepository.findAll();
	}

	@Override
	public AccType save(AccType accType) {
		return accTypeRepository.save(accType);
	}

	@Override
	public void delete(Long id) {
		accTypeRepository.deleteById(id);
	}

	@Override
	public AccType update(Long id, AccType accType) {
		
		if(!accTypeRepository.findById(id).isPresent())
			return null;
		
		accType.setAccTypeId(id);
		return accTypeRepository.save(accType);
	}
}
