package com.mphasis.service;

import java.util.List;

import com.mphasis.entity.User;



public interface UserServiceInterface {

	public List<User> findAll();
	public User findById(Long id);
	public User save(User user);
}
