package com.smileetpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smileetpay.dao.MarchantDao;
import com.smileetpay.model.Marchant;

@Service
public class MarchantServiceImpl implements MarchantService {

	@Autowired
	private MarchantDao marchantDao;

	@Override
	public Boolean update(Marchant marchant) {
		// TODO Auto-generated method stub
		return marchantDao.update(marchant);

	}

	@Override
	public Marchant getMarchantById(int id) {
		// TODO Auto-generated method stub
		return marchantDao.getMarchantById(id);
	}

	@Override
	public Boolean create(Marchant marchant) {
		// TODO Auto-generated method stub
		return marchantDao.create(marchant);
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		return marchantDao.deleteMarchant(id);
	}

	@Override
	public List<Marchant> getAllMarchants() {
		// TODO Auto-generated method stub
		List<Marchant> marchants = marchantDao.getAllMarchants();
		return marchants;
	}

}
