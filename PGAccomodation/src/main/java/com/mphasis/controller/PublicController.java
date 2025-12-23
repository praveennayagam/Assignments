package com.mphasis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.model.Owner;
import com.mphasis.model.PgPlace;
import com.mphasis.service.PgPlaceService;

@RestController
@RequestMapping("/pg")

public class PublicController {

	@Autowired
   PgPlaceService pgService;

  // 1: Retrieve available PG places in a specific city
  @GetMapping("/{city_id}")
  public List<PgPlace> getByCity(@PathVariable("city_id") Long cityId) {
    return pgService.getAvailableByCity(cityId);
  }

  // 2: List available PG places in a specific locality
  @GetMapping("/locality/{locality}")
  public List<PgPlace> getByLocality(@PathVariable String locality) {
    return pgService.getAvailableByLocality(locality);
  }

  // 3: Retrieve a specific PG place detail by id
  @GetMapping("/details/{id}")
  public PgPlace getDetails(@PathVariable Long id) {
    return pgService.getPlaceDetails(id);
  }

  // 4: Retrieve the owner details of a specific PG (only if available)
  @GetMapping("/owner/{id}")
  public Owner getOwner(@PathVariable Long id) {
    return pgService.getOwnerDetailsIfAvailable(id);
  }

  // Optional: tenant registration
  // @PostMapping("/tenant/register")
  
}
