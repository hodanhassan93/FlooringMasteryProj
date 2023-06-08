package com.fo.presentation;
import com.fo.service.*;
import java.util.Scanner;

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
		case 1: 
			System.out.println("Which date would you like the Orders for?");
			foBusinessLogic.checkDate();
			break;
		case 2:

			break;
		case 3:

			break;
			
		case 4:	

              break;        
           
		case 5: 
			foBusinessLogic.exportData();
			System.out.println("You're data has been stored");
            break;
            
		case 6:
			System.out.println("Thanks you for your purchase, we look forward to seeing you again!");
			System.exit(0);
			
		default:
			System.out.println("Invalid Choice");
		}

	}
	
	

}
