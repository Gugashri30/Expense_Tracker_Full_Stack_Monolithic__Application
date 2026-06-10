package com.expense.tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expense.tracker.entity.Category;
import com.expense.tracker.entity.Expense;
import com.expense.tracker.entity.User;
import com.expense.tracker.repo.CategoryRepository;
import com.expense.tracker.repo.ExpenseRepository;
import com.expense.tracker.repo.UserRepository;

@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepo;
	private final UserRepository userRepo;
	private final CategoryRepository categoryRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo, UserRepository userRepo, CategoryRepository categoryRepo) {
		
		this.expenseRepo = expenseRepo;
		this.userRepo = userRepo;
		this.categoryRepo = categoryRepo;
	}

	public Expense addExpense(Long userId,Long categoryId,Expense expense) {
		
		User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
		Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
		
		expense.setUser(user);
		expense.setCategory(category);
		
		return expenseRepo.save(expense);
	}
	
	public List<Expense> getExpenseByUser(Long userId){
		return expenseRepo.findByUserId(userId);
	}
	
	public List<Expense> getAllExpenses(){
		return expenseRepo.findAll();
	}
	
}
