package com.fo.client;

import java.io.FileNotFoundException;
import java.util.Scanner;
import com.fo.presentation.FoUserInterface;
import com.fo.presentation.FoUserInterfaceImpl;
import com.fo.utility.NoOrdersFoundException;

public class FlooringOrders {

	public static void main(String[] args) {
		FoUserInterface foUserInterface = new FoUserInterfaceImpl();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			foUserInterface.showMenu();
			System.out.println("What would you like to do:");
			String choice = scanner.nextLine();
			try {
				foUserInterface.performMenu(choice);
			} catch (NoOrdersFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
