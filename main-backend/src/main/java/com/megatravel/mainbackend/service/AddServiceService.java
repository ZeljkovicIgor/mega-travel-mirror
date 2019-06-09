package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.AddService;

import java.util.List;

public interface AddServiceService {
	
	List<AddService> findAll();
	AddService save(AddService service);
	void delete(Long id);

}
