package com.mphasis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.model.PgPlace;
import com.mphasis.service.OwnerService;
import com.mphasis.service.PgPlaceService;

@RestController
@RequestMapping("/owner/places")

public class OwnerController {
	@Autowired
   PgPlaceService pgService;
	@Autowired
   OwnerService ownerService;

  // 5: Add a new PG place
  @PostMapping("/add")
  public PgPlace addPlace(
      @RequestParam Long ownerId,
      @RequestParam Long cityId,
      @RequestParam Long localityId,
      @RequestBody PgPlace place) {
    return pgService.addPlace(place, ownerId, cityId, localityId);
  }

  // 6: Retrieve all PG places added by the owner
  @GetMapping
  public List<PgPlace> ownerPlaces(@RequestParam Long ownerId) {
    return ownerService.getOwnerPlaces(ownerId);
  }

  // 7: Change the status of PG place (Available or Not Available)
  @PatchMapping("/{id}")
  public PgPlace changeStatus(@PathVariable Long id, @RequestParam String status) {
    PgPlace.AvailabilityStatus s = PgPlace.AvailabilityStatus.valueOf(status.toUpperCase());
    return pgService.changeAvailability(id, s);
  }

  // 8: Edit Place details
  @PutMapping("/edit")
  public PgPlace editPlace(@RequestParam Long placeId, @RequestBody PgPlace updated) {
    return pgService.updatePlace(placeId, updated);
  }

  // 9: Delete Place Details
  @DeleteMapping("/delete")
  public void deletePlace(@RequestParam Long placeId) {
    pgService.deletePlace(placeId);
  }

  // Owner/Tenant registration
  // @PostMapping("/owner/register")
  // @PostMapping("/tenant/register")
}
