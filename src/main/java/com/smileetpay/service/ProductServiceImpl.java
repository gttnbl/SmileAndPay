package com.smileetpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smileetpay.dao.ProductDao;
import com.smileetpay.model.Marchant;
import com.smileetpay.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		productDao.create(product);
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.getProductById(id);
	}

	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
		productDao.create(product);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productDao.delete(id);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	@Override
	public Boolean associateMarchant(Product p, Marchant marchant) {
		// TODO Auto-generated method stub
		return productDao.associateMarchant(p,marchant);
	}

}
