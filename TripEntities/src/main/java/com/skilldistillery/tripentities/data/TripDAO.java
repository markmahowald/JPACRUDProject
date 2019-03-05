package com.skilldistillery.tripentities.data;

import java.util.List;

import com.skilldistillery.tripentities.entities.Trip;


public interface TripDAO {

	List<Trip> findAll();

	Trip findById(int id);

	Trip create(Trip newTrip);

	Trip update(int id, Trip trip);

	boolean destroy(int id);

}