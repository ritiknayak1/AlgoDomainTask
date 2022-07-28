package com.example.assignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Product")
@Entity
public class Product {
	
@Id
private long id;
private String productName;
private String productType;
private String productCategory;
private int price;

public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductType() {
	return productType;
}
public void setProductType(String productType) {
	this.productType = productType;
}
public String getProductCategory() {
	return productCategory;
}
public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}

@Override
public String toString() {
	return "Product [id=" + id + ", productName=" + productName + ", productType=" + productType + ", productCategory="
			+ productCategory + ", price=" + price + "]";
}



public Product(long id, String productName, String productType, String productCategory, int price) {
	super();
	this.id = id;
	this.productName = productName;
	this.productType = productType;
	this.productCategory = productCategory;
	this.price = price;
}
public Product() {
	super();
}

}
