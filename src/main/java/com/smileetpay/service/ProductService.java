package com.smileetpay.service;

import java.util.List;

import com.smileetpay.model.Marchant;
import com.smileetpay.model.Product;

public interface ProductService {

	Product getProductById(int id);

	Boolean create(Product product);

	Boolean update(Product product);

	Boolean delete(int id);

	List<Product> getAllProducts();

	Boolean associateMarchant(Product p, Marchant marchant);
}
