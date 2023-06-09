package com.fo.dataaccess;

import java.util.LinkedList;
import com.fo.dto.*;

public interface FoDataAccess {


	

	LinkedList<Order> readOrders(String FileName) throws Exception;

	boolean writeObject(LinkedList<Order> orders, String FileName) throws FileNotFoundException;

	LinkedList<Product> readObject(String filename) throws Exception;

	public <E>LinkedList<E> readObjects(String FileName) throws Exception;

}

