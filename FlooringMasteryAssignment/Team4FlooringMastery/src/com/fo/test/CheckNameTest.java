package com.fo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fo.service.*;
import com.fo.utility.InvalidInputException;

class CheckNameTest {

	@Test
	public void checkNameTest01() {

		FoBusinessLogicImpl businessLogic = new FoBusinessLogicImpl();

		boolean result = businessLogic.checkName("John, Doe");

		Assertions.assertTrue(result);
	}

	@Test
	public void checkNameTest02() {

		FoBusinessLogicImpl businessLogic = new FoBusinessLogicImpl();

		Assertions.assertThrows(InvalidInputException.class, () -> businessLogic.checkName("John@Doe"));
	}

	@Test
	public void checkNameTest03() {

		FoBusinessLogicImpl businessLogic = new FoBusinessLogicImpl();

		boolean result = businessLogic.checkName("");

		Assertions.assertFalse(result);
	}
}
