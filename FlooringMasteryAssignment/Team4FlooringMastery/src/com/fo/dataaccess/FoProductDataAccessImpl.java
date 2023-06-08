package com.fo.dataaccess;

import java.util.LinkedList;
import java.io.FileReader;
import java.math.BigDecimal;
import com.fo.dto.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FoProductDataAccessImpl implements FoDataAccess {
	
    public static LinkedList<Product> readObject(String filename) throws Exception {
        LinkedList<Product> products = new LinkedList<>();

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Scanner scanner = new Scanner(bufferedReader);

            scanner.nextLine();

            while (scanner.hasNext()) {
                String currentLine = scanner.nextLine();
                String[] values = currentLine.split(",");

                Product product = new Product();
                product.setProductType(values[0]);
                product.setCostPerSquareFoot(new BigDecimal(String.valueOf(values[1])));
                product.setLaborCostPerSquareFoot(new BigDecimal(String.valueOf(values[2])));

                products.add(product);
            }

            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found: " + filename);
        }

        return products;
    }
  
  public void writeOrdersToAFile(LinkedList<Order> orders){
  }
}


