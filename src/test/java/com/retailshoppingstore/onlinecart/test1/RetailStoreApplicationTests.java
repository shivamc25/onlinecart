package com.retailshoppingstore.onlinecart.test1;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retailshoppingstore.onlinecart.Repository.ProductRepository;
import com.retailshoppingstore.onlinecart.entity.Product;
import com.retailshoppingstore.onlinecart.util.ProductTaxCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetailStoreApplicationTests {

	@Autowired
	private ProductRepository productMasterRepo;

	@Test
	public void contextLoads() {
	}

	public void testProductSetup() {
		productMasterRepo.save(new Product("prod1-1111", 20.0, "maggi", ProductTaxCategory.A));
		productMasterRepo.save(new Product("prod2-3537", 40.0, "noodles", ProductTaxCategory.B));
		productMasterRepo.save(new Product("prod3-2233", 50.0, "biscuit", ProductTaxCategory.C));
		productMasterRepo.save(new Product("prod4-3377", 35.0, "cookies", ProductTaxCategory.A));
		productMasterRepo.save(new Product("prod5-8890", 100.0, "mango", ProductTaxCategory.B));
		productMasterRepo.save(new Product("prod6-7788", 49.0, "strawberry", ProductTaxCategory.C));
		assertThat(productMasterRepo.count()).isEqualTo(6);
	}

}
