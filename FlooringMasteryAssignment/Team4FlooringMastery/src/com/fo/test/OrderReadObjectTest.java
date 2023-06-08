package com.fo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderReadObjectTest {

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

	@Test //ReadObjectTest05 - checks if the readObject() method successfully reads the orders from the specified file
	void readObject() {
		OrderReadObject orderReadObject = new OrderReadObject();
        String fileName = "Orders_06012013.txt";
        LinkedList<Order> orders = orderReadObject.readObject(fileName);
		assertNotNull(orders);
	}

	@Test //ReadObjectTest06 - checks if an exception is thrown when an invalid file name is provided
	void readObject() throws FileNotFoundException {
		
		OrderReadObject orderReadObject = new OrderReadObject();
		String fileName = "foo";
		
		assertThrows(Exception.class, () -> {
			orderReadObject.readObject(fileName);
		});
	}
}
