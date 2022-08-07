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

import com.smileetpay.model.Marchant;
import com.smileetpay.service.MarchantService;

@RestController
@Transactional
public class MarchantController {

	@Autowired
	MarchantService marchantService;

	// mandatory
	@RequestMapping(value = "/getMarchant/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Marchant getMarchantById(@PathVariable int id) {
		return marchantService.getMarchantById(id);
	}

	@RequestMapping(value = "/updateMarchant", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public void updateMarchant(@RequestBody Marchant marchant) {
		marchantService.update(marchant);
	}

	// optionnal
	@RequestMapping(value = "/addMarchant", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public void addMarchant(@RequestBody Marchant marchant) {
		marchantService.create(marchant);

	}

	@RequestMapping(value = "/deleteMarchant/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void deleteMarchant(@PathVariable("id") int id) {
		marchantService.delete(id);

	}

	// not descipt

	@RequestMapping(value = "/getAllMarchants", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Marchant> getAllMarchants() {
		List<Marchant> listOfMarchants = marchantService.getAllMarchants();
		return listOfMarchants;
	}

}
