package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();
    Category getOneById(Long id);
    Category getOneByDbId(Long id);
    Category addOne(Category category);
    Category editOne(Category category);
    boolean deleteOne(Category category);
    boolean deleteById(Long id);
    void deleteAll();
    //convertFromDto();
    //convertToDto();
}
