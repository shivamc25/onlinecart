package com.retailshoppingstore.onlinecart.test2;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retailshoppingstore.onlinecart.entity.Product;
import com.retailshoppingstore.onlinecart.service.ProductService;
import com.retailshoppingstore.onlinecart.util.ProductTaxCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	public void testProductCreate() throws Exception{
		Product p1 = productService.createProduct(new Product("prod1-1122", 20.0, "pen", ProductTaxCategory.A));
		Product p2 = productService.getProductById(p1.getProductId());
		assertThat(p1.getProductId()).isEqualTo(p2.getProductId());
	}

	@Test
	public void testProductUpdate() throws Exception{
		Product p1 = productService.createProduct(new Product("prod1-1122", 20.0, "pen", ProductTaxCategory.A));
		Product p2 = productService.updateProduct(new Product("prod2-4455", 30.0, "pencil", ProductTaxCategory.B),p1.getProductId());
		Product p3 = productService.getProductById(p1.getProductId());
		assertThat(p3.getProductId()).isEqualTo(p2.getProductId());
		
		assertThat(p3.getBarCodeId()).isEqualTo(p2.getBarCodeId());
		assertThat(p3.getRate()).isEqualTo(p2.getRate());
		assertThat(p3.getProductTaxCategory()).isEqualTo(p2.getProductTaxCategory());
	}

	@Test(expected=Exception.class)
	public void testProductUpdateForNonExistingProduct(){
		productService.createProduct(new Product("prod1-1133", 20.0, "pen", ProductTaxCategory.A));
		try {
			productService.updateProduct(new Product("prod-1119", 30.0, "pencil", ProductTaxCategory.B),(long)99999);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	@Test(expected=Exception.class)
	public void testProductDelete() throws Exception{
		Product p1 = productService.createProduct(new Product("prod3-3344", 20.0, "rubber", ProductTaxCategory.A));
		productService.deleteProduct(p1.getProductId());
		Product p3 = productService.getProductById(p1.getProductId());
		assertThat(p3).isNull();
	}
	
	@Test(expected=Exception.class)
	public void testDelete() throws Exception{
		productService.deleteProduct((long)1);
		Product p3 = productService.getProductById((long)1);
		assertThat(p3).isNull();
	}

	

}
