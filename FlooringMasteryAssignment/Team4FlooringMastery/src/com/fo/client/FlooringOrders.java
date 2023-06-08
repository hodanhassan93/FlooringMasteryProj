package com.fo.client;

import java.util.Scanner;

import com.vm.ui.VmUserInterface;
import com.vm.ui.VmUserInterfaceImpl;

public class FlooringOrders {

	public static void main(String[] args) {
		FoUserInterface foUserInterface = new FoUserInterfaceImpl();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			foUserInterface.showMenu();
			System.out.println("What would you like to do:");
			int choice = scanner.nextDouble();
			foUserInterface.performMenu(choice);
		}
	}

}
