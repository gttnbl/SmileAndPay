package com.smileetpay.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smileetpay.model.Marchant;
import com.smileetpay.model.MarchantProduct;
import com.smileetpay.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Autowired
	MarchantDao marchantDao;

	public MarchantDao getMarchantDao() {
		return marchantDao;
	}

	public void setMarchantDao(MarchantDao marchantDao) {
		this.marchantDao = marchantDao;
	}

	@Override
	public Boolean create(Product product) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(product);
		return Boolean.TRUE;
	}

	@Override
	public Boolean update(Product product) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
		return Boolean.TRUE;
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Boolean rst = Boolean.TRUE;
		Product p = (Product) session.get(Product.class, new Integer(id));
		if (p == null) {
			rst = Boolean.FALSE;

		} else {
			session.delete(p);
		}
		return rst;
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, new Integer(id));
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();

		List<Product> productList = session.createQuery("from Product").list();
		// Hibernate.initialize(productList.get());
		return productList;
	}

	@Override
	public Boolean associateMarchant(Product p, Marchant m) {
		// TODO Auto-generated method stub
		// Session session = this.sessionFactory.getCurrentSession();
		Boolean returnedValue;
		Marchant marchant = marchantDao.getMarchantById(m.getMarchant_id());
		// (Marchant) session.get(Marchant.class, new Integer(m.getMarchant_id()));
		Product product = this.getProductById(p.getProduct_id());
		// (Product) session.get(Product.class, new Integer(p.getProduct_id()));
		// System.out.println(product);
		if (marchant != null && product != null) {

			Transaction tx = null;
			Session session = this.sessionFactory.openSession();

			MarchantProduct marchantProduct = new MarchantProduct();
			marchantProduct.setMarchant(marchant);
			marchantProduct.setProduct(product);

			marchantProduct.setRegisteredDate(new Date());
			p.addMarchantProduct(marchantProduct);
			tx = session.beginTransaction();

			Query query = session.createSQLQuery(
					"INSERT INTO marchant_product (MARCHANT_ID,PRODUCT_ID,REGISTERED_DATE) VALUES (:marchant,:product, :date);");
			query.setParameter("marchant", marchant.getMarchant_id());
			query.setParameter("product", product.getProduct_id());
			query.setParameter("date", new Date());

			int result = query.executeUpdate();
			System.out.println(result);
			tx.commit();
			session.close();
			returnedValue = Boolean.TRUE;
		} else {
			returnedValue = Boolean.FALSE;
		}
		return returnedValue;

	}

}
