package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.run();
	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		
		FoodTruck[] trucks = new FoodTruck[5];
		
		trucks = infoEntry(sc);
		
		int userChoice = 0;
		
		while (userChoice != 4) {
			menu();
			userChoice = sc.nextInt();
			sc.nextLine();
			switch (userChoice) {
			case 1:
				listTrucks(trucks);
				break;
			case 2:
				averageRating(trucks);
				break;
			case 3:
				highestRated(trucks);
				break;
			case 4:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}
		}
		sc.close();
	}

	private FoodTruck[] infoEntry(Scanner scanner) {
		FoodTruck[] trucks = new FoodTruck[5];

		boolean quit = false;
		int numTrucks = 0;

		while ( ! quit && numTrucks < 5) {
			String truckName;
			System.out.println("Enter a food truck name or type 'Quit' to stop: ");
			String name = scanner.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				quit = true;
				break;
			} else {
				truckName = name;
			}

			System.out.println("Enter the type of food served: ");
			String foodType = scanner.nextLine();
			int rating = 0;
			while (rating < 1 || rating > 5) {
				System.out.println("Rate this truck on a scale of 1-5");
				rating = scanner.nextInt();
				scanner.nextLine();
			}
			FoodTruck truck = new FoodTruck(truckName, foodType, rating);

			for (int i = 0; i < trucks.length; i++) {
				if (trucks[i] == null) {
					trucks[i] = truck;
					numTrucks++;
					break;
				}
			}
		}
		return trucks;
	}

	public void printStars() {
		System.out.println("***********************************");
		System.out.println("***********************************");
	}

	public void menu() {
		printStars();
		System.out.println("*** 1. Show all food trucks     ***");
		System.out.println("*** 2. Show average rating      ***");
		System.out.println("*** 3. Show highest rated truck ***");
		System.out.println("*** 4. Quit                     ***");
		printStars();
	}

	public void listTrucks(FoodTruck[] trucks) {
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null) {
				System.out.println(foodTruck);
			}
		}
	}

	public void averageRating(FoodTruck[] trucks) {
		int numTrucks = 0;
		double average = 0;
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null) {
				average += foodTruck.getRating();
				numTrucks++;
			}
		}
		average /= numTrucks;
		System.out.println("The average rating of all trucks is: " + average);
	}

	public void highestRated(FoodTruck[] trucks) {
		FoodTruck bestTruck = new FoodTruck();
		int highest = 0;
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null && foodTruck.getRating() > highest) {
				bestTruck = foodTruck;
				highest = foodTruck.getRating();
			}
		}
		System.out.println("The highest rated truck is: ");
		System.out.println(bestTruck);
	}
}
