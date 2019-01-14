package com.example.CarApp.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_in_trip")
public class PersonTrip implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person person;
	private Trip trip;
	private int items;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "person_id")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "trip_id")
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	@Column(name = "items")
	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}
	
}
