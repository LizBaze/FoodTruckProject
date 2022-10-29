package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private String name;
	private String foodType;
	private int rating;
	private int truckID;
	private static int truckIDGenerator = 1;

	public FoodTruck(String name, String foodType, int rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		this.truckID = truckIDGenerator;
		truckIDGenerator++;
	}
	
	public FoodTruck() {
		
	}

	public String toString() {
		String output = "Truck ID: " + this.truckID + ", Name: " + this.name + ", Food Type: " + this.foodType + ", Rating: " + this.rating ;
		return output;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getTruckID() {
		return truckID;
	}

	public void setTruckID(int truckID) {
		this.truckID = truckID;
	}
	
	

}
