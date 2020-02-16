package com.retailshoppingstore.onlinecart.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailshoppingstore.onlinecart.entity.Bill;
import com.retailshoppingstore.onlinecart.service.BillService;
import com.retailshoppingstore.onlinecart.util.StatusOfBill;

@RestController("onlinebill")
public class BillsController {
	
	@Autowired
	private BillService billService;
	
	@GetMapping(name="/bill/{id}",produces = "application/json")
	public ResponseEntity<Optional<Bill>> getBillById(@PathVariable Long id){
		
		try {
			return new ResponseEntity<>(billService.getBillById(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(name="/bills",produces = "application/json")
	public ResponseEntity<Iterable<Bill>> getAllBills(){
		
		return new ResponseEntity<>(billService.getAllBills(), HttpStatus.OK);
	}
	@PostMapping("/bill")
	public ResponseEntity<Bill> createBill(Bill bill){
		billService.createBill(new Bill(0, 0.0, StatusOfBill.IN_PROCESS));
		return new ResponseEntity<>(bill,  HttpStatus.CREATED);
	}
	@DeleteMapping("/bill/{id}")
	public ResponseEntity<String> deleteBill(@PathVariable Long id){
		try {
			billService.deleteBill(id);
			return new ResponseEntity<>("{\"status\": \"success\"}", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/bill/{id}")
	public ResponseEntity<Bill> updateBill(@RequestBody Bill billInfo, @PathVariable Long id){
		Bill updatedBill;
		try {
			updatedBill = billService.updateBill(billInfo, id);
			return new ResponseEntity<>(updatedBill, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
		
	} 

}
