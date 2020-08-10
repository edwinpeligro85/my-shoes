package com.myshoes.ecommerce.dao.interfaces;

import java.util.List;

import com.myshoes.ecommerce.model.Product;

public interface ProductDao {

	void saveProduct(Product product);
	
	void deleteProduct(Long idProduct);
	
	void UpdateProduct(Product product);
	
	List<Product> findAllProducts();
	
	Product findProductById(Long idProduct);
	
	List<Product> findProductsByname(String name);
}
