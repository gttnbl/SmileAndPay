package com.smileetpay.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smileetpay.dtos.ProductMarchantDto;
import com.smileetpay.model.Product;
import com.smileetpay.service.ProductService;

@RestController
@Transactional
public class ProductController {

	@Autowired
	ProductService productService;

	// mandatory
	@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public void updateProduct(@RequestBody Product product) {
		productService.update(product);
	}

	@RequestMapping(value = "/associateMarchant", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Boolean associateMarchant(@RequestBody ProductMarchantDto p) {
		return productService.associateMarchant(p.getProduct(), p.getMarchant());
	}

	// optionnal

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public void addProduct(@RequestBody Product product) {
		productService.create(product);

	}

	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void deleteProduct(@PathVariable("id") int id) {
		productService.delete(id);

	}

	// not descript
	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Product> getAllProducts() {

		List<Product> listOfProducts = productService.getAllProducts();
		return listOfProducts;
	}
}
