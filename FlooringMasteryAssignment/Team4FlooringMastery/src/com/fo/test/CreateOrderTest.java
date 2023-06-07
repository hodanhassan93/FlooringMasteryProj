package com.fo.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fo.dto.Order;
import com.fo.dto.Product;
import com.fo.dto.Tax;
import com.fo.service.FoBusinessLogicImpl;

class CreateOrderTest {
	FoBusinessLogicImpl service;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		service = new FoBusinessLogicImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		service = null;
	}

	@Test
	void createOrderTest01() {
		Order order = service.createOrder(LocalDate.of(2099, 12, 30), "Jack Brown", "Texas", "Carpet", new BigDecimal("150"));
		
		Tax texasTax = new Tax();
		texasTax.setStateAbbreviation("TX");
		texasTax.setStateName("Texas");
		texasTax.setTaxRate(new BigDecimal("4.45"));
		
		Product product = new Product();
		product.setCostPerSquareFoot(new BigDecimal("2.25"));
		product.setLaborCostPerSquareFoot(new BigDecimal("2.10"));
		product.setProductType("Carpet");
		
		
		Order testOrder = new Order(LocalDate.of(2099, 12, 30), 1, "Jack Brown", texasTax, product, new BigDecimal("150"), new BigDecimal("337.5"), new BigDecimal("315"), new BigDecimal("2903.62"), new BigDecimal("3556.12"));
		
		assertEquals(true, order.equals(testOrder));
	}

}
