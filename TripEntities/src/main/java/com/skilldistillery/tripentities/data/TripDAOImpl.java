package com.skilldistillery.tripentities.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.hibernate.cfg.SetSimpleValueTypeSecondPass;

import com.skilldistillery.tripentities.entities.Trip;


public class TripDAOImpl implements TripDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("trip");
	private static EntityManager em = emf.createEntityManager();

	@Override
	public List<Trip> findAll() {
		String query = "select trip from Trip trip";
		List<Trip> results = em.createQuery(query, Trip.class).getResultList();

		return results;
	}

	@Override
	public Trip findById(int id) {
		Trip t = em.find(Trip.class, id);
		return t;
	}

	@Override
	public Trip create(Trip trip) {

		em.getTransaction().begin();
		em.persist(trip);
		em.flush();
		em.getTransaction().commit();

		return trip;
	}

	@Override
	public Trip update(int id, Trip newTrip) {
		em.getTransaction().begin();
		Trip managed = em.find(Trip.class, id);
		managed.setDate(newTrip.getDate());
		managed.setMilesDriven(newTrip.getMilesDriven());
		managed.setDriver(newTrip.getDriver());
		managed.setGasAdded(newTrip.getGasAdded());
		managed.setStops(newTrip.getStops());
		managed.setPassengers(newTrip.getPassengers());
		managed.setDescription(newTrip.getDescription());
		em.flush();
		em.getTransaction().commit();
		return managed;
	}

	@Override
	public boolean destroy(int id) {
		Boolean result = false;
		em.getTransaction().begin();
		em.remove(em.find(Trip.class, id));
		em.getTransaction().commit();
		
		if(em.find(Trip.class, id)==null) {
			result = true;
		};

		return result;
	}

}