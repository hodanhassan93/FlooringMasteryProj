package com.fo.dataaccess;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.LinkedList;
import com.fo.dto.*;

public interface FoDataAccess {

	public <E> LinkedList<E> readObject(String fileName) throws Exception;
}
