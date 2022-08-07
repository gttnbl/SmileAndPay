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
		Boolean rst = Boolean.TRUE;
		Session session = this.sessionFactory.getCurrentSession();
		 try {
			session.update(marchant);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rst =Boolean.FALSE;
		}
		return rst;
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
		Boolean rst = Boolean.TRUE;
		Session session = this.sessionFactory.getCurrentSession();
		 try {
			session.persist(marchant);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rst =Boolean.FALSE;
		}
		return rst;
	}

	@Override
	public Boolean deleteMarchant(int id) {
		// TODO Auto-generated method stub
		Boolean rst = Boolean.TRUE;
		Session session = this.sessionFactory.getCurrentSession();
		Marchant p = (Marchant) session.get(Marchant.class, new Integer(id));

		if (p == null) {
			rst = Boolean.FALSE;

		} else {
			session.delete(p);
		}
		return rst;
	}

	@Override
	public List<Marchant> getAllMarchants() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Marchant> marchantList = session.createQuery("from Marchant").list();
		return marchantList;
	}

}
