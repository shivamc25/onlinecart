package com.retailshoppingstore.onlinecart.service;

import com.retailshoppingstore.onlinecart.entity.Product;

public interface ProductService {

	public Product getProductById(Long id) throws Exception ;

	public Iterable<Product> getAllProduct();

	public Product createProduct(Product p);

	public Product updateProduct(Product product, Long id) throws Exception;

	public void deleteProduct(Long id) throws Exception;


}
