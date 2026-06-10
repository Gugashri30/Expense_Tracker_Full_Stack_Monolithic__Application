package com.expense.tracker.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.tracker.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense,Long>{

	List<Expense> findByUserId(Long userId);

}
