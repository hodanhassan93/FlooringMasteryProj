package com.fo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fo.service.FoBusinessLogicImpl;
import com.fo.utility.EntryNotFoundException;

class CheckStateAbbreviationTest {

	private FoBusinessLogicImpl foBusinessLogic;

	@BeforeEach
	void setUp() throws Exception {
		// we created the object and now my reference variable is referring/pointing to
		// that object on heap
		foBusinessLogic = new FoBusinessLogicImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		// reference variable: null
		foBusinessLogic = null;
	}

	@Test // CheckState01 - returns true
	void checkStateAbbreviation() {
		String stateCode = "TX";
		boolean result;
		try {
			result = foBusinessLogic.checkStateAbbreviation(stateCode);
			assertTrue(result);
		} catch (EntryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @Test // CheckState02 - we dont need this test
//	void checkStateAbbreviation() {
//		String stateName = "Texas";
//		boolean result = foBusinessLogic.checkStateAbbreviation(stateName);
//		assertTrue(result);
//	}

//	@Test //CheckState03
//	void stateAbbreviation("Kansas") throws InvalidInputException {
//		assertThrows(InvalidInputException.class, ()->foBusinessLogic.checkStateAbbreviation("Kansas"));
//	}

	@Test // CheckState04
	void checkState() {
		String stateName = "Kansas";
		boolean result;
		try {
			result = foBusinessLogic.checkStateAbbreviation(stateName);
			assertFalse(result);
		} catch (EntryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
