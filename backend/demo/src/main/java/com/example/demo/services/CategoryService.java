package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Actor;
import com.example.demo.model.Category;
import com.example.demo.repository.ActorRepository;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getall() {
		return categoryRepository.findAll() ; 
	}
	
	public Optional<Category>  get (long id){
		return categoryRepository.findById(id) ; 
	}
	
    public void delete(long id ){
    	categoryRepository.deleteById(id);
    }
    
	public Category Add(Category category) {
		return categoryRepository.save(category) ; 
	}
	

	

   

}