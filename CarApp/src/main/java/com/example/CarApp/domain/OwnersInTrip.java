package com.example.CarApp.domain;

import java.math.BigInteger;

public class OwnersInTrip {
	String ownerLastName;
	String tripName;
	BigInteger tripId;

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public BigInteger getTripId() {
		return tripId;
	}

	public void setTripId(BigInteger tripId) {
		this.tripId = tripId;
	}

	public OwnersInTrip(String ownerLastName, String tripName, BigInteger tripId) {
		super();
		this.ownerLastName = ownerLastName;
		this.tripName = tripName;
		this.tripId = tripId;
	}

	public OwnersInTrip() {
	}

}