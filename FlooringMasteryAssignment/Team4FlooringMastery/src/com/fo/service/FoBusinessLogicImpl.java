package com.fo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
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

	@Override
	public boolean checkName(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkDate(String futureDateString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean CalculateOrder(BigDecimal taxRate, BigDecimal area, BigDecimal costPerSquareFoot,
			BigDecimal laborCostPerSquareFoot) {
//	BigDecimal materialCost = (area.multiply(costPerSquareFoot));
//	BigDecimal laborCost = (area.multiply(laborCostPerSquareFoot));
//	BigDecimal tax = (materialCost.add(laborCost)).multiply(taxRate.divide(new BigDecimal(100)));																	// division
//
//	// Calculate the order's Total price
//	BigDecimal getTotal = materialCost.add(laborCost).add(tax);
		// TODO Auto-generated method stub
		return false;
	}

	private LinkedList<Order> orders;

	public List<Product> getProducts();

	public List<State> getStates();

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

	public boolean checkState(String state) throws EntryNotFoundException;

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

	public boolean checkArea(BigDecimal area) throws InvalidInputException;

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
		
	
		
		
	}

	public LinkedList<Order> editOrder(int orderNumber, Order order);

	public void removeOrder(Order order);

	public void saveOrdersToAFile();

	public void exportData();

	@Override
	public boolean checkDate(LocalDate date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order calculateOrder(LocalDate orderDate, int orderNumber, String customerName, Tax tax, Product product,
			BigDecimal area) {
		// TODO Auto-generated method stub
		return null;
	}
}
