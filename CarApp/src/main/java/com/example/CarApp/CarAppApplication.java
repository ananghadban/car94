package com.example.CarApp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.CarApp.domain.Car;
import com.example.CarApp.domain.CarRepository;
import com.example.CarApp.domain.Owner;
import com.example.CarApp.domain.OwnerRepository;
import com.example.CarApp.domain.Person;
import com.example.CarApp.domain.PersonRepository;
import com.example.CarApp.domain.Trip;
import com.example.CarApp.domain.TripRepository;

@SpringBootApplication
public class CarAppApplication {

	@Autowired
	private CarRepository carrepository;

	@Autowired
	private OwnerRepository orepository;
	
	@Autowired
	private TripRepository trepository;
	
	@Autowired
	private PersonRepository prrepository;

	public static void main(String[] args) {
		SpringApplication.run(CarAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Save demo data to database
			// Add owner objects and save these to db
	          Owner owner1 = new Owner("John" , "Johnson");
	          Owner owner2 = new Owner("Mary" , "Robinson");
	          orepository.save(owner1);
	          orepository.save(owner2);
	          
	          //Add trip objects
	          Trip trip1 = new Trip("Trip A");
	          Trip trip2 = new Trip("Trip B");
	          trepository.save(trip1);
	          trepository.save(trip2);

	          // Add car object with link to owners and save these to db.
	          
	          Set<Trip> trips1= new HashSet<Trip>();
	          trips1.add(trip1);
	          trips1.add(trip2);
	          
	          Set<Trip> trips2= new HashSet<Trip>();
	          trips2.add(trip1);
	          
	          Set<Trip> trips3= new HashSet<Trip>();
	          trips3.add(trip2);
	          
	          Car car = new Car("Ford", "Mustang", "Red", 
	              "ADF-1121", 2017, 59000, owner1,trips1);
	          carrepository.save(car);
	          car = new Car("Nissan", "Leaf", "White",
	              "SSJ-3002", 2014, 29000, owner2,trips2);
	          carrepository.save(car);
	          car = new Car("Toyota", "Prius", "Silver",
	              "KKO-0212", 2018, 39000, owner2, trips3);
	          carrepository.save(car);
	          
	          Person person = new Person("anan",trips1);
	          prrepository.save(person);
	          person = new Person("john",trips2);
	          prrepository.save(person);
			
		};
	}
}
