package com.xhc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xhc.dao.IFlowerDAO;
import com.xhc.model.Goods;

public class FlowerDAO implements IFlowerDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xhc.dao.IFlowerDAO#getNewFlower() 倒叙获取鲜花，并分页显示
	 */
	@Override
	public List<Goods> getNewFlower() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Goods order by id desc");
		query.setFirstResult(0);
		query.setMaxResults(4);
		List<Goods> goods = query.list();
		ts.commit();
		session.close();
		return goods;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xhc.dao.IFlowerDAO#getFlowerByCatalogidPaging(int, int, int)
	 * 通过鲜花分类号，分页显示鲜花
	 */
	@Override
	public List<Goods> getFlowerByCatalogidPaging(int catalogId, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Goods where catalogId=" + catalogId);
		int startRow = (currentPage - 1) * pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List<Goods> goods = query.list();
		ts.commit();
		session.close();
		return goods;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xhc.dao.IFlowerDAO#getTotalByCatalog(int) 统计同一个鲜花分类号的所有记录数
	 */
	@Override
	public int getTotalByCatalog(int catalogId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Goods where catalogId=" + catalogId);
		List goods = query.list();
		ts.commit();
		session.close();
		return goods.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xhc.dao.IFlowerDAO#getGoodsById(int) 通过id获取鲜花
	 */
	@Override
	public Goods getGoodsById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Goods where id=" + id);
		List goods = query.list();
		ts.commit();
		session.close();
		return (Goods) goods.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xhc.dao.IFlowerDAO#addOrUpdateGood(com.xhc.model.Goods) 修改和添加鲜花
	 */
	@Override
	public boolean addOrUpdateGood(Goods goods) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.saveOrUpdate(goods);
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xhc.dao.IFlowerDAO#getAllGoods(int, int) 分页显示所有鲜花
	 */
	@Override
	public List getAllGoods(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Goods order by id desc");
		int startRow = (currentPage - 1) * pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List goods = query.list();
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		return goods;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xhc.dao.IFlowerDAO#getTotalNum() 统计所有鲜花的记录
	 */
	@Override
	public int getTotalNum() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("select count(id) from Goods");
		List list = query.list();
		ts.commit();
		session.close();
		return Integer.valueOf(list.get(0) + "");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xhc.dao.IFlowerDAO#deleteGoodsById(int) 根据id删除鲜花
	 */
	@Override
	public boolean deleteGoodsById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Goods where id=" + id);
		// Query query=session.createQuery("delete from Goods where id="+id);
		List goods = query.list();
		session.delete((Goods) goods.get(0));
		ts.commit();
		session.close();
		return true;
	}
}
