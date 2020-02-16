package com.retailshoppingstore.onlinecart.service;

import java.util.Optional;

import com.retailshoppingstore.onlinecart.entity.Bill;

public interface BillService {

	public Bill updateBill(Bill billInfo, Long id) throws Exception;
	
	public Bill createBill(Bill b);

	public void deleteBill(Long id) throws Exception;

	public  Iterable<Bill> getAllBills();

	public Optional<Bill> getBillById(Long id) throws Exception;
}
