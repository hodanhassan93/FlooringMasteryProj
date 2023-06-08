package com.fo.client;

import java.util.LinkedList;

import com.fo.dataaccess.*;
import com.fo.dto.Product;

public class MainTest {

	public static void main(String[] args) {
		FoProductDataAccessImpl dataAccess = new FoProductDataAccessImpl();
		LinkedList<Product> products = new LinkedList<>();
		
		try {
			products = dataAccess.readObject("Products.txt");
		} catch (Exception ex) {
			
		}
		
		System.out.println(products.get(1));
		System.out.println(products.get(0));

	}

}
