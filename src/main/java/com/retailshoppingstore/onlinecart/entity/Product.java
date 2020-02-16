package com.retailshoppingstore.onlinecart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.retailshoppingstore.onlinecart.util.ProductTaxCategory;


@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	@NotNull
	@Column(unique = true)
	private String barCodeId;

	@NotNull
	private String nameOfProduct;

	@NotNull
	@Enumerated(EnumType.STRING)
	private ProductTaxCategory productTaxCategory;

	@NotNull
	private double rate;

	public Product() {
		super();
	}

	public Product(String barCodeId, double rate, String nameOfProduct, ProductTaxCategory productTaxCategory) {
		super();
		this.barCodeId = barCodeId;
		this.rate = rate;
		this.nameOfProduct = nameOfProduct;
		this.productTaxCategory = productTaxCategory;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getBarCodeId() {
		return barCodeId;
	}

	public void setBarCodeId(String barCodeId) {
		this.barCodeId = barCodeId;
	}

	public String getNameOfProduct() {
		return nameOfProduct;
	}

	public void setNameOfProduct(String nameOfProduct) {
		this.nameOfProduct = nameOfProduct;
	}

	public ProductTaxCategory getProductTaxCategory() {
		return productTaxCategory;
	}

	public void setProductTaxCategory(ProductTaxCategory productTaxCategory) {
		this.productTaxCategory = productTaxCategory;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	
}
