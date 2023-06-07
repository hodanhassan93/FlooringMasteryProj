package com.fo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fo.service.FoBusinessLogicImpl;
import com.fo.utility.InvalidInputException;

class CheckAreaTest {
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
	void CheckArea01() {
		assertThrows(InvalidInputException.class, service.checkArea("text!"));
	}
	
	@Test
	void CheckArea02() {
		assertThrows(InvalidInputException.class, service.checkArea("10"));
	}
	
	@Test
	void CheckArea03() {
		assertEquals(true, service.checkArea("150"));
	}
	
	@Test
	void CheckArea04() {
		assertThrows(InvalidInputException.class, service.checkArea("-99"));
	}
	
	@Test
	void CheckArea05() {
		assertEquals(false, service.checkArea(""));
	}

}
