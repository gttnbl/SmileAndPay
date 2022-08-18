package com.smileetpay.service.soap;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.smileetpay.model.Marchant;
import com.smileetpay.model.Product;
import com.smileetpay.service.soap.dto.AssociateDto;

@WebService(name = "IMarchantService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface IProductService {
	Boolean create(Product p);

	Boolean deleteProduct(int id);
	
	Boolean associateMarchant(AssociateDto a);
}
