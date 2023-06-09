package com.fo.presentation;

import java.io.FileNotFoundException;

public interface FoUserInterface {
	
	public void performMenu(String choice) throws FileNotFoundException, Exception;
	public void showMenu();

}
