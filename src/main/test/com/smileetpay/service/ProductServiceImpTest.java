//package com.smileetpay.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import com.smileetpay.dao.MarchantDao;
//import com.smileetpay.dao.ProductDao;
//import com.smileetpay.model.Marchant;
//import com.smileetpay.model.Product;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ProductServiceImpTest {
//
//	@InjectMocks
//	ProductServiceImpl productServiceImpl;
//	@Mock
//	ProductDao productDao;
//
//	@Mock
//	MarchantDao marchantDao;
//
//	Product pGet;
//	Product pGet1;
//	Marchant mAssoc;
//	List<Product> pListGetAll;
//
//	@Before
//	public void setup() {
//		MockitoAnnotations.initMocks(this);
//		pGet = new Product();
//		pGet.setLabel("testGet");
//		pGet.setCurrency("$");
//		pGet.setUnit_price(10);
//		pGet.setWeight(77);
//		pGet.setHeight(33);
//
//		pGet1 = new Product();
//		pGet1.setProduct_id(1);
//		pGet1.setLabel("testGet1");
//		pGet1.setCurrency("€");
//		pGet1.setUnit_price(20);
//		pGet1.setWeight(99);
//		pGet1.setHeight(88);
//		pListGetAll = new ArrayList<Product>();
//		pListGetAll.add(pGet);
//		pListGetAll.add(pGet1);
//
//		mAssoc = new Marchant();
//		mAssoc.setMarchant_id(1);
//	}
//
//	public void testGetProductById() {
//
//		Mockito.when(productDao.getProductById(Mockito.anyInt())).thenReturn(pGet);
//		Product rst = productServiceImpl.getProductById(1);
//		assertEquals(rst.getLabel(), pGet.getLabel());
//		assertEquals(rst.getCurrency(), pGet.getCurrency());
//		assertEquals(rst.getUnit_price(), pGet.getUnit_price());
//		assertEquals(rst.getWeight(), pGet.getWeight());
//		assertEquals(rst.getHeight(), pGet.getHeight());
//	}
//
//	public void testCreate() {
//		productServiceImpl.create(1);
//		// assertEquals(7, MagicBuilder.getLucky());
//	}
//
//	public void testUpate() {
//		productServiceImpl.update(1);
//		// assertEquals(7, MagicBuilder.getLucky());
//	}
//
//	public void testDelete() {
//		productServiceImpl.delete(1);
//		// assertEquals(7, MagicBuilder.getLucky());
//	}
//
//	public void testGetAllProducts() {
//
//		Mockito.when(productDao.getAllProducts()).thenReturn(pListGetAll);
//		List<Product> rst = productServiceImpl.getAllProducts();
//		assertEquals(rst.get(0).getLabel(), pGet.getLabel());
//		assertEquals(rst.get(0).getCurrency(), pGet.getCurrency());
//		assertEquals(rst.get(0).getUnit_price(), pGet.getUnit_price());
//		assertEquals(rst.get(0).getWeight(), pGet.getWeight());
//		assertEquals(rst.get(0).getHeight(), pGet.getHeight());
//
//		assertEquals(rst.get(1).getLabel(), pGet1.getLabel());
//		assertEquals(rst.get(1).getCurrency(), pGet1.getCurrency());
//		assertEquals(rst.get(1).getUnit_price(), pGet1.getUnit_price());
//		assertEquals(rst.get(1).getWeight(), pGet1.getWeight());
//		assertEquals(rst.get(1).getHeight(), pGet1.getHeight());
//		// assertEquals(7, MagicBuilder.getLucky());
//	}
//
//	@Test
//	public void testAssociateMarchant() {
//		Mockito.when(productDao.getProductById(Mockito.anyInt())).thenReturn(pGet);
//		Mockito.when(marchantDao.getMarchantById(Mockito.anyInt())).thenReturn(mAssoc);
//
//		Boolean rtn = productServiceImpl.associateMarchant(pGet1, mAssoc);
//	//	assertTrue(rtn);
//		// assertEquals(7, MagicBuilder.getLucky());
//	}
//}
