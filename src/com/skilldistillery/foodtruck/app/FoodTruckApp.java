package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FoodTruckApp fta = new FoodTruckApp();

		FoodTruck[] trucks = new FoodTruck[5];

		trucks = fta.infoEntry(sc);

		int userChoice = 0;

		while (userChoice != 4) {
			fta.menu();
			userChoice = sc.nextInt();
			sc.nextLine();
			switch (userChoice) {
			case 1:
				fta.listTrucks(trucks);
				break;
			case 2:
				fta.averageRating(trucks);
				break;
			case 3:
				fta.highestRated(trucks);
				break;
			case 4:

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

		while (!quit && numTrucks < 5) {
			String truckName;
			System.out.println("Enter a food truck name: ");
			String name = scanner.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				quit = true;
				break;
			} else {
				truckName = name;
			}

			System.out.println("Enter the type of food served: ");
			String foodType = scanner.nextLine();
			System.out.println("Rate this truck on a scale of 1-5");
			int rating = scanner.nextInt();
			scanner.nextLine();
			FoodTruck truck = new FoodTruck(truckName, foodType, rating);

			for (int i = 0; i < trucks.length; i++) {
				if (trucks[i] == null) {
					trucks[i] = truck;
					i++;
					break;
				}
			}
			numTrucks++;
		}
		return trucks;
	}

	public void printStars() {
		System.out.println("***********************************");
		System.out.println("***********************************");
	}

	public void menu() {
		FoodTruckApp fta = new FoodTruckApp();
		fta.printStars();
		System.out.println("*** 1. List all food trucks     ***");
		System.out.println("*** 2. Show average rating      ***");
		System.out.println("*** 3. Show highest rated truck ***");
		System.out.println("*** 4. Quit                     ***");
		fta.printStars();
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
			if (foodTruck != null) {
				if (foodTruck.getRating() > highest) {
					bestTruck = foodTruck;
					highest = foodTruck.getRating();
				}
			}
		}
		System.out.println("The highest rated truck is: ");
		System.out.println(bestTruck);
	}

}
