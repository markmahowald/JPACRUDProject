package com.skilldistillery.tripentities.entites.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.tripentities.entities.Trip;

class TripTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Trip trip;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("trip");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		trip = em.find(Trip.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		trip = null;
		em.close();
	}

	@Test
	void test() {
		assertEquals(1, trip.getId());
		assertEquals("2019-03-03", trip.getDate());
		assertEquals(25, trip.getMilesDriven());
		assertEquals("mark", trip.getDriver());
		assertEquals(2, trip.getStops());
		assertEquals(1, trip.getPassengers());
		assertEquals("crusing around", trip.getDescription());
		assertTrue(trip.getGasAdded().equals(1.5));
		
	}

}