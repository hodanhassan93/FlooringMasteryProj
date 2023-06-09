package com.fo.service;

import com.fo.dto.Order;
import com.fo.dto.Product;
import com.fo.dto.Tax;
import com.fo.utility.EntryNotFoundException;
import com.fo.utility.InvalidDateException;
import com.fo.utility.InvalidInputException;
import com.fo.utility.NoOrdersFoundException;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;

public interface FoBusinessLogic {

	public LinkedList<Order> getAllOrdersForDate(LocalDate date) throws FileNotFoundException;
	public Order createOrder(LocalDate orderDate, String customerName, String state, String productType, BigDecimal area);
	public boolean checkName(String name) throws InvalidInputException;
	public boolean StateAbbreviation(String stateAbbreviation) throws EntryNotFoundException;
	public boolean checkProductType(String productType) throws EntryNotFoundException;
	public boolean checkArea(String area) throws InvalidInputException;
	public boolean checkDate(String date) throws InvalidDateException;
	public Order calculateOrder(LocalDate orderDate, int orderNumber, String customerName, Tax tax, Product product, BigDecimal area);
	public Order getOrder(int orderNumber);
	public LinkedList<Order> editOrder(int orderNumber, Order order);
	public void removeOrder(Order order) throws NoOrdersFoundException;
	public void saveOrdersToAFile();
	public void exportData();
	
//	public LinkedList<Product> getProducts();
//	public LinkedList<Tax> getStates();
	
	// Note: The private methods should be implemented as private
	// methods within the implementing class to provide the necessary
	// internal functionality (but they should not be part of the public
	// contract defined by the interface):

	// private
	//void placeOrder(Order order);
	
	// private
	//static LinkedList<Order> getOrders();

	// private
	//int getOrderNumber();
	
	// Question: how about the data types (State, Product)?

}
