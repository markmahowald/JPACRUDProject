package com.skilldistillery.tripentities.client;

import com.skilldistillery.tripentities.data.TripDAOImpl;
import com.skilldistillery.tripentities.entities.Trip;

public class TripDAOClient {
	public static void main(String[] args) {
		
	TripDAOImpl dao = new TripDAOImpl();
	
	Trip trip = new Trip();
	System.out.println(trip.toString());
	
//	test db read
	Trip t = dao.findById(1);
	System.out.println(t);
	System.out.println();
	
//	test db entry creation
	trip = dao.create(trip);
	System.out.println(trip.toString());
	System.out.println();
	
//	test DB update
	trip.setDate("2006-6-6");
	trip.setDescription("test test test test ");
	trip.setDriver("tom");
	trip.setGasAdded(8.9);
	trip.setMilesDriven(99);
	trip.setPassengers(7);
	trip.setStops(99);
	System.out.println(trip);
	trip = dao.update(trip.getId(), trip);
	System.out.println(trip);
	
//	test destroy
	
	Boolean test = dao.destroy(trip.getId());
	System.out.println(test);
	
	}


}