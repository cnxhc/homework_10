package com.xhc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xhc.dao.IAdminDAO;
import com.xhc.model.Admin;

public class AdminDAO implements IAdminDAO {
	private SessionFactory sessionFactory;


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Admin checkAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query=session.createQuery("from Admin where username='"+admin.getUsername()+"'and password='"+admin.getPassword()+"'");
		Admin admin1=new Admin();
		List list=query.list();
		ts.commit();
		session.close();
		if(list.size()!=0){
			admin1=(Admin) list.get(0);
		}
		return admin1;
	}

}
