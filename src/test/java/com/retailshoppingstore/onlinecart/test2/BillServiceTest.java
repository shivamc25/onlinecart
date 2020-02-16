package com.retailshoppingstore.onlinecart.test2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retailshoppingstore.onlinecart.entity.Bill;
import com.retailshoppingstore.onlinecart.service.BillService;
import com.retailshoppingstore.onlinecart.util.StatusOfBill;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillServiceTest {

	@Autowired
	private BillService billService;

	@Test
	public void testCreateBill() throws Exception {
		Bill o1 = billService.createBill(new Bill(0, 0/0, StatusOfBill.IN_PROCESS));
		Optional<Bill> o2 = billService.getBillById(o1.getId());
		assertThat(o1.getId()).isEqualTo(o2.get().getId());
	}

}
