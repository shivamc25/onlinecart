package com.retailshoppingstore.onlinecart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.retailshoppingstore.onlinecart.util.StatusOfBill;

@Entity
@Table
public class Bill {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int numberOfItems;
	private double overallCost;

	private double overallTax;

	private double overallValue;

	@NotNull
	private StatusOfBill statusOfBill;

	@OneToMany(cascade=CascadeType.REMOVE,fetch = FetchType.EAGER)
	private List<Item> items;

	public Bill(Integer i, double d, StatusOfBill status) {
		numberOfItems=i;
		overallValue=d;
		statusOfBill=status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public double getOverallCost() {
		return overallCost;
	}

	public void setOverallCost(double overallCost) {
		this.overallCost = overallCost;
	}

	public double getOverallTax() {
		return overallTax;
	}

	public void setOverallTax(double overallTax) {
		this.overallTax = overallTax;
	}

	public double getOverallValue() {
		return overallValue;
	}

	public void setOverallValue(double overallValue) {
		this.overallValue = overallValue;
	}

	public StatusOfBill getStatusOfBill() {
		return statusOfBill;
	}

	public void setStatusOfBill(StatusOfBill statusOfBill) {
		this.statusOfBill = statusOfBill;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
