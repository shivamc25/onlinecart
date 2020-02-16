package com.retailshoppingstore.onlinecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.retailshoppingstore.onlinecart.Repository.ProductRepository;
import com.retailshoppingstore.onlinecart.entity.Product;

public class ProductServiceImp implements ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public Product updateProduct(Product productDetail, Long id) throws Exception {
		doProductExists(id);
		productRepo.update(productDetail);
		return productDetail;
	}
	private void doProductExists(Long id) throws Exception {
		Product product = productRepo.findOne(id);
		if (product == null) {
			throw new Exception("Product with id " + id + " not found");
		}
	}
	public Iterable<Product> getAllProducts() {
		Iterable<Product> products = productRepo.findAll();
		return products;
	}

	public Product getProductById(Long id) throws Exception {
		return productRepo.findOne(id);
	}
	public void deleteProduct(Long id) throws Exception {
		doProductExists(id);
		productRepo.delete(id);
	}
	@Override
	public Iterable<Product> getAllProduct() {
		Iterable<Product> product = productRepo.findAll();
		return product;
	}
	@Override
	public Product createProduct(Product p) {
		Product newProduct = productRepo.save(p);
		return newProduct;
	}
	
	
		
}
