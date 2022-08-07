package com.smileetpay.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.smileetpay.dao.MarchantDao;
import com.smileetpay.model.Marchant;

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

		// mAssoc.setBirthdate(new Date("1980-11-11"));
	}

	@Test
	public void testGetMarchantById() {
		marchantServiceImp.getMarchantById(1);
		Mockito.when(marchantDao.getMarchantById(Mockito.anyInt())).thenReturn(mGet);
		Marchant rst = marchantServiceImp.getMarchantById(1);
		assertEquals(rst.getName(), mGet.getName());
		assertEquals(rst.getLastname(), mGet.getLastname());
		// assertEquals(rst.getBirthdate(), mAssoc.getBirthdate());

	}

	@Test
	public void testCreate() {
		Mockito.when(marchantDao.create(Mockito.any(Marchant.class))).thenReturn(Boolean.TRUE);
		Boolean rst = marchantServiceImp.create(mGet);
		assertTrue(rst);
	}

	@Test
	public void testUpate() {

		Mockito.when(marchantDao.update(Mockito.any(Marchant.class))).thenReturn(Boolean.TRUE);
		Boolean rst = marchantServiceImp.update(mGet);
		assertTrue(rst);
	}

	@Test
	public void testDelete() {
		Mockito.when(marchantDao.deleteMarchant(Mockito.anyInt())).thenReturn(Boolean.TRUE);
		Boolean rst = marchantServiceImp.delete(1);
		assertTrue(rst);
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
