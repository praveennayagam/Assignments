package com.mphasis.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.mphasis.model.Owner;
import com.mphasis.model.PgPlace;
import com.mphasis.model.Tenant;
import com.mphasis.repository.OwnerRepository;
import com.mphasis.repository.PgPlaceRepository;
import com.mphasis.repository.TenantRepository;

@Service
public class OwnerServiceImpl implements OwnerService {
	private final OwnerRepository ownerRepo;
	private final TenantRepository tenantRepo;
	private final PgPlaceRepository pgRepo;

	@Override
	public List<PgPlace> getOwnerPlaces(Long ownerId) {
		ownerRepo.findById(ownerId).orElseThrow(() -> new NotFoundException("Owner not found"));
		return pgRepo.findByOwner_Id(ownerId);
	}

	@Override
	public Owner registerOwner(Owner owner) {
		if (owner.getAge() < 18)
			throw new ForbiddenException("Owner must be 18+");
		return ownerRepo.save(owner);
	}

	@Override
	public Tenant registerTenant(Tenant tenant) {
		if (tenant.getAge() < 18)
			throw new ForbiddenException("Tenant must be 18+");
		return tenantRepo.save(tenant);
	}

	@Override
	public Owner registerOwner(Owner owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tenant registerTenant(Tenant tenant) {
		// TODO Auto-generated method stub
		return null;
	}
}