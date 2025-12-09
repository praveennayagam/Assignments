package com.mphasis.dao;

import java.util.List;

import com.mphasis.entities.Passport;

public interface PassportDaoInterface {
	
	public List<Passport> findAll();
	public void addPassport(Passport passport);
	public Passport findById(Long id); 
	public Passport findByPersonId(Long id);
}
