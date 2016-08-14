package com.xhc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xhc.dao.ICatalogDAO;

public class CatalogDAO implements ICatalogDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 根据鲜花分类查询
	@Override
	public List getAllCatalogs() {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Catalog");
		List catalogs=query.list();
		ts.commit();
		session.close();
		return catalogs;
	}

}
