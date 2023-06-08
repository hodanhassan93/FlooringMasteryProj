package com.fo.dataaccess;

import java.util.LinkedList;
import com.fo.dto.*;

public interface FoDataAccess {
	public <E>LinkedList<E> readObjects(String FileName) throws Exception;
}

