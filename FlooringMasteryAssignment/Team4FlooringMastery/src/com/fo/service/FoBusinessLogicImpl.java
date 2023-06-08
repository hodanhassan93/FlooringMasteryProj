package com.fo.service;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class FoBusinessLogicImpl implements FoBusinessLogic{
	private FoDataAccess foDataAccess=new FoDataAccessImpl();

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
	public boolean CalculateOrder(BigDecimal taxRate, BigDecimal area, BigDecimal costPerSquareFoot, BigDecimal laborCostPerSquareFoot) {
//	BigDecimal materialCost = (area.multiply(costPerSquareFoot));
//	BigDecimal laborCost = (area.multiply(laborCostPerSquareFoot));
//	BigDecimal tax = (materialCost.add(laborCost)).multiply(taxRate.divide(new BigDecimal(100)));																	// division
//
//	// Calculate the order's Total price
//	BigDecimal getTotal = materialCost.add(laborCost).add(tax);
		// TODO Auto-generated method stub
				return false;
	}
	
	public List<Product> getProducts();

	public List<State> getStates();

	// private
	//static LinkedList<Order> getOrders();

	LinkedList<Order> getAllOrdersForDate(LocalDate date) throws FileNotFoundException;

	Order createOrder(LocalDate orderDate, String customerName, String state, String productType, BigDecimal area);


	public boolean checkState(String state) throws EntryNotFoundException;

	public boolean checkProductType(String productType) throws EntryNotFoundException;

	public boolean checkArea(BigDecimal area) throws InvalidInputException;


	// private
	//int getOrderNumber();

	public Order getOrder(int orderNumber);

	public LinkedList<Order> editOrder(int orderNumber, Order order);

	public void removeOrder(Order order);

	public void saveOrdersToAFile();

	public void exportData();
}

