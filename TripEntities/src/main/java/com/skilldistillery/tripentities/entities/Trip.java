package com.skilldistillery.tripentities.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	@Column(name="date")
	private String date;
	@Column(name="miles")
	private int milesDriven;
	@Column(name="driver")
	private String driver;
	@Column(name="gas_added")
	private Double gasAdded;
	@Column(name="stops")
	private int stops;
	@Column(name="passengers")
	private int passengers;
	@Column(name="description")
	private String description;

	
	@Override
	public String toString() {
		return "Trip [id=" + id + ", date=" + date + ", milesDriven=" + milesDriven + ", driver=" + driver
				+ ", gasAdded=" + gasAdded + ", stops=" + stops + ", passengers=" + passengers + ", description="
				+ description + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getMilesDriven() {
		return milesDriven;
	}
	public void setMilesDriven(int milesDriven) {
		this.milesDriven = milesDriven;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public Double getGasAdded() {
		return gasAdded;
	}
	public void setGasAdded(Double gasAdded) {
		this.gasAdded = gasAdded;
	}
	public int getStops() {
		return stops;
	}
	public void setStops(int stops) {
		this.stops = stops;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Trip( String date, int milesDriven, String driver, Double gasAdded, int stops, int passengers,
			String description) {
		super();
		this.id = 0;
		this.date = date;
		this.milesDriven = milesDriven;
		this.driver = driver;
		this.gasAdded = gasAdded;
		this.stops = stops;
		this.passengers = passengers;
		this.description = description;
	}
	public Trip() {
		
		this("1-1-1", 0, "", 0.0, 0, 0, "");
	}
	
}