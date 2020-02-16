package com.retailshoppingstore.onlinecart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailshoppingstore.onlinecart.entity.Product;
import com.retailshoppingstore.onlinecart.service.ProductService;

@RestController("onlinestore")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(name="/product/{id}",produces = "application/json")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		
		try {
			return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(name="/products",produces = "application/json")
	public ResponseEntity<Iterable<Product>> getAllProduct(){

		return new ResponseEntity<Iterable<Product>>(productService.getAllProduct(), HttpStatus.OK);
	}
	@PostMapping("/product")
	public ResponseEntity<Product> createProduct( @RequestBody Product product){
		Product createdProduct= productService.createProduct(product);
		return new ResponseEntity<>(createdProduct,  HttpStatus.CREATED);
	}
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable Long id){
		
		try {
			productService.deleteProduct(id);
			return new ResponseEntity<>("{\"status\": \"success\"}", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id) {
		Product prod;
		try {
			prod = productService.updateProduct(product, id);
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	
}
