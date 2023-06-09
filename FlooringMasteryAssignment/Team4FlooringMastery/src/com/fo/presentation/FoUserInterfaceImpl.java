package com.fo.presentation;

import com.fo.dto.Order;
import com.fo.service.*;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

import com.fo.utility.EntryNotFoundException;
import com.fo.utility.InvalidDateException;
import com.fo.utility.InvalidInputException;

public class FoUserInterfaceImpl implements FoUserInterface {
	private FoBusinessLogic foBusinessLogic;

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
	public void performMenu(String choice){
		foBusinessLogic = new FoBusinessLogicImpl();
		Scanner scanner = new Scanner(System.in);
		switch (choice) {

		// 1 - DISPLAY ORDERS
			case "1":
				System.out.println("Which date would you like the orders for? (YYYY-MM-DD)");
				String dateString = scanner.nextLine();
				
				try {
					if (foBusinessLogic.checkDate(dateString) == true) {
						DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
						 LocalDate date = LocalDate.parse(dateString);
						 String formattedDate = date.format(dateTimeFormatter);
						
						foBusinessLogic.getAllOrdersForDate(formattedDate);
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
				String date;
				do {
					System.out.println("Enter order date (YYYY-MM-DD):");
					date = scanner.nextLine();
	
					try {
						test = foBusinessLogic.checkDate(date);
					} catch (InvalidDateException ex) {
						System.out.println("Invalid date format. Please enter date as YYYY-MM-DD.\n");
					}
	
					if (test == false)
						System.out.println("Please provide a future date.\n");
				} while (test == false);
	
				test = false;
				String name;
				do {
					System.out.println("Enter your name:");
					name = scanner.nextLine();
	
					try {
						test = foBusinessLogic.checkName(name);
					} catch (InvalidInputException ex) {
						System.out.println("Invalid input. Name can only contain numbers, letters, commas and periods.\n");
					}
	
					if (test == false)
						System.out.println("Name cannot be blank.\n");
				} while (test == false);
				
				test = false;
				String state;
				do {
					System.out.println("Enter state abbreviation:");
					state = scanner.nextLine();
	
					try {
						test = foBusinessLogic.StateAbbreviation(state);
					} catch (EntryNotFoundException ex) {
						System.out.println("The state you entered is invalid.\n");
					}
	
					if (test == false)
						System.out.println("State cannot be blank.\n");
				} while (test == false);
				
				test = false;
				String product;
				do {
					// show list of products
					System.out.println("Enter product name:");
					product = scanner.nextLine();
	
					try {
						test = foBusinessLogic.checkProductType(product);
					} catch (EntryNotFoundException ex) {
						System.out.println("Invalid input. Please choose one of the options above.\n");
					}
	
					if (test == false)
						System.out.println("Product name cannot be blank. Please choose one of the options above.\n");
				} while (test == false);
				
				test = false;
				String area;
				do {
					System.out.println("Enter the area of flooring you desire:");
					area = scanner.nextLine();
	
					try {
						test = foBusinessLogic.checkArea(area);
					} catch (InvalidInputException ex) {
						System.out.println("Invalid input. Area must be a positive integer larger than 100.\n");
					}
	
					if (test == false)
						System.out.println("Area cannot be blank.\n");
				} while (test == false);
				
				Order order = foBusinessLogic.createOrder(LocalDate.parse(date), name, state, product, new BigDecimal(area));
				
				System.out.println("\nHere is your order summary:");

			    System.out.println("Order Date: " + LocalDate.parse(date));
			    System.out.println("Customer Name: " + order.getCustomerName());
			    System.out.println("State: " + order.getState());
			    System.out.println("Product Type: " + order.getProductType());
			    System.out.println("Area: " + order.getArea());
			    System.out.println("Material cost: " + order.getMaterialCost());
			    System.out.println("Labor cost: " + order.getLaborCost());
			    System.out.println("Tax: " + order.getTax());
			    System.out.println("Total Price: " + order.getTotal());
				System.out.println("Place the order? (Y/N):");
				String placeOrder = scanner.nextLine();
				
				if (placeOrder.equalsIgnoreCase("Y")) {
			  			System.out.println("Order placed successfully!");
					} else {
						System.out.println("Order not placed. Returning to the main menu.");
					}
				
				break;

		// 3 - EDIT EXISTING ORDER
			case "3":
				int year, month, day;
				
				System.out.println("Enter Year");
				year = scanner.nextInt();
				System.out.println("Enter Month");
				month = scanner.nextInt();
				System.out.println("Enter day");
				day = scanner.nextInt();
				LocalDate date = LocalDate.of(year, month, day);
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
				String formattedDate = date.format(dateTimeFormatter);
				LinkedList<Order> result = foBusinessLogic.getAllOrdersForDate(formattedDate);
				System.out.println(result);
		        String fileName = "Orders_"+formattedDate+".txt";
		        System.out.println("Enter order Number");
		        int orderNumber = scanner.nextInt();
		        
				Order retrievedorder = foBusinessLogic.getOrder(fileName, orderNumber);
				
		        
				if (retrievedorder == null) {
					
					System.out.println("No order has been found");
				}
				
				else {
					
					System.out.println(retrievedorder.toString());
				}
				
		
				
	
				break;

		// 4 - REMOVE ORDER - Ju
			case "4":
				System.out.println("Enter order date (YYYY-MM-DD):");
				String dateToCheck = scanner.nextLine();
				
				try {
					if (foBusinessLogic.checkDate(dateToCheck) == true) {
						System.out.println("Enter the order number that you want to remove:");
						int orderToCheck = scanner.nextInt();
						
						if (foBusinessLogic.getOrder(orderToCheck) == null ) {
							System.out.println("You have entered an invalid order number");
							
						}
						else {
							//Order orderToRemove = foBusinessLogic.getOrder(fileName, orderToCheck);
							foBusinessLogic.removeOrder(order);
							System.out.println("Order successfully removed.");
						}
					}
					
					else {
						System.out.println("You have entered an invalid date");
					}
				}catch(InvalidDateException ex1)
				{
					System.out.println("Invalid date format. Please enter date as YYYY-MM-DD.");
				}catch(
				FileNotFoundException ex2)
				{
				System.out.println("No orders found for the given date.");
				}

				break;

		// 5 - SAVE ORDER TO A FILE
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

/*
 * Switch case - option 2
 * 
 * // Show order summary // System.out.println("Order Summary:"); //
 * System.out.println("Order Date: " + order.getOrderDate()); //
 * System.out.println("Customer Name: " + order.getCustomerName()); //
 * System.out.println("State: " + order.getStateAbbreviation()); //
 * System.out.println("Product Type: " + order.getProductType()); //
 * System.out.println("Area: " + order.getArea()); // System.out.println("Tax: "
 * + tax); // System.out.println("Total Price: " + totalPrice); //
 * System.out.print("Place the order? (Y/N): "); // String placeOrder =
 * scanner.nextLine(); // // if (placeOrder.equalsIgnoreCase("Y")) { //
 * System.out.println("Order placed successfully!"); // } else { //
 * System.out.println("Order not placed. Returning to the main menu."); // }
 * 
 */
}
