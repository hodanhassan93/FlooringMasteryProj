package com.fo.dataaccess;

import java.util.Collection;
import java.util.LinkedList;
import com.fo.dto.*;

public interface FoDataAccess {
	
	public <E> Collection<E> readObject(String fileName);
	public void writeOrdersToAFile(LinkedList<Order> orders);

}
