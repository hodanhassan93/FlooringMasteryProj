package com.fo.presentation;

import java.io.FileNotFoundException;

import com.fo.utility.NoOrdersFoundException;

public interface FoUserInterface {
	
	public void performMenu(String choice) throws NoOrdersFoundException;
	public void showMenu();

}
