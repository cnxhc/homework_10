package com.xhc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xhc.dao.IUserDAO;
import com.xhc.model.Users;

public class UserDAO implements IUserDAO {
	private SessionFactory sessionFactory;


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addOrUpdateUser(Users user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.saveOrUpdate(user);
		ts.commit();
		session.close();
		return true;
	}

	@Override
	public Users checkUser(Users user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query=session.createQuery("from Users where userName='"+user.getUserName()+"'and password='"+user.getPassword()+"'");
		Users user1=new Users();
		List list=query.list();
		ts.commit();
		session.close();
		if(list.size()!=0){
			user1=(Users) list.get(0);
		}
		return user1;
		
	}

	@Override
	public List<Users> getAllUser(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query=session.createQuery("from Users");
		int startRow=(currentPage-1)*pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List users= query.list();
		session.flush();
		session.clear();
		session.close();
		return users;
	}

	@Override
	public int getTotalNum() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query=session.createQuery("select count(id) from Users");
		List list=query.list();
		ts.commit();
		session.close();
		return Integer.valueOf(list.get(0)+"");
	}

	@Override
	public boolean deleteUsersById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Users where id="+id);
		//Query query=session.createQuery("delete from users where id="+id);
		List users=query.list();
		session.delete((Users)users.get(0));
		ts.commit();
		session.close();
		return true;
	}

	@Override
	public Users getUsersById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Users where id="+id);
		Users user=(Users) query.list().get(0);
		ts.commit();
		session.close();
		return user;
	}
	/*
	 * (non-Javadoc)
	 * @see com.xhc.dao.IUserDAO#updateUser(com.xhc.model.Users)
	 * 修改用户信息
	 */
	@Override
	public boolean updateUser(Users user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		session.update(user);
		ts.commit();
		session.close();
		return true;
	}

}
