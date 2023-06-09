package com.fo.service;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


import com.fo.dataaccess.FoDataAccess;
import com.fo.dataaccess.FoOrderDataAccessImpl;
import com.fo.dataaccess.FoProductDataAccessImpl;
import com.fo.dataaccess.FoTaxDataAccessImpl;
import com.fo.dto.Order;
import com.fo.dto.Product;
import com.fo.dto.Tax;
import com.fo.presentation.FoUserInterface;
import com.fo.presentation.FoUserInterfaceImpl;
import com.fo.utility.EntryNotFoundException;
import com.fo.utility.InvalidDateException;
import com.fo.utility.InvalidInputException;

public class FoBusinessLogicImpl implements FoBusinessLogic {

	private FoOrderDataAccessImpl dataAccess;
	private FoUserInterfaceImpl ui;
	private LinkedList<Product> products;
	private LinkedList<Tax> taxes;
	
	private static LinkedList<Order> orders;
	
	public FoBusinessLogicImpl() {
		this.dataAccess = new FoOrderDataAccessImpl();
		FoDataAccess taxDataAccess = new FoTaxDataAccessImpl();
		FoDataAccess productDataAccess = new FoProductDataAccessImpl();
		this.ui = new FoUserInterfaceImpl();
		
		try {
			taxes = taxDataAccess.readObjects("Taxes.txt");
			products = productDataAccess.readObjects("Products.txt");
		} catch (FileNotFoundException ex) {
			System.out.println("Fatal error: data files could not be found. We apologise for any inconvinience caused.");
			System.exit(0);
		} catch (Exception ex) {
			System.out.println("Fatal error: unhandled error occured. We apologise for any inconvinience caused.");
			System.exit(0);
		}
	}

	@Override
	public LinkedList<Order> getAllOrdersForDate(LocalDate date) throws FileNotFoundException {
		// CODE STARTS - Don't delete
		return null;
		// CODE ENDS - Don't delete
		
	}


	@Override
	public Order createOrder(LocalDate orderDate, String customerName, String state, String productType,
			BigDecimal area) {
		// CODE STARTS - Don't delete
		return null;
		// CODE ENDS - Don't delete
		
	}

	@Override
	public boolean checkName(String name) throws InvalidInputException {
		// CODE STARTS - Don't delete
		if (name == null || name.isEmpty()) {
            return false;
        }

        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new InvalidInputException("Invalid characters in name: " + name);
        }

        return true;
    
		// CODE ENDS - Don't delete
		
	}

	@Override
	public boolean checkStateAbbreviation(String stateAbbreviation) throws EntryNotFoundException {
		// CODE STARTS - Don't delete
	// I have changed the type of exception and updated the method name to include
	// "abbreviation"
	// option1:
		List<String> states = statesAbbreviationList();

		for (String state : states) {
			if (state.equals(stateAbbreviation)) {
				return true;
			}

		}
		throw new EntryNotFoundException("Please enter a valid state's abbreviation (TX, WA, KY, or CA).");
	
		// CODE ENDS - Don't delete
		
	}

	@Override
	public boolean checkProductType(String productType) throws EntryNotFoundException {
		// CODE STARTS - Don't delete
		return false;
		// CODE ENDS - Don't delete
		
	}


	@Override
	public boolean checkArea(BigDecimal area) throws InvalidInputException {
		// CODE STARTS - Don't delete
		return false;
		// CODE ENDS - Don't delete
		
	}

	@Override
	public boolean checkDate(String date) throws InvalidDateException{
		// CODE STARTS - Don't delete
        try {
            LocalDate parsedDate = LocalDate.parse(date);
            LocalDate currentDate = LocalDate.now();

            return parsedDate.isAfter(currentDate);
        } catch (Exception e) {
            throw new InvalidDateException("Invalid date format: " + date);
        }
    
		// CODE ENDS - Don't delete
		
	}
	// Ju
	private void placeOrder(Order order) {
		// Show order summary
//	    System.out.println("Order Summary:");
//	    System.out.println("Order Date: " + order.getOrderDate());
//	    System.out.println("Customer Name: " + order.getCustomerName());
//	    System.out.println("State: " + order.getStateAbbreviation());
//	    System.out.println("Product Type: " + order.getProductType());
//	    System.out.println("Area: " + order.getArea());
//	    System.out.println("Tax: " + tax);
//	    System.out.println("Total Price: " + totalPrice);
		System.out.print("Place the order? (Y/N): ");
		String placeOrder = scanner.nextLine();
		if (placeOrder.equalsIgnoreCase("Y")) {
			// Add the data to in-memory storage

			temporaryOrderStorage.add(order);

			System.out.println("Order placed successfully!");
		} else {
			System.out.println("Order not placed. Returning to the main menu.");
      
      
	@Override
	public Order calculateOrder(LocalDate orderDate, int orderNumber, String customerName, Tax tax, Product product,
			BigDecimal area) {
		// CODE STARTS - Don't delete
			BigDecimal materialCost = (area.multiply(costPerSquareFoot));
		BigDecimal laborCost = (area.multiply(laborCostPerSquareFoot));
		BigDecimal tax = (materialCost.add(laborCost)).multiply(taxRate.divide(new BigDecimal(100))); // division

		// Calculate the order's Total price
		BigDecimal getTotal = materialCost.add(laborCost).add(tax);

		return null;
		// CODE ENDS - Don't delete
		
	}

	@Override
	public Order getOrder(int orderNumber) {
		// CODE STARTS - Don't delete
		return null;
		// CODE ENDS - Don't delete
		
	}


	@Override
	public LinkedList<Order> editOrder(int orderNumber, Order order) {
		// CODE STARTS - Don't delete
		return null;
		// CODE ENDS - Don't delete
		
	}

	@Override
	public void removeOrder(Order order) throws NoOrderFoundException {
    // CODE STARTS - Don't delete
		boolean status = false;

		for (Order currentOrder : orderList) {
			if (currentOrder.getOrderNumber() == order.getOrderNumber()) {
				status = orderList.remove(currentOrder);
				break;
			}
		}

		if (!status) {
			throw new NoOrderFoundException("Order number " + order.getOrderNumber() + " not found");
		}
		// CODE ENDS - Don't delete

	}

  
	@Override
	public void saveOrdersToAFile() {
		// CODE STARTS - Don't delete
		
		// CODE ENDS - Don't delete

	}

	@Override
	public void exportData() {
		// CODE STARTS - Don't delete
		
		// CODE ENDS - Don't delete
	}

	/*
	 * =============================================================================
	 * =============
	 * 
	 * @Override public boolean checkName(String string) { // TODO Auto-generated
	 * method stub return false; }
	 * 
	 * public boolean checkDate(String futureDateString) { // TODO Auto-generated
	 * method stub return false; }
	 * 
	 * @Override public boolean CalculateOrder(BigDecimal taxRate, BigDecimal area,
	 * BigDecimal costPerSquareFoot, BigDecimal laborCostPerSquareFoot) { //
	 * BigDecimal materialCost = (area.multiply(costPerSquareFoot)); // BigDecimal
	 * laborCost = (area.multiply(laborCostPerSquareFoot)); // BigDecimal tax =
	 * (materialCost.add(laborCost)).multiply(taxRate.divide(new BigDecimal(100)));
	 * // division // // // Calculate the order's Total price // BigDecimal getTotal
	 * = materialCost.add(laborCost).add(tax); // TODO Auto-generated method stub
	 * return false; }
	 * =============================================================================
	 * ============
	 */
}
