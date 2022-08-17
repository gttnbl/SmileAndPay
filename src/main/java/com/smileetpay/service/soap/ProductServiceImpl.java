package com.smileetpay.service.soap;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.smileetpay.dao.ProductDao;
import com.smileetpay.model.Product;

@Service("productService")
@WebService(serviceName = "ProductService", endpointInterface = "com.smileetpay.service.soap.IProductService", portName = "ProductServicePort", name = "ProductServiceImpl")

public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductDao productDao;

	@SuppressWarnings("resource")
	@Override
	public Boolean create(Product p) {
		// TODO Auto-generated method stub
		// local variables
		ApplicationContext applicationContext = null;

		Boolean ret = Boolean.FALSE;
		// loading spring context xml from classapth

		applicationContext = new ClassPathXmlApplicationContext("com/smileetpay/conf/spring-jax-ws.xml");
		productDao = applicationContext.getBean(ProductDao.class);

		try {

			// invoke dao to get values
			ret = productDao.create(p);

			// set values in the return/response type

		} catch (Exception ex) {
			// dummy setting for business exception, we can set more meaningful error
			// depending on the business requirements

		} finally {
			// close resources, if any

		}
		return ret;
	}

	@SuppressWarnings("resource")
	@Override
	public Boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		// local variables
		ApplicationContext applicationContext = null;

		Boolean ret = Boolean.FALSE;
		// loading spring context xml from classapth

		applicationContext = new ClassPathXmlApplicationContext("com/smileetpay/conf/spring-jax-ws.xml");
		productDao = applicationContext.getBean(ProductDao.class);

		try {

			// invoke dao to get values
			ret = productDao.delete(id);

			// set values in the return/response type

		} catch (Exception ex) {
			// dummy setting for business exception, we can set more meaningful error
			// depending on the business requirements

		} finally {
			// close resources, if any

		}
		return ret;
	}

}
