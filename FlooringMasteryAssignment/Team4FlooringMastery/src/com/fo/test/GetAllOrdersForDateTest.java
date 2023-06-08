package com.fo.test;

import com.fo.dataaccess.FoOrderDataAccessImpl;
import com.fo.dto.*;
import com.fo.utility.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.stream.Stream;
import com.fo.service.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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
	
	 void test(String fileName) throws NoOrdersFoundException, IOException {


		
		FoOrderDataAccessImpl dao = new FoOrderDataAccessImpl();
		FoBusinessLogicImpl fobusinessLogicImpl = new FoBusinessLogicImpl();
		 boolean result = fobusinessLogicImpl.searchOrdersByDate(1);
		    assertTrue(result);
		
		Path path = Paths.get(fileName);
		
//		File orderFile = new File(fileName);

		

	
	}

	static Stream<String> DateProvider() {
	    return Stream.of("Orders_06012013");
	}
}
