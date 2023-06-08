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
		return false;
		// CODE ENDS - Don't delete
		
	}

	@Override
	public boolean checkState(String state) throws EntryNotFoundException {
		// CODE STARTS - Don't delete
		return false;
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
	public boolean checkDate(String date) {
		// CODE STARTS - Don't delete
		return false;
		// CODE ENDS - Don't delete
		
	}

	@Override
	public Order calculateOrder(LocalDate orderDate, int orderNumber, String customerName, Tax tax, Product product,
			BigDecimal area) {
		// CODE STARTS - Don't delete
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
	public void removeOrder(Order order) {
		// CODE STARTS - Don't delete
		
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
