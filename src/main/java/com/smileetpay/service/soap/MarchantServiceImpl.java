package com.smileetpay.service.soap;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.smileetpay.dao.MarchantDao;
import com.smileetpay.model.Marchant;

@Service("marchantService")
@WebService(serviceName = "MarchantService", endpointInterface = "com.smileetpay.service.soap.IMarchantService",  portName = "MarchatServicePort", name = "MarchantServiceImpl")

public class MarchantServiceImpl implements IMarchantService {

	@Autowired
	private MarchantDao marchantDao;

	@SuppressWarnings("resource")
	@Override
	public Boolean create(Marchant marchant) {
		// local variables
		ApplicationContext applicationContext = null;

		Boolean ret = Boolean.FALSE;
		// loading spring context xml from classapth

		applicationContext = new ClassPathXmlApplicationContext("com/smileetpay/conf/spring-jax-ws.xml");
		marchantDao = applicationContext.getBean(MarchantDao.class);

		try {

			// invoke dao to get values
			ret = marchantDao.create(marchant);

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
	public Boolean deleteMarchant(int id) {
		// TODO Auto-generated method stub
		// local variables
				ApplicationContext applicationContext = null;

				Boolean ret = Boolean.FALSE;
				// loading spring context xml from classapth

				applicationContext = new ClassPathXmlApplicationContext("com/smileetpay/conf/spring-jax-ws.xml");
				marchantDao = applicationContext.getBean(MarchantDao.class);

				try {

					// invoke dao to get values
					ret = marchantDao.deleteMarchant(id);

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
