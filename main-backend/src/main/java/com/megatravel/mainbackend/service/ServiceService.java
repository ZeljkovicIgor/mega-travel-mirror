package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.Service;

public interface ServiceService {
	
	List<Service> findAll();
	Service save(Service service);
	void delete(Long id);

}
