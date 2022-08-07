package com.smileetpay.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smileetpay.model.Marchant;

@Repository
@Transactional
public class MarchantDaoImpl implements MarchantDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Boolean update(Marchant marchant) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(marchant);
		return Boolean.TRUE;
	}

	@Override
	public Marchant getMarchantById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Marchant marchant = (Marchant) session.get(Marchant.class, new Integer(id));
		return marchant;
	}

	@Override
	public Boolean create(Marchant marchant) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(marchant);
		return Boolean.TRUE;
	}

	@Override
	public Boolean deleteMarchant(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Marchant p = (Marchant) session.load(Marchant.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		return Boolean.TRUE;
	}

	@Override
	public List<Marchant> getAllMarchants() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Marchant> marchantList = session.createQuery("from Marchant").list();
		return marchantList;
	}

}
