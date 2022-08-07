package com.smileetpay.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.smileetpay.dao.MarchantDao;
import com.smileetpay.model.Marchant;
import com.smileetpay.model.Product;

@RunWith(MockitoJUnitRunner.class)
public class MarchantServiceImplTest {

	@InjectMocks
	MarchantServiceImpl marchantServiceImp;

	@Mock
	MarchantDao marchantDao;
	Marchant mGet;
	Marchant mGet1;

	List<Marchant> mListGetAll;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
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
		mGet = new Marchant();
		mGet.setMarchant_id(1);
		mGet.setName("Toto");
		mGet.setLastname("TiTi");
		mGet1 = new Marchant();
		mGet1.setMarchant_id(1);
		mGet1.setName("Toto");
		mGet1.setLastname("TiTi");
		mListGetAll = new ArrayList<Marchant>();
		mListGetAll.add(mGet);
		mListGetAll.add(mGet1);

	
		//mAssoc.setBirthdate(new Date("1980-11-11"));
	}
	
	@Test
	public void testGetMarchantById() {
		marchantServiceImp.getMarchantById(1);
		Mockito.when(marchantDao.getMarchantById(Mockito.anyInt())).thenReturn(mGet);
		Marchant rst = marchantServiceImp.getMarchantById(1);
		assertEquals(rst.getName(), mGet.getName());
		assertEquals(rst.getLastname(), mGet.getLastname());
		//assertEquals(rst.getBirthdate(), mAssoc.getBirthdate());
		
	}
	
	
	
	public void testCreate() {
		marchantServiceImp.create(1);
		//assertEquals(7, MagicBuilder.getLucky());
	}
	
	
	
	
	public void testUpate() {
		marchantServiceImp.update(1);
		//assertEquals(7, MagicBuilder.getLucky());
	}
	
	

	public void testDelete() {
		marchantServiceImp.delete(1);
		//assertEquals(7, MagicBuilder.getLucky());
	}
	
	
	@Test
	public void testGetAllMarchants() {
		marchantServiceImp.getAllMarchants();
		Mockito.when(marchantDao.getAllMarchants()).thenReturn(mListGetAll);
		List<Marchant> rst = marchantServiceImp.getAllMarchants();
		assertEquals(rst.get(0).getName(), mGet.getName());
		assertEquals(rst.get(0).getLastname(), mGet.getLastname());


		assertEquals(rst.get(1).getName(), mGet1.getName());
		assertEquals(rst.get(1).getLastname(), mGet1.getLastname());
	
		
	}
	
}
