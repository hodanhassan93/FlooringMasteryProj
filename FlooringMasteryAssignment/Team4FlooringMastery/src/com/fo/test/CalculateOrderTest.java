package com.fo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculateOrderTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test // CalculateOrder01
	void CalculateOrder() {
		// Example used: 3,Albert
		// Einstein,KY,6.00,Carpet,217.00,2.25,2.10,488.25,455.70,56.64,1000.59
		String orderNumber = "3";
		String customerName = "Albert Einstein";
		String stateCode = "KY";
		BigDecimal taxRate = 6.00;
		String productType = "Carpet";
		BigDecimal area = 217.00;
		BigDecimal costPerSquareFoot = 2.25;
		BigDecimal laborCostPerSquareFoot = 2.10;

		LinkedList<Order> result = calculateOrder(orderNumber, customerName, stateCode, orderNumber, taxRate,
				productType, area, costPerSquareFoot, laborCostPerSquareFoot);

		// Check the size of the list
		assertEquals(1, result.size()); 

		// Get the third order from the list
		Order order = result.get(2); 

		BigDecimal materialCost = (area.multiply(costPerSquareFoot));
		BigDecimal laborCost = (area.multiply(laborCostPerSquareFoot));
		BigDecimal tax = (materialCost.add(laborCost)).multiply(taxRate.divide(new BigDecimal(100)));																	// division

		// Calculate the orderTotal
		BigDecimal orderTotal = materialCost.add(laborCost).add(tax); 

		assertEquals(new BigDecimal("1000.59"), orderTotal);
	}

}
