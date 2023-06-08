package com.fo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sujata.demo.Calculator;
import com.sujata.test.AfterEach;
import com.sujata.test.BeforeEach;

class CheckStateTest {

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
	void checkState() {
		String stateCode = "TX";
		boolean result = foBusinessLogic.checkState(stateCode);
		assertTrue(result);
	}

	@Test // CheckState02
	void checkState() {
		String stateName = "Texas";
		boolean result = foBusinessLogic.checkState(stateName);
		assertTrue(result);
	}

	@Test //CheckState03
	void checkState("Kansas") throws InvalidInputException {
		assertThrows(InvalidInputException.class, ()->foBusinessLogic.checkState("Kansas"));
	}

	@Test // CheckState04
	void checkState() {
		String stateName = "Kansas";
		boolean result = foBusinessLogic.checkState(stateName);
		assertFalse(result);
	}

}
