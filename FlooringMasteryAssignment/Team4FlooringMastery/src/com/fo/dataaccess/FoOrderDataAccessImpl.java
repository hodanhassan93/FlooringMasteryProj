package com.fo.dataaccess;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import com.fo.dto.Order;
import com.fo.dto.Product;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.io.BufferedReader;
import java.util.Scanner;



public class FoOrderDataAccessImpl implements FoDataAccess{

	

	@Override
	public boolean writeObject (LinkedList<Order> orders,String FileName)throws FileNotFoundException{
		
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(FileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter printWriter=new PrintWriter(fileWriter);
		
		for(Order order:orders) {
			String ordStr=order.getOrderNumber()+","+order.getCustomerName()+","+order.getState()+","+order.getTaxRate()+","+order.getProductType()
			+","+order.getArea()+","+order.getCostPerSquareFoot()+","+order.getLaborCostperSquareFoot()+","+order.getMaterialCost()+","+order.getLaborCost()+","+order.getTax()+","+order.getTotal();
			
			printWriter.println(ordStr);
		}
		
        printWriter.flush();
		
		printWriter.close();

		try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

	}
	


	@Override
	public LinkedList<Order> readOrders(String FileName) throws Exception{
		
		LinkedList<Order> orders=new LinkedList<Order>();
		
		FileReader fileReader = new FileReader(FileName);
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		Scanner scanner = new Scanner(bufferedReader);
		while (scanner.hasNext()) {
			String currentLine = scanner.nextLine();
			
			String values[]=currentLine.split(",");
			
			Order order =new Order( Integer.parseInt(values[0]),values[1],values[2],new BigDecimal(values[3]),values[4],new BigDecimal(values[5]),new BigDecimal(values[6]),new BigDecimal(values[7])
					,new BigDecimal(values[8]),new BigDecimal(values[9]),new BigDecimal(values[10]),new BigDecimal(values[11]));

			orders.add(order);
		}
		fileReader.close();
		bufferedReader.close();
		
		return orders;
	}



	@Override
	public LinkedList<Product> readObject(String filename) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	


}
