package com.fo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Order {
	private LocalDate orderDate;
	private int orderNumber;
	private String customerName;
	private Tax taxInfo;
	private Product product;
	private BigDecimal area;
	private BigDecimal materialCost;
	private BigDecimal laborCost;
	private BigDecimal tax;
	private BigDecimal total;
	
	public Order(LocalDate orderDate, int orderNumber, String customerName, Tax taxInfo, Product product,
			BigDecimal area, BigDecimal materialCost, BigDecimal laborCost, BigDecimal tax, BigDecimal total) {
		super();
		this.orderDate = orderDate;
		this.orderNumber = orderNumber;
		this.customerName = customerName;
		this.taxInfo = taxInfo;
		this.product = product;
		this.area = area;
		this.materialCost = materialCost;
		this.laborCost = laborCost;
		this.tax = tax;
		this.total = total;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Tax getTaxInfo() {
		return taxInfo;
	}

	public void setTaxInfo(Tax taxInfo) {
		this.taxInfo = taxInfo;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public BigDecimal getMaterialCost() {
		return materialCost;
	}

	public BigDecimal getLaborCost() {
		return laborCost;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public BigDecimal getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Order [orderDate=" + orderDate + ", orderNumber=" + orderNumber + ", customerName=" + customerName
				+ ", taxInfo=" + taxInfo + ", product=" + product + ", area=" + area + ", materialCost=" + materialCost
				+ ", laborCost=" + laborCost + ", tax=" + tax + ", total=" + total + "]";
	}
		
}


