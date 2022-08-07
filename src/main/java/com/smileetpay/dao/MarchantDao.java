package com.smileetpay.dao;

import java.util.List;

import com.smileetpay.model.Marchant;

public interface MarchantDao {

	
	Boolean create(Marchant marchant);
	Boolean update(Marchant marchant);
	Boolean deleteMarchant(int id);
	public Marchant getMarchantById(int id);
	List<Marchant> getAllMarchants();

}
