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
import com.example.CarApp.domain.Trip;
import com.example.CarApp.domain.TripRepository;

@SpringBootApplication
public class CarAppApplication {

	@Autowired
	private CarRepository carrepository;

	@Autowired
	private OwnerRepository orepository;
	
	@Autowired
	private TripRepository trpository;

	public static void main(String[] args) {
		SpringApplication.run(CarAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Save demo data to database
			/*
			 * repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000));
			 * repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000));
			 * repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018,
			 * 39000));
			 */

			// Add owner objects and save these to db
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);
			
			// Add car object with link to owners and save these to db.
			Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
			carrepository.save(car1);
			Car car2 = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
			carrepository.save(car2);
			Car car3 = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
			carrepository.save(car3);
			
			Car car4 = new Car("anan", "anan", "anan", "KKO-0212", 2018, 39000, owner2);
			carrepository.save(car4);
			
			Set<Car> cars = new HashSet<Car>();
			cars.add(car1);
			cars.add(car2);
			
			Trip trip1 = new Trip("italy",cars);
			trpository.save(trip1);
			Trip trip2 = new Trip("brazil",cars);
			trpository.save(trip2);
			
	
		};
	}
}
