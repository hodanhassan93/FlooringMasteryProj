package com.fo.client;

import java.util.Scanner;

import com.fo.presentation.FoUserInterface;
import com.fo.presentation.FoUserInterfaceImpl;

public class FlooringOrders {

	public static void main(String[] args) {
		FoUserInterface foUserInterface = new FoUserInterfaceImpl();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			foUserInterface.showMenu();
			System.out.println("What would you like to do:");
			int choice = scanner.nextInt();
			try {
				foUserInterface.performMenu(choice);
			} catch (Exception e) {
				System.out.println("Please pick an option from the menu");
			}
		}
	}

}
