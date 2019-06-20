package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.AddService;
import com.thoughtworks.qdox.model.expression.Add;

import java.util.List;

public interface AddServiceService {
	
	List<AddService> findAll();
	AddService save(AddService service);
	void delete(Long id);
	AddService update(Long id, AddService service);
	List<AddService> findByAccId(Long accId);
	AddService findByid(Long id);
	
}
