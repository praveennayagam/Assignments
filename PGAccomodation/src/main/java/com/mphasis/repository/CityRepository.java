package com.mphasis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mphasis.model.City;

public interface CityRepository extends JpaRepository<City, Long> {} 
