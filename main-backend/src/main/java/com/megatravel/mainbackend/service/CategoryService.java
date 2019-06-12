package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.Category;

import java.util.List;

public interface CategoryService {
	
	List<Category> findAll();
	Category save(Category category);
	void delete(Long id);
	Category update(Long id, Category category);
	
}
