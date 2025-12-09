package com.mphasis.dao;

import java.util.List;

import com.mphasis.entities.Person;

public interface PersonDaoInterface {
	
	public List<Person>findAll();
	public void addPerson(Person person);
	public Person findById(Long id);
	public Person findByPersonIdWithPassportDetails(Long id);
}
