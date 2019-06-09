package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.AddService;
import org.springframework.beans.factory.annotation.Autowired;


import com.megatravel.mainbackend.repository.AddServiceRepository;
import org.springframework.stereotype.Service;


@Service
public class AddServiceServiceImpl implements AddServiceService {

	@Autowired
	public AddServiceRepository addServiceRepository;
	@Override
	public List<AddService> findAll() {
		// TODO Auto-generated method stub
		return addServiceRepository.findAll();
	}

	@Override
	public AddService save(AddService service) {
		// TODO Auto-generated method stub
		return addServiceRepository.save(service);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		addServiceRepository.deleteById(id);
	}

	
}
