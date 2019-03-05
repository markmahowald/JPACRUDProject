package com.skilldistillery.tripMVC.data;

import java.util.List;

import com.skilldistillery.tripentities.entities.Trip;


public interface TripDAO {

	List<Trip> findAll();

	Trip findById(int id);

	Trip create(Trip newTrip);

	boolean update(int id, Trip trip);

	boolean destroy(int id);

}