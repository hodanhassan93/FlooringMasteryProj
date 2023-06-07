package com.fo.test;

import com.fo.dataaccess.FoProductDataAccessImpl;
import com.fo.dto.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedList;

class ProductReadObjectTest {
    private LinkedList<Product> productList;

    @BeforeEach
    public void setup() {
        try {
            productList = FoProductDataAccessImpl.readRecords("Products.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readObject03() {
        Product product1 = productList.get(0);
        Assertions.assertEquals("Carpet", product1.getProductType());
        Assertions.assertEquals(new BigDecimal("2.25"), product1.getCostPerSquareFoot());
        Assertions.assertEquals(new BigDecimal("1.75"), product1.getLaborCostPerSquareFoot());

        Product product2 = productList.get(1);
        Assertions.assertEquals("Laminate", product2.getProductType());
        Assertions.assertEquals(new BigDecimal("1.75"), product2.getCostPerSquareFoot());
        Assertions.assertEquals(new BigDecimal("2.10"), product2.getLaborCostPerSquareFoot());

        Product product3 = productList.get(2);
        Assertions.assertEquals("Tile", product3.getProductType());
        Assertions.assertEquals(new BigDecimal("3.50"), product3.getCostPerSquareFoot());
        Assertions.assertEquals(new BigDecimal("4.15"), product3.getLaborCostPerSquareFoot());

        Product product4 = productList.get(3);
        Assertions.assertEquals("wood", product4.getProductType());
        Assertions.assertEquals(new BigDecimal("5.15"), product4.getCostPerSquareFoot());
        Assertions.assertEquals(new BigDecimal("4.75"), product4.getLaborCostPerSquareFoot());
    }

    @Test
    public void readObject04() {
        boolean exceptionThrown = false;

        try {
            productList = FoProductDataAccessImpl.readRecords("NonexistentFile.txt");
        } catch (FileNotFoundException e) {
            exceptionThrown = true;
            e.printStackTrace();
        }

        Assertions.assertTrue(exceptionThrown, "Expected FileNotFoundException was not thrown.");
    }
}
