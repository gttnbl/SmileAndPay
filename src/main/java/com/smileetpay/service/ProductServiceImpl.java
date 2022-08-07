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
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		 Product rst =  productDao.getProductById(id);
		 return rst ;
	}

	@Override
	public Boolean create(Product product) {
		// TODO Auto-generated method stub
		return productDao.create(product);

	}

	@Override
	public Boolean update(Product product) {
		// TODO Auto-generated method stub
		return productDao.update(product);
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		return productDao.delete(id);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	@Override
	public Boolean associateMarchant(Product p, Marchant marchant) {
		// TODO Auto-generated method stub
		return productDao.associateMarchant(p, marchant);
	}

}
