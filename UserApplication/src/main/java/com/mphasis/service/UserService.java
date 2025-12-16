package com.mphasis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.entity.User;
import com.mphasis.repository.UserRepository;
@Service
public class UserService implements UserServiceInterface {
	@Autowired
	UserRepository repository;

	@Override
	public List<User> findAll() {
		
		return repository.findAll();
	}

	@Override
	public User findById(Long id) {
		
		return repository.findById(id).get();
	}

	@Override
	public User save(User user) {
		
		return repository.save(user);
	}

}
