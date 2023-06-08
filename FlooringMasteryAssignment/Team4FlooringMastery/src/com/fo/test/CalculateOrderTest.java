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
		BigDecimal taxRate = 6.00;
		BigDecimal area = 217.00;
		BigDecimal costPerSquareFoot = 2.25;
		BigDecimal laborCostPerSquareFoot = 2.10;

		Order order = calculateOrder(taxRate, area, costPerSquareFoot, laborCostPerSquareFoot);

		FoBusinessLogicImpl fobusinessLogicImpl = new FoBusinessLogicImpl();

		BigDecimal expectedResult = new BigDecimal("1000.59");
		
		assertTrue(expectedResult == order.getTotal);
	}
}
