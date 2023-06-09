package com.fo.service;

import static org.junit.jupiter.api.DynamicTest.stream;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import com.fo.dataaccess.*;

import com.fo.dto.Order;
import com.fo.dto.Product;
import com.fo.dto.Tax;
import com.fo.utility.EntryNotFoundException;

public class FoBusinessLogicImpl implements FoBusinessLogic {
	FoDataAccess foDataAccess = new FoDataAccessImpl();


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
import com.fo.utility.InvalidInputException;
import com.fo.utility.NoOrdersFoundException;

public class FoBusinessLogicImpl implements FoBusinessLogic {

	private FoOrderDataAccessImpl dataAccess;
	private FoUserInterfaceImpl ui;
	private LinkedList<Product> products;
	private LinkedList<Tax> taxes;
	private LinkedList<Order> temporaryOrderStorage;
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
			System.out
					.println("Fatal error: data files could not be found. We apologise for any inconvinience caused.");
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
		return false;
		// CODE ENDS - Don't delete

	}

	// private
	// static LinkedList<Order> getOrders();

	public LinkedList<Order> getAllOrdersForDate(LocalDate date) throws FileNotFoundException {

		String fileName = "Order_" + date + ".txt";

		File f = new File(fileName);

		if (true) {

			foDataAccess.readOrders(fileName);

			return orders;
		}

		else {

			throw new FileNotFoundException("File not found");

		}

	}

	Order createOrder(LocalDate orderDate, String customerName, String state, String productType, BigDecimal area);

	@Override
	public boolean StateAbbreviation(String stateAbbreviation) throws EntryNotFoundException {
		// CODE STARTS - Don't delete
		// I have changed the type of exception and updated the method name to include
		// "abbreviation"
		// option1:
		if (stateAbbreviation.equals(""))
			return false;

		List<String> statesAbbreviationList = new LinkedList<String>();

		for (Tax aTax : taxes) {
			statesAbbreviationList.add(aTax.getStateAbbreviation());
		}

		for (String state : statesAbbreviationList) {
			if (state.equals(stateAbbreviation)) {
				return true;
			}
		}

		throw new EntryNotFoundException("Please enter a valid state's abbreviation.");
		// CODE ENDS - Don't delete

	}

	@Override
	public boolean checkProductType(String productType) throws EntryNotFoundException {
		// CODE STARTS - Don't delete
		return false;
		// CODE ENDS - Don't delete

	}

	@Override
	public boolean checkArea(String area) throws InvalidInputException {
		// CODE STARTS - Don't delete
		return false;
		// CODE ENDS - Don't delete

	}


	@Override
	public boolean checkDate(String date) {
		// CODE STARTS - Don't delete
		return false;
		// CODE ENDS - Don't delete

	}

	// Ju
	private void placeOrder(Order order) {
		// Add the data to in-memory storage
		temporaryOrderStorage.add(order);
	}

	@Override
	public Order calculateOrder(LocalDate orderDate, int orderNumber, String customerName, Tax tax, Product product,
			BigDecimal area) {
		// CODE STARTS - Don't delete
		BigDecimal materialCost = (area.multiply(product.getCostPerSquareFoot()));
		BigDecimal laborCost = (area.multiply(product.getLaborCostPerSquareFoot()));
		BigDecimal taxCost = (materialCost.add(laborCost)).multiply(tax.getTaxRate().divide(new BigDecimal(100))); // division

		// Calculate the order's Total price
		BigDecimal getTotal = materialCost.add(laborCost).add(taxCost).setScale(2, RoundingMode.HALF_UP);

		return new Order(orderNumber, customerName, tax.getStateAbbreviation(), tax.getTaxRate(), product.getProductType(), 
				area, product.getCostPerSquareFoot(), product.getLaborCostPerSquareFoot(), materialCost, laborCost, taxCost, getTotal);
		// CODE ENDS - Don't delete

	}

	public boolean checkProductType(String productType) throws EntryNotFoundException

	{
		LinkedList<Order> matches = new LinkedList<Order>();

		for (Order order : orders) {

			if (productType.toLowerCase().contains(order.getProductType().toLowerCase())) {
				
				matches.add(order);

			}
			
			else if (matches.size() == 0) {
				
				throw new EntryNotFoundException("No product with the inserted type exists");
			}
		}
		
	

	}

	// private
	// int getOrderNumber();

	public Order getOrder(int orderNumber)
	
	{
		LinkedList<Order> matches = new LinkedList<Order>();
		
		for (Order order : orders) {

			if (order.getOrderNumber() == orderNumber) {
				
				matches.add(order);

			}
			
			else if (matches.size() == 0) {
				
				throw new EntryNotFoundException("No product with the inserted type exists");
			}
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
	public void removeOrder(Order order) throws NoOrdersFoundException {
		// CODE STARTS - Don't delete
		boolean status = false;

		for (Order currentOrder : orders) {
			if (currentOrder.getOrderNumber() == order.getOrderNumber()) {
				status = orders.remove(currentOrder);
				break;
			}
		}

		if (!status) {
			throw new NoOrdersFoundException("Order number " + order.getOrderNumber() + " not found.");
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
