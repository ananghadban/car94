package com.example.CarApp.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.CarApp.domain.OwnersInTrip;
import com.example.CarApp.domain.TripRepository;

@RestController
public class TripController {
	@Autowired
	private TripRepository repository;

	  @RequestMapping("/ownersintrip/{id}")
	  public ArrayList<OwnersInTrip> getOwnersInTrip(@PathVariable long id) {
	    return repository.getOwnersInTrip(id);
	  }
}

