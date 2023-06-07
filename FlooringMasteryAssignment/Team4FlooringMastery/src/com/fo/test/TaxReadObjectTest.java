package com.fo.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fo.dataaccess.FoTaxDataAccessImpl;
import com.fo.dto.Tax;

class TaxReadObjectTest {
	
	FoTaxDataAccessImpl taxDataAccess;

	@BeforeAll
	static void setUpBeforeClass() throws Exception { 
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		taxDataAccess = new FoTaxDataAccessImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		taxDataAccess = null;
	}

	@Test
	void readObjectTest01() {
		try {
			LinkedList<Tax> taxes = taxDataAccess.readObject("Taxes");
			assertEquals(true, (taxes != null) );
		} catch(Exception FileNotFoundException) {
			fail();
		}
	}
	
	@Test
	void readObjectTest02() {
		assertThrows(FileNotFoundException.class, () -> taxDataAccess.readObject("foo"));
		
	}

}
