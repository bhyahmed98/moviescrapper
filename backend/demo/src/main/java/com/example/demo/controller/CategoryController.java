package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Actor;
import com.example.demo.model.Category;
import com.example.demo.services.ActorService;
import com.example.demo.services.CategoryService;

public class CategoryController {	
    
	@Autowired
    CategoryService categoryService;
	    
    @PostMapping("/add")
    public Category saveAroduct(@RequestBody Category category) {
		return categoryService.Add(category) ; 
	}
        
	@GetMapping("/getall")
	public List<Category> getAll(){
		return categoryService.getall() ; 
	}
	
	@GetMapping("/get/{id}")
	public Optional<Category> get(@PathVariable("id") long id){
		return categoryService.get(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		categoryService.delete(id);
	}
	
	




}

