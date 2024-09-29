package com.aryan.ecommerce.service;

import java.util.List;

import com.aryan.ecommerce.entity.Product;



public interface ProductService {
	Product addProduct(Product product);
	Product updateProduct(int productId, Product product);
	boolean deleteProduct(int productId);
	List<Product> getAllProducts();
	Product getProductById(int productId);
	List<Product> getProductsByCategoryId(int catId);
}
