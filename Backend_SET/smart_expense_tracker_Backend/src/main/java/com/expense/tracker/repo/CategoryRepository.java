package com.expense.tracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.tracker.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
