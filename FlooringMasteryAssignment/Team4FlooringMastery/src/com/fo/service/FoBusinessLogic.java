package com.fo.service;

import com.fo.dto.Order;

import com.fo.dto.Product;
import com.fo.dto.Tax;

import com.fo.utility.EntryNotFoundException;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public interface FoBusinessLogic {

	// Note: The private methods should be implemented as private
	// methods within the implementing class to provide the necessary
	// internal functionality (but they should not be part of the public
	// contract defined by the interface):

	// private
	//void placeOrder(Order order);

	public List<Product> getProducts();

	public List<State> getStates();

	// private
	//static LinkedList<Order> getOrders();

	LinkedList<Order> getAllOrdersForDate(LocalDate date) throws FileNotFoundException;

	Order createOrder(LocalDate orderDate, String customerName, String state, String productType, BigDecimal area);

	public boolean checkName(String name) throws InvalidInputException;

	public boolean StateAbbreviation(String stateAbbreviation) throws InvalidInputException;

	public boolean checkProductType(String productType) throws EntryNotFoundException;

	public boolean checkArea(BigDecimal area) throws InvalidInputException;

	public boolean checkDate(LocalDate date);

	public Order calculateOrder(LocalDate orderDate, int orderNumber, String customerName, Tax tax, Product product,
			BigDecimal area);

	// private
	//int getOrderNumber();

	public Order getOrder(int orderNumber);

	public LinkedList<Order> editOrder(int orderNumber, Order order);

	public void removeOrder(Order order);

	public void saveOrdersToAFile();

	public void exportData();
	
	// Question: how about the data types (State, Product)?

}
