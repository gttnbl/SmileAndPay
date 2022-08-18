package com.smileetpay.dao;

import java.util.List;

import com.smileetpay.model.Marchant;
import com.smileetpay.model.Product;
import com.smileetpay.service.soap.dto.AssociateDto;

public interface ProductDao {

	Boolean create(Product product);

	Boolean update(Product product);

	Boolean delete(int id);

	Product getProductById(int id);

	List<Product> getAllProducts();

	Boolean associateMarchant(Product p, Marchant marchant);
	
	Boolean associateMarchant(AssociateDto a);
}
