package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.Category;
import com.megatravel.agentbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getOneById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category getOneByDbId(Long id) {
        return categoryRepository.findByCategoryDbId(id);
    }

    @Override
    public Category addOne(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category editOne(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean deleteOne(Category category) {
        categoryRepository.delete(category);
        return (categoryRepository.existsById(category.getCategoryId())?true:false);
    }

    @Override
    public boolean deleteById(Long id) {
        categoryRepository.deleteById(id);
        return (categoryRepository.existsById(id)?true:false);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}
