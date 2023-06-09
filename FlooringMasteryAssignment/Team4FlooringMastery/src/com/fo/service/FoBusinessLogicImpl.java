package com.fo.service;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import com.sujata.employee.dto.Employee;
import com.sujata.employee.exception.EmployeeIdNotFoundException;

public class FoBusinessLogicImpl implements FoBusinessLogic {

	}
	private FoDataAccess foDataAccess = new FoDataAccessImpl();

	// Ju
	private List<String> statesAbbreviationList() {
		return new ArrayList<>(Arrays.asList("TX", "WA", "KY", "CA"));
	}

	// Ju - need it for placeOrder
	private List<TemporaryOrder> temporaryOrderStorage = new ArrayList<>();

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
		}
	}

	@Override
	public boolean checkName(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkDate(String futureDateString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override // Ju
	public boolean calculateOrder(BigDecimal taxRate, BigDecimal area, BigDecimal costPerSquareFoot,
			BigDecimal laborCostPerSquareFoot) {

		BigDecimal materialCost = (area.multiply(costPerSquareFoot));
		BigDecimal laborCost = (area.multiply(laborCostPerSquareFoot));
		BigDecimal tax = (materialCost.add(laborCost)).multiply(taxRate.divide(new BigDecimal(100))); // division

		// Calculate the order's Total price
		BigDecimal getTotal = materialCost.add(laborCost).add(tax);

		return true;
	}

	public List<Product> getProducts();

	public List<State> getStates();

	// private
	// static LinkedList<Order> getOrders();

	LinkedList<Order> getAllOrdersForDate(LocalDate date) throws FileNotFoundException;

	Order createOrder(LocalDate orderDate, String customerName, String state, String productType, BigDecimal area);

	@Override // Ju
	// I have changed the type of exception and updated the method name to include
	// "abbreviation"
	// option1:
	public boolean checkStateAbbreviation(String stateAbbreviation) throws InvalidInputException {
		List<String> states = statesAbbreviationList();

		for (String state : states) {
			if (state.equals(stateAbbreviation)) {
				return true;
			}

		}
		throw new InvalidInputException("Please enter a valid state's abbreviation (TX, WA, KY, or CA).");
	}

	// option2: hardcoded, no need for List<String> states.
	public boolean checkStateAbbreviation(String stateAbbreviation) throws InvalidInputException {
		try {
			if (state.equals("TX") || state.equals("WA") || state.equals("KY") || state.equals("CA")) {
		        return true;
		} catch (InvalidInputException ex) {
			throw new InvalidInputException("Please enter a valid state's abbreviation (TX, WA, KY, or CA).");
		}
	}

	public boolean checkProductType(String productType) throws EntryNotFoundException;

	public boolean checkArea(BigDecimal area) throws InvalidInputException;

	// private
	// int getOrderNumber();

	public Order getOrder(int orderNumber);

	public LinkedList<Order> editOrder(int orderNumber, Order order);

	@Override // Ju
	public void removeOrder(Order order) throws NoOrderFoundException {
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
	}

	public void saveOrdersToAFile();

	public void exportData();
}
