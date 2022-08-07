package com.smileetpay.service;

import java.util.List;

import com.smileetpay.model.Marchant;
import com.smileetpay.model.Product;



public interface ProductService {
	void save(Product product);

	List<Product> list();

	Product getProductById(int id);

	void create(Product product);

	void update(Product product);

	void delete(int id);

	List<Product> getAllProducts();

	Boolean associateMarchant(Product p, Marchant marchant);
}
