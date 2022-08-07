package com.smileetpay.service;

import java.util.List;

import com.smileetpay.model.Marchant;

public interface MarchantService {



	void update(Marchant marchant);

	public Marchant getMarchantById(int id);

	void create(Marchant marchant);

	void delete(int id);

	List<Marchant> getAllMarchants();
}
