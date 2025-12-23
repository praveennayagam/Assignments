package com.mphasis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mphasis.model.PgPlace;

public interface PgPlaceRepository extends JpaRepository<PgPlace, Long> {
	  List<PgPlace> findByCity_IdAndAvailability(Long cityId, PgPlace.AvailabilityStatus status);
	  List<PgPlace> findByLocality_NameIgnoreCaseAndAvailability(String locality, PgPlace.AvailabilityStatus status);
	  List<PgPlace> findByOwner_Id(Long ownerId);
	}

	
