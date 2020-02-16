package com.retailshoppingstore.onlinecart.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.retailshoppingstore.onlinecart.entity.Bill;

@Repository
public interface BillRepository  extends CrudRepository<Bill, Long> {

	void update(Bill b);

	Bill findOne(Long id);

}
