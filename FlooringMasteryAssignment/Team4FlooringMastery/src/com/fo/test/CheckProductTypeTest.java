package com.fo.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import com.fo.dto.*;
import com.fo.dataaccess.*;
import com.fo.dto.Order;
import com.fo.service.*;


class CheckProductTypeTest {

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

//	FoDataAccess dao = FoOrderDataAccessImpl 

//	@ParameterizedTest
//	@MethodSource("stringProvider")

//	void CheckProductType(String type) throws EntryNotFoundException {
//
//		LinkedList<Order> orders = new LinkedList<Order>();
//
////		assertEquals(stringProvider(),order.getProductType());
//
//		BigDecimal bg1 = new BigDecimal("5");
//
//		Order order1 = new Order(1, "Ada LoveLace", "Texas", bg1, "Carpet", bg1, bg1, bg1, bg1, bg1, bg1, bg1);
//
//		orders.add(order1);
//
//		for (Order order : orders) {
//
//			if ((order.getProductType() == type)) {
//
//			}
//
//			else if (!(order.getProductType() == type)) {
//
//				throw new EntryNotFoundException("Entry not found");
//
//			}
//
//		}
//
//	}
//
//	static Stream<String> stringProvider() {
//		return Stream.of("Carpet", "Drape", "");
//	}
//
//}
	
	@Test
	
	void test() throws Exception {
		
		FoBusinessLogic service;
		
		FoProductDataAccessImpl dao = new FoProductDataAccessImpl();
		
	    
		
		LinkedList<Product> productsList = dao.readObject("Products");
		
		for(Product product:productsList) {
			
			FoBusinessLogicImpl fobusinessLogicImpl = new FoBusinessLogicImpl();
		    boolean result = fobusinessLogicImpl.checkProductType("carpet");
		    assertTrue(result);	
			
			
		}
		
		
		
	}
	
	}
