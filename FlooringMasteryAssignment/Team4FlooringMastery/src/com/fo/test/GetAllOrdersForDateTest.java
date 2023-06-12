package com.fo.test;

import com.fo.dataaccess.FoOrderDataAccessImpl;
import com.fo.dto.*;
import com.fo.utility.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.stream.Stream;
import com.fo.service.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetAllOrdersForDateTest {

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
	void test() throws NoOrdersFoundException, IOException {
		FoBusinessLogicImpl fobusinessLogicImpl = new FoBusinessLogicImpl();
		LinkedList<Order> result = new LinkedList<Order>();
		try {
			result = fobusinessLogicImpl.getAllOrdersForDate(LocalDate.parse("2013-06-01"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DateChangeException e) {
			e.printStackTrace();
		}
		assertTrue(result.size() > 0);
	}

}
