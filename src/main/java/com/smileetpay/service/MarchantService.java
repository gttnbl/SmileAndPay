package com.smileetpay.service;

import java.util.List;

import com.smileetpay.model.Marchant;

public interface MarchantService {

	Boolean update(Marchant marchant);

	public Marchant getMarchantById(int id);

	Boolean create(Marchant marchant);

	Boolean delete(int id);

	List<Marchant> getAllMarchants();
}
