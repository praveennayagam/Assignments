package com.mphasis.service;

import java.util.List;

import com.mphasis.model.Owner;
import com.mphasis.model.PgPlace;

public interface PgPlaceService { 
	
	List<PgPlace> getAvailableByCity(Long cityId); 
	List<PgPlace> getAvailableByLocality(String locality); 
	PgPlace getPlaceDetails(Long id); 
	Owner getOwnerDetailsIfAvailable(Long placeId); 
	PgPlace addPlace(PgPlace place, Long ownerId, Long cityId, Long localityId);
	PgPlace updatePlace(Long placeId, PgPlace updated); void deletePlace(Long placeId); 
	PgPlace changeAvailability(Long placeId, PgPlace.AvailabilityStatus status); }