package com.smileetpay.service.soap;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.smileetpay.model.Marchant;

@WebService(name = "IMarchantService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)

public interface IMarchantService {
	
	Boolean create(Marchant marchant);

	Boolean deleteMarchant(int id);
}
