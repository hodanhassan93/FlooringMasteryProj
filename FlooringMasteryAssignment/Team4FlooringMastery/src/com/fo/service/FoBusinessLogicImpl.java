package com.fo.service;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import com.fo.dataaccess.*;
import com.fo.dto.Order;
import com.fo.dto.Product;
import com.fo.dto.Tax;
import com.fo.utility.EntryNotFoundException;
import com.fo.dataaccess.FoDataAccess;
import com.fo.dataaccess.FoOrderDataAccessImpl;
import com.fo.dataaccess.FoProductDataAccessImpl;
import com.fo.dataaccess.FoTaxDataAccessImpl;
import com.fo.presentation.FoUserInterfaceImpl;
import com.fo.utility.InvalidDateException;
import com.fo.utility.InvalidInputException;
import com.fo.utility.NoOrdersFoundException;

public class FoBusinessLogicImpl implements FoBusinessLogic {

	private FoOrderDataAccessImpl dataAccess;
	private FoUserInterfaceImpl ui;
	private LinkedList<Product> products;
	private LinkedList<Tax> taxes;
	private LinkedList<Order> temporaryOrderStorage;
	private LinkedList<Order> orders;
	private LocalDate orderDate;

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
	public LinkedList<Order> getAllOrdersForDate(String date) {

		String fileName = "Orders_" + date + ".txt";

		System.out.println(fileName);

		try {
			this.orders = dataAccess.readObjects(fileName);
			return this.orders;
		} catch (FileNotFoundException ex) {
			throw new FileNotFoundException("File not found.");
		} catch (Exception ex) {
		}

		return null;
	}

	@Override
	public Order createOrder(LocalDate orderDate, String customerName, String state, String productType,
			BigDecimal area) {
		Optional<Tax> optional = taxes.stream().filter((t) -> t.getStateAbbreviation().equals(state)).findFirst();
		Tax tax = optional.get();

		Optional<Product> optional2 = products.stream().filter((p) -> p.getProductType().equals(productType))
				.findFirst();
		Product product = optional2.get();

		return calculateOrder(orderDate, getHighestOrderNumber(), customerName, tax, product, area);
	}

	@Override
	public boolean checkName(String name) throws InvalidInputException {
		if (name == null || name.isEmpty()) {
			return false;
		}

		if (!name.matches("[a-zA-Z\\s,]+")) {
			throw new InvalidInputException("Invalid characters in name: " + name);
		}
		return true;
	}

	@Override
	public boolean checkStateAbbreviation(String stateAbbreviation) throws EntryNotFoundException {
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
	}

	@Override
	public boolean checkArea(String area) throws InvalidInputException {
		if (area.equals(""))
			return false;

		try {
			BigDecimal areaBigDecimal = new BigDecimal(area);

			if (areaBigDecimal.compareTo(new BigDecimal("100")) != -1)
				return true;
			else
				throw new InvalidInputException("wrong.");

		} catch (Exception ex) {
			throw new InvalidInputException("wrong.");
		}
	}

	@Override
	public boolean checkDate(String date) throws InvalidDateException {
		try {
			LocalDate parsedDate = LocalDate.parse(date);
			LocalDate currentDate = LocalDate.now();

			return parsedDate.isAfter(currentDate);
		} catch (Exception e) {
			throw new InvalidDateException("Invalid date format: " + date);
		}
	}

	private void placeOrder(Order order) {
		// Add the data to in-memory storage
		temporaryOrderStorage.add(order);
	}

	@Override
	public Order calculateOrder(LocalDate orderDate, int orderNumber, String customerName, Tax tax, Product product,
			BigDecimal area) {
		BigDecimal materialCost = (area.multiply(product.getCostPerSquareFoot()));
		BigDecimal laborCost = (area.multiply(product.getLaborCostPerSquareFoot()));
		BigDecimal taxCost = (materialCost.add(laborCost)).multiply(tax.getTaxRate().divide(new BigDecimal(100))); // division

		// Calculate the order's Total price
		BigDecimal getTotal = materialCost.add(laborCost).add(taxCost).setScale(2, RoundingMode.HALF_UP);

		return new Order(orderNumber, customerName, tax.getStateAbbreviation(), tax.getTaxRate(),
				product.getProductType(), area, product.getCostPerSquareFoot(), product.getLaborCostPerSquareFoot(),
				materialCost, laborCost, taxCost, getTotal);
	}

	@Override
	public boolean checkProductType(String productType) throws EntryNotFoundException {

		LinkedList<Product> matches = new LinkedList<Product>();

		for (Product product : products) {
			if (productType.toLowerCase().contains(product.getProductType().toLowerCase())) {
				matches.add(product);
			} else if (matches.size() == 0) {
				throw new EntryNotFoundException("No product with the inserted type exists");
			}
		}
		return true;
	}

	@Override
	public Order getOrder(String fileName, int orderNumber) throws Exception {

		this.orders = dataAccess.readObjects(fileName);

		for (Order order : orders) {
			if (order.getOrderNumber() == orderNumber) {
				return order;
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	public LinkedList<Order> editOrder(int orderNumber, Order order) {

		LinkedList<Order> newOrders = this.orders;
		int index = 0;
		for (Order anOrder : orders) {
			if (anOrder.getOrderNumber() == orderNumber) {
				index = newOrders.indexOf(anOrder);
			}
		}
		newOrders.set(index, order);
		return newOrders;
	}

	@Override
	public void removeOrder(Order order) throws NoOrdersFoundException {

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
	}

	@Override
	public void saveOrdersToAFile() {

		String fileName = "Orders_" + orderDate.format(DateTimeFormatter.ofPattern("MMDDYYYY")) + ".txt";
		try {
			dataAccess.writeObject(orders, fileName);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override // stretch goal
	public void exportData() {
		// CODE STARTS - Don't delete

		// CODE ENDS - Don't delete
	}

	private int getHighestOrderNumber() {
		FoTrackerDataAccess foTrackerDataAccess = new FoTrackerDataAccess();
		return foTrackerDataAccess.readOrderNumberTracker();
	}

}