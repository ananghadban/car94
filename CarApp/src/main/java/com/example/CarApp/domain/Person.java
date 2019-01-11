package com.example.CarApp.domain;

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
public class Person {

	private long id;
	
	
	private Set<Trip> trips;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "person_in_trip", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "trip_id", referencedColumnName = "trip_id"))
	public Set<Trip> getTrips() {
		return trips;
	}
	
	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
	
	public Person() {
		super();
	}
	
	public Person(String name, Set<Trip> trips) {
		super();
		this.name = name;
		this.trips = trips;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private String name;

	
	
}
