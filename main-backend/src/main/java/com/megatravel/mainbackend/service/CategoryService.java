package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.Category;

public interface CategoryService {
	
	List<Category> findAll();
	Category save(Category category);
	void delete(Long id);
	
}
