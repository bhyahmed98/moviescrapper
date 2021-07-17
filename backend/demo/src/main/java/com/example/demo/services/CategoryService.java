package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	
	public List<Category> getAllCategory()
	{
		return categoryRepository.findAll();
		
	}
	
	public Category getCategoryById( Long id )
	{	return categoryRepository.findById(id).get()
		;}
	
	public void addCategory(Category category)
	{	categoryRepository.save(category)
		;}
	public void deleteCategory(Long Id)
	{	categoryRepository.deleteById(Id)
	;}
	
	;}
