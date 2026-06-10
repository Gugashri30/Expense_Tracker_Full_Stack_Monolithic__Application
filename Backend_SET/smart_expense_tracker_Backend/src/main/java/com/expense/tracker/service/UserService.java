package com.expense.tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expense.tracker.entity.User;
import com.expense.tracker.repo.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		
		this.userRepo = userRepo;
	}
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
}
