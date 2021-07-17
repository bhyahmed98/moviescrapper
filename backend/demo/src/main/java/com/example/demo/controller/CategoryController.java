package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/category")
	private List<Category> getCategory()
	
	{	return categoryService.getAllCategory();
		}
	
	@GetMapping("/category/{categoryid}")
	private Category getCategory(@PathVariable("categoryid)") Long id)
	{
		return categoryService.getCategoryById(id);
	}
	@DeleteMapping("/category/{categoryid}")
	private void deleteCategory(@PathVariable("id") Long id)
	{	categoryService.deleteCategory(id)
		;}
	@PostMapping("/category")
	private void addCategory(@RequestBody Category category)
	{	categoryService.addCategory(category)
		;}


}


