package com.fo.presentation;

import com.fo.service.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;
import com.fo.utility.InvalidDateException;
import com.fo.utility.InvalidInputException;

public class FoUserInterfaceImpl implements FoUserInterface {
	private FoBusinessLogic foBusinessLogic = new FoBusinessLogicImpl();

	@Override
	public void showMenu() {
		System.out.println("1. Display Orders");
		System.out.println("2. Add an Order");
		System.out.println("3. Edit an Order");
		System.out.println("4. Remove an Order");
		System.out.println("5. Export All data");
		System.out.println("6. Quit");

	}

	@Override
	public void performMenu(String choice) {
		Scanner scanner = new Scanner(System.in);

		switch (choice) {

		// 1 - DISPLAY ORDERS
			case "1":
				System.out.println("Which date would you like the orders for? (YYYY-MM-DD)");
				String dateString = scanner.nextLine();
				
				try {
					if (foBusinessLogic.checkDate(dateString) == true) {
						LocalDate date = LocalDate.parse(dateString);
						foBusinessLogic.getAllOrdersForDate(date);
					} else {
						System.out.println("You have entered an invalid date");
					}
				} catch (InvalidDateException ex) {
					System.out.println("Invalid date format. Please enter date as YYYY-MM-DD.");
				} catch (FileNotFoundException ex) {
					System.out.println("No orders found for the given date.");
				}
				
				break;

		// 2 - ADD ORDER
			case "2":
	
				boolean test = false;
				do {
					System.out.println("Enter order date (YYYY-MM-DD):");
					String date = scanner.nextLine();
	
					try {
						test = foBusinessLogic.checkDate(date);
					} catch (InvalidDateException ex) {
						System.out.println("Invalid date format. Please enter date as YYYY-MM-DD.");
					}
	
					if (test == false)
						System.out.println("Please provide a future date.");
				} while (test == false);
	
				test = false;
				do {
					System.out.println("Enter you name");
					String date2 = scanner.nextLine();
	
					try {
						test = foBusinessLogic.checkDate(date2);
					} catch (InvalidDateException ex) {
						System.out.println("Please enter a date.");
					}
	
					if (test == false)
						System.out.println("Please provide a future date.");
				} while (test == false);
	
	//			if () {
	//				System.out.println("Please enter your name");
	//				String name = scanner.nextLine();
	//				if(foBusinessLogic.checkName(name)==true) {
	//					System.out.println("Please enter your state");
	//					String state = scanner.nextLine();
	//					if(foBusinessLogic.checkState(state)==true) {
	//						
	//					}
	//				}
	//				else {
	//					throw new InvalidInputException("You have entered an invalid input");	
	//				}
	//			}
	//			else {
	//				throw new InvalidDateException("You have entered an invalid date");
	//			}
				break;

		// 3 - EDIT EXISTING ORDER
			case "3":
	
				break;

		// 4 - REMOVE ORDER
			case "4":
	
				break;

		// 5 - EXPORT ORDERS
			case "5":
				foBusinessLogic.exportData();
				System.out.println("Your data has been stored");
				break;

		// 6 - QUIT APPLICATION
			case "6":
				System.out.println("Thanks you for your purchase, we look forward to seeing you again!");
				System.exit(0);
				
		// INVALID choice
			default:
				System.out.println("Invalid Choice. Please pick a menu item.");
		}
	}

}
