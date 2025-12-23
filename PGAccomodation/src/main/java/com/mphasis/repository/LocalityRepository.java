package com.mphasis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mphasis.model.Locality;

public interface LocalityRepository extends JpaRepository<Locality, Long> { 
	Optional<Locality> findByNameIgnoreCaseAndCity_Id(String name, Long cityId);
	}