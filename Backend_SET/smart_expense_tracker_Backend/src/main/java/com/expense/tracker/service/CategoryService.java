package com.expense.tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expense.tracker.entity.Category;
import com.expense.tracker.repo.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepo;

	public CategoryService(CategoryRepository categoryRepo) {
		
		this.categoryRepo = categoryRepo;
	}
	
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public List<Category> getAllCategories(){
		return categoryRepo.findAll();
	}
}
