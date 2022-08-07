package com.smileetpay.dtos;

import com.smileetpay.model.Marchant;
import com.smileetpay.model.Product;

public class ProductMarchantDto {
	
	private Product product;
	
	private Marchant marchant;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Marchant getMarchant() {
		return marchant;
	}

	public void setMarchant(Marchant marchant) {
		this.marchant = marchant;
	}

	public ProductMarchantDto(Product product, Marchant marchant) {
		super();
		this.product = product;
		this.marchant = marchant;
	}

	public ProductMarchantDto() {
		super();
	}

	@Override
	public String toString() {
		return "ProductMarchantDto [product=" + product + ", marchant=" + marchant + "]";
	}

	
	
	
}
