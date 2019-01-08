package com.example.CarApp.domain;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tripid;
	private String name;


	
	 @ManyToMany(cascade = CascadeType.MERGE)
     @JoinTable(name = "car_trips", joinColumns = { @JoinColumn(name =
      "tripid") }, inverseJoinColumns = { @JoinColumn(name = "id") }) 
      private Set<Car> cars;
	
	public Trip() {

	}

	public Trip(String name) {
		super();
		this.name = name;
	}
	
	public Trip(String name,Set<Car> cars) {
		super();
		this.name = name;
		this.setCars(cars);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public long getTripid() {
		return tripid;
	}

	public void setTripid(long tripid) {
		this.tripid = tripid;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
}