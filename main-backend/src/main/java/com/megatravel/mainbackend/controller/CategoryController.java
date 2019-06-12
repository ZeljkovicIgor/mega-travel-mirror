package com.megatravel.mainbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.model.Category;
import com.megatravel.mainbackend.service.CategoryService;



@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public ResponseEntity<Category> addCategory(@RequestBody Category newCategory){
		Category category = categoryService.save(newCategory);
		
		if(category == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getCategories", method=RequestMethod.GET)
	public ResponseEntity<List<Category>> getCategories(){
		return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateCategory/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable("id") long id){
		Category newCategory = categoryService.update(id, category);
		
		if(newCategory == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(newCategory, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteCategory/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Category> deleteCategory(@PathVariable("id") long id){
		categoryService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
