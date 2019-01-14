package com.example.CarApp.domain;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;


public interface TripRepository extends CrudRepository<Trip, Integer> {
	@Query(nativeQuery = true)
	ArrayList<OwnersInTrip> getOwnersInTrip(@Param("tripId") long tripId);

}
