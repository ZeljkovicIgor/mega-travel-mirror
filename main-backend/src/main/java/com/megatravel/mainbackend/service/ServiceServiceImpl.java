package com.megatravel.mainbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.mainbackend.repository.ServiceRepository;


@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	public ServiceRepository serviceRepository;
	@Override
	public List<com.megatravel.mainbackend.model.Service> findAll() {
		// TODO Auto-generated method stub
		return serviceRepository.findAll();
	}

	@Override
	public com.megatravel.mainbackend.model.Service save(com.megatravel.mainbackend.model.Service service) {
		// TODO Auto-generated method stub
		return serviceRepository.save(service);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		serviceRepository.deleteById(id);
	}

	
}
