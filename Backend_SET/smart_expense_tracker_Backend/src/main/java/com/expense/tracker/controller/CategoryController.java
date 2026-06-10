package com.expense.tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.tracker.entity.Category;
import com.expense.tracker.service.CategoryService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	
	@GetMapping
	public List<Category> getAllCategories(){
		return categoryService.getAllCategories();
	}
	
}
