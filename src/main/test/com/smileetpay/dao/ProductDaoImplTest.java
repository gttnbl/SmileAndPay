package com.smileetpay.dao;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.smileetpay.model.Marchant;
import com.smileetpay.model.Product;


@RunWith(MockitoJUnitRunner.class)
public class ProductDaoImplTest {

	@Mock
	ProductDao productDao;

	@Mock
	MarchantDao marchantDao;
	@InjectMocks
	ProductDaoImpl productDaoImpl;
	Product pGet;
	Marchant mAssoc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		pGet = new Product();
		pGet.setLabel("testGet");
		pGet.setCurrency("$");
		pGet.setUnit_price(10);
		pGet.setWeight(77);
		pGet.setHeight(33);

		

		mAssoc = new Marchant();
		mAssoc.setMarchant_id(1);
	}
	
	@Test
	public void testQssociateMarchant() {
	
		
	   // Mockito.when(spyTemp.getProductById(Mockito.anyInt())).thenReturn(pGet);
	    Mockito.doReturn(pGet).when(productDao).getProductById(Mockito.anyInt());

	    
		Mockito.when(marchantDao.getMarchantById(Mockito.anyInt())).thenReturn(mAssoc);
		productDaoImpl.associateMarchant(pGet, mAssoc);
	}
}
