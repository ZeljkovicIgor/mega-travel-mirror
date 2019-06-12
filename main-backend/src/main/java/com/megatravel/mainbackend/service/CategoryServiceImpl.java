package com.megatravel.mainbackend.service;

import java.util.List;

import com.megatravel.mainbackend.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.mainbackend.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	public CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public Category update(Long id, Category category) {
		
		if(!categoryRepository.findById(id).isPresent())
			return null;
		
		category.setCategoryId(id);
		return categoryRepository.save(category);
	}
}
