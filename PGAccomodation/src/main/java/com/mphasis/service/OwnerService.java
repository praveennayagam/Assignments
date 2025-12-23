package com.mphasis.service;

import java.util.List;

import com.mphasis.model.Owner;
import com.mphasis.model.PgPlace;
import com.mphasis.model.Tenant;

public interface OwnerService {
	List<PgPlace> getOwnerPlaces(Long ownerId);
	Owner registerOwner(Owner owner); 
	Tenant registerTenant(Tenant tenant); }