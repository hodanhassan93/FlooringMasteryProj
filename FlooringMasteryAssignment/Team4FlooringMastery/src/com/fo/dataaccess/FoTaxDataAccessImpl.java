package com.fo.dataaccess;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.LinkedList;
import com.fo.dto.*;

public class FoTaxDataAccessImpl implements FoDataAccess{

	@Override
//	public <E> Collection<E> readObject(String fileName) {
	public LinkedList<Tax> readObject(String fileName) throws FileNotFoundException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeOrdersToAFile(LinkedList<Order> orders) {
		// TODO Auto-generated method stub
		
	}

}
