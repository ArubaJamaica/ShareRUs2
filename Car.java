package Model;

import java.util.Scanner;

public class Car {
	private int id, seats, owner;
	private String name, description, brand, type, location, transmission;
	private double rate;
	private static int counter;

	
	public Car() {
		id = setId();
		name = setName();
		seats = setSeats();
		brand = setBrand();
		description = setDescription();
		type = setType();
		location = setLocation();
		transmission = setTransmission();
		rate = setRate();
		owner = setOwner();
	}

	public Car(int newId, int newOwner, String newName, String newType, String newBrand, String newTransmission, int newSeats,
			double newRate, String newDescription, String newLocation) {
		id = newId;
		owner = newOwner;
		name = newName;
		type = newType;
		brand = newBrand;
		transmission = newTransmission;
		seats = newSeats;
		rate = newRate;
		description = newDescription;
		location = newLocation;
		counter += 1;
	}
	
	public Car(int owner2, String name2, String type2, String brand2, String transmission2, int seats2, double rate2,
			String description2, String location2) {
		id = (++counter);
		owner = owner2;
		name = name2;
		type = type2;
		brand = brand2;
		transmission = transmission2;
		seats = seats2;
		rate = rate2;
		description = description2;
		location = location2;
	}

	public int getId() {
		return id;
	}

	public int getSeats() {
		return seats;
	}

	public int getOwner() {
		return owner;
	}

	public String getName() {
		return name;
	}

	public String getTransmission() {
		return transmission;
	}

	public String getDescription() {
		return description;
	}

	public String getBrand() {
		return brand;
	}

	public String getType() {
		return type;
	}

	public String getLocation() {
		return location;
	}

	public double getRate() {
		return rate;
	}

	public static int getCounter() {
		return counter;
	}
	
	
	
	private int setOwner() {
		return 0;
	}

	private double setRate() {
		return 0;
	}

	private String setTransmission() {
		return null;
	}

	private String setLocation() {
		return null;
	}

	private String setType() {
		return null;
	}

	private String setDescription() {
		return null;
	}

	private String setBrand() {
		return null;
	}

	private int setSeats() {
		return 0;
	}

	private String setName() {
		return null;
	}

	private int setId() {
		return 0;
	}

}
