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
		return addServiceRepository.findAll();
	}

	@Override
	public AddService save(AddService service) {
		return addServiceRepository.save(service);
	}

	@Override
	public void delete(Long id) {
		addServiceRepository.deleteById(id);
	}

	@Override
	public AddService update(Long id, AddService service) {
		
		if(!addServiceRepository.findById(id).isPresent())
			return null;
		
		service.setServiceId(id);
		return addServiceRepository.save(service);
	}

	@Override
	public List<AddService> findByAccId(Long accId) {
		return addServiceRepository.findAll();
	}

	@Override
	public AddService findByid(Long id) {
		return addServiceRepository.getOne(id);
	}


}
