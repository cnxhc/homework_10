package com.xhc.service.impl;

import com.xhc.dao.IOrderDAO;
import com.xhc.model.Orders;
import com.xhc.service.IOrderService;

public class OrderService implements IOrderService {
	private IOrderDAO orderDAO;
	
	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public Orders saveOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderDAO.saveOrder(order);
	}

}
