package com.fo.presentation;
import com.fo.service.*;
import java.time.LocalDate;
import java.util.Scanner;
import com.fo.utility.InvalidDateException;
import com.fo.utility.InvalidInputException;

public class FoUserInterfaceImpl implements FoUserInterface {
	private FoBusinessLogic foBusinessLogic=new FoBusinessLogicImpl();

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
	public void performMenu(int choice)throws Exception {
		Scanner scanner=new Scanner(System.in);
	switch (choice) {
	//display orders
		case 1: 
			System.out.println("Which date would you like the orders for?");
			LocalDate date = LocalDate.parse(scanner.nextLine());
			if (foBusinessLogic.checkDate(date)==true) {
				foBusinessLogic.getAllOrdersForDate(date);
			}
			else {
				throw new InvalidDateException("You have entered an invalid date");
				}
			break;
			
			//add order
		case 2:
			
			boolean test = false;
			do {
				System.out.println("Enter order date (YYYY-MM-DD)");
				LocalDate date2 = LocalDate.parse(scanner.nextLine());
				
				try {
					test = foBusinessLogic.checkDate(date2);
				} catch (InvalidDateException ex) {
					throw new InvalidDateException("Please enter a date.");
				}
				
				if (test == false)
					System.out.println("Please provide a future date.");
			}while (test == false);
			
			test = false;
			do {
				System.out.println("Enter you name");
				LocalDate date2 = LocalDate.parse(scanner.nextLine());
				
				try {
					test = foBusinessLogic.checkDate(date2);
				} catch (InvalidDateException ex) {
					throw new InvalidDateException("Please enter a date.");
				}
				
				if (test == false)
					System.out.println("Please provide a future date.");
			}while (test == false);
			
			
			
			
			
			
			
			
			
			if () {
				System.out.println("Please enter your name");
				String name = scanner.nextLine();
				if(foBusinessLogic.checkName(name)==true) {
					System.out.println("Please enter your state");
					String state = scanner.nextLine();
					if(foBusinessLogic.checkState(state)==true) {
						
					}
				}
				else {
					throw new InvalidInputException("You have entered an invalid input");	
				}
			}
			else {
				throw new InvalidDateException("You have entered an invalid date");
			}
			break;
		case 3:

			break;
			
		case 4:	

              break;        
           
		case 5: 
			foBusinessLogic.exportData();
			System.out.println("Your data has been stored");
            break;
            
		case 6:
			System.out.println("Thanks you for your purchase, we look forward to seeing you again!");
			System.exit(0);
			
		default:
			System.out.println("Invalid Choice");
		}

	}
	
	

}
