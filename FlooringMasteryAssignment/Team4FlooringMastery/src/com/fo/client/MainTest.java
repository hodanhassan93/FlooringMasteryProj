package com.fo.client;

import java.time.LocalDate;
import java.util.LinkedList;

import com.fo.dataaccess.*;
import com.fo.dto.Order;
import com.fo.dto.Product;

public class MainTest {

	public static void main(String[] args) {
		FoOrderDataAccessImpl dataAccess = new FoOrderDataAccessImpl();
		LinkedList<Order> orders = new LinkedList<>();

//		try {
////			products = dataAccess.readObjects("Orders_06012013.txt");
//			products = dataAccess.readObjects("foo");
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}

//		try {
//			orders = dataAccess.readObjects("Orders_06012013.txt");
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}

//		System.out.println(orders.get(0));

//		try {
//			dataAccess.writeObject(orders, "Orders_test.txt");
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}

//		System.out.println(products.get(1));
		
		LocalDate date = LocalDate.of(2013,06,01);
		
		System.out.println("Order" + date + ".txt");

	}

}
