package com.retailshoppingstore.onlinecart.Repository;

import java.util.List;
import java.util.function.IntPredicate;

import org.springframework.stereotype.Repository;

import com.retailshoppingstore.onlinecart.entity.Item;
import com.retailshoppingstore.onlinecart.entity.Product;

@Repository
public interface ProductRepository {

	Product findOne(Long id);

	Product save(Product product);

	Iterable<Product> findAll();

	Product delete(Long id);

	List<Item> findById(Long id);
	
	void update(Product b);

	IntPredicate count();

}
