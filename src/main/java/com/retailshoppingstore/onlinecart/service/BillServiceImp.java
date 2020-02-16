package com.retailshoppingstore.onlinecart.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailshoppingstore.onlinecart.Repository.BillRepository;
import com.retailshoppingstore.onlinecart.Repository.ItemRepository;
import com.retailshoppingstore.onlinecart.Repository.ProductRepository;
import com.retailshoppingstore.onlinecart.entity.Bill;
import com.retailshoppingstore.onlinecart.entity.Item;
import com.retailshoppingstore.onlinecart.util.ProductTaxCategory;

@Service
public class BillServiceImp implements BillService {

	
	@Autowired
	private BillRepository billRepo;

	@Autowired
	private ItemRepository itemRepo;

	

	@Autowired
	private ProductRepository productRepo;
	
	
	public void updateBill(Bill b) {
    billRepo.update(b);
	}

	public void deleteBill(Long id) throws Exception {
		doBillExists(id);
		billRepo.deleteById(id);
	}

	public Iterable<Bill> getAllBills() {
		Iterable<Bill> bill = billRepo.findAll();
		return bill;
	}

	public Optional<Bill> getBillById(Long id) throws Exception {
		doBillExists(id);
		return billRepo.findById(id);
	}
	private void doBillExists(Long id) throws Exception {
		Bill bill = billRepo.findOne(id);
		if (bill == null) {
			throw new Exception("Bill with id " + id + " not found");
		}
	}
	
	private void computeOverallValues(Bill bill) {

		int totalItems = 0;
		double overallValue = 0;
		double overallCost = 0;

		if (null != bill.getItems ()) {
			List<Item> lineItems = bill.getItems();
			Iterator<Item> lineItemsIter = lineItems.iterator();
			while (lineItemsIter.hasNext()) {
				Item item = lineItemsIter.next();
				double saleValue = calculateItemValue(item.getQuantity(), item.getProduct().getProductTaxCategory(),
						item.getProduct().getRate());
				overallCost += saleValue;
				overallCost += item.getQuantity() * item.getProduct().getRate();
				totalItems++;
			}
		}
		bill.setNumberOfItems(totalItems);
		bill.setOverallValue(overallValue);
		bill.setOverallCost(overallCost);
		bill.setOverallTax(overallValue - overallCost);
		billRepo.save(bill);
	}
	private double calculateItemValue(long quantity, ProductTaxCategory productCategory, double rate) {
		double saleValue = 0;
		if (productCategory.equals(ProductTaxCategory.A)) {
			saleValue = quantity * rate * 1.1; // 10% levy

		} else if (productCategory.equals(ProductTaxCategory.B)) {
			saleValue = quantity * rate * 1.2; // 20% levy

		} else if (productCategory.equals(ProductTaxCategory.C)) {
			saleValue = quantity * rate;
		}
		return saleValue;
	}

	@Override
	public Bill updateBill(Bill updateBill, Long billId) throws Exception {


		if (null == updateBill) {
			throw new Exception("Information not available for this id " + billId);
		}
		doBillExists(billId);
		computeOverallValues(updateBill);
		billRepo.update(updateBill);
		return updateBill;

	}

	@Override
	public Bill createBill(Bill b) {
		return billRepo.save(b);
		
	}

}
