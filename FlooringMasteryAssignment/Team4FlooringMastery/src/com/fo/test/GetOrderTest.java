package com.fo.test;

import com.fo.dto.*;
import com.fo.utility.NoOrdersFoundException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.stream.Stream;
import com.fo.service.*;
import com.fo.dataaccess.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class GetOrderTest {

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

	@Test
	void GetOrder01() {
		FoOrderDataAccessImpl dao = new FoOrderDataAccessImpl();
		FoBusinessLogicImpl foBusinessLogicImpl = new FoBusinessLogicImpl();

		try {
			LinkedList<Order> ordersList = dao.readObject("Orders_06012013.txt");

			for (Order order : ordersList) {
				boolean result = (foBusinessLogicImpl.getOrder(1) != null);
				assertTrue(result);
			}
		} catch (FileNotFoundException ex) {
			fail();
		}
	}

	@Test
	void GetOrder02() {
		FoOrderDataAccessImpl dao = new FoOrderDataAccessImpl();
		FoBusinessLogicImpl foBusinessLogicImpl = new FoBusinessLogicImpl();

		try {
			LinkedList<Order> ordersList = dao.readObject("Orders_06012013.txt");

			for (Order order : ordersList) {
				boolean result = (foBusinessLogicImpl.getOrder(99) == null);
				assertTrue(result);
			}
		} catch (FileNotFoundException ex) {
			fail();
		}
	}

//	
//	@ParameterizedTest
//	@MethodSource("intProvider")
//	
//	void GetOrder(int orderNo) throws NoOrdersFoundException{
//		
//	BigDecimal bg1 = new BigDecimal("5");
//		
//	Order order1 = new Order(1, "Ada LoveLace", "Texas", bg1, "Carpet", bg1, bg1, bg1, bg1, bg1, bg1, bg1);	
//		
//	
//	LinkedList<Order> orders = new LinkedList<Order>();
//		
//	
//	
//	
//		orders.add(order1);
//		
//		
//		for (Order order: orders) {
//			
//			if (orderNo  == order.getOrderNumber()) {
//				
//				assertTrue("yay",true);
//				
//				System.out.println(order.toString());
//			}
//			
//			else {
//				assertTrue("yay",false);
//				throw new NoOrdersFoundException("No orders with this number found");
//			
//			
//		}
//		
//		
//		
//		} 
//		
//		
//	}
//	
//	static Stream<Integer> intProvider() {
//	    return Stream.of(1, 99);
//	}
}
