package com.expense.tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expense.tracker.entity.Expense;
import com.expense.tracker.service.ExpenseService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	private final ExpenseService expenseService;

	public ExpenseController(ExpenseService expenseService) {
		
		this.expenseService = expenseService;
	}
	
	@PostMapping
	public Expense addExpenses(@RequestParam Long userId,@RequestParam Long categoryId,@RequestBody Expense expense) {
		return expenseService.addExpense(userId, categoryId, expense);
	}
	
	@GetMapping("/userr/{userId}")
	public List<Expense> getExpensesByUser(@PathVariable Long userId){
		return expenseService.getExpenseByUser(userId);
	}
	
	@GetMapping
	public List<Expense> getAllExpenses(){
		return expenseService.getAllExpenses();
	}
}
