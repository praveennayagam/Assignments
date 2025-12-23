package com.mphasis.service;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.mphasis.model.City;
import com.mphasis.model.Locality;
import com.mphasis.model.Owner;
import com.mphasis.model.PgPlace;
import com.mphasis.repository.CityRepository;
import com.mphasis.repository.LocalityRepository;
import com.mphasis.repository.OwnerRepository;
import com.mphasis.repository.PgPlaceRepository;

@Service
public class PgPlaceServiceImpl implements PgPlaceService {
	private final PgPlaceRepository pgRepo;
	private final OwnerRepository ownerRepo;
	private final CityRepository cityRepo;
	private final LocalityRepository locRepo;

	@Override
	public List<PgPlace> getAvailableByCity(Long cityId) {
		cityRepo.findById(cityId).orElseThrow(() -> new NotFoundException("City not found"));
		return pgRepo.findByCity_IdAndAvailability(cityId, PgPlace.AvailabilityStatus.AVAILABLE);
	}

	@Override
	public List<PgPlace> getAvailableByLocality(String locality) {
		if (locality == null || !locality.matches("^[A-Za-z\\s]+$"))
			throw new BadRequestException("Locality must be text");
		return pgRepo.findByLocality_NameIgnoreCaseAndAvailability(locality, PgPlace.AvailabilityStatus.AVAILABLE);
	}

	@Override
	public PgPlace getPlaceDetails(Long id) {
		PgPlace place = pgRepo.findById(id).orElseThrow(() -> new NotFoundException("Place not found"));
		place.setViewCount(place.getViewCount() + 1);
		return pgRepo.save(place);
	}

	@Override
	public Owner getOwnerDetailsIfAvailable(Long placeId) {
		PgPlace place = pgRepo.findById(placeId).orElseThrow(() -> new NotFoundException("Place not found"));
		if (place.getAvailability() != PgPlace.AvailabilityStatus.AVAILABLE)
			throw new ForbiddenException("Owner contact hidden: place is occupied");
		return place.getOwner();
	}

	@Override
	public PgPlace addPlace(PgPlace place, Long ownerId, Long cityId, Long localityId) {
		Owner owner = ownerRepo.findById(ownerId).orElseThrow(() -> new NotFoundException("Owner not found"));
		if (owner.getAge() < 18)
			throw new ForbiddenException("Owner must be 18+");
		City city = cityRepo.findById(cityId).orElseThrow(() -> new NotFoundException("City not found"));
		Locality locality = locRepo.findById(localityId).orElseThrow(() -> new NotFoundException("Locality not found"));
		place.setOwner(owner);
		place.setCity(city);
		place.setLocality(locality);
		place.setAvailability(PgPlace.AvailabilityStatus.AVAILABLE);
		return pgRepo.save(place);
	}

	@Override
	public PgPlace updatePlace(Long placeId, PgPlace updated) {
		PgPlace existing = pgRepo.findById(placeId).orElseThrow(() -> new NotFoundException("Place not found"));
		existing.setBuiltUpArea(updated.getBuiltUpArea());
		existing.setRentAmount(updated.getRentAmount());
		existing.setRegistrationNumber(updated.getRegistrationNumber());
		existing.setAvailability(updated.getAvailability());
		return pgRepo.save(existing);
	}

	@Override
	public void deletePlace(Long placeId) {
		PgPlace existing = pgRepo.findById(placeId).orElseThrow(() -> new NotFoundException("Place not found"));
		pgRepo.delete(existing);
	}

	@Override
	public PgPlace changeAvailability(Long placeId, PgPlace.AvailabilityStatus status) {
		PgPlace existing = pgRepo.findById(placeId).orElseThrow(() -> new NotFoundException("Place not found"));
		existing.setAvailability(status);
		return pgRepo.save(existing);
	}
}