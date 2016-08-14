package com.xhc.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xhc.model.Orders;
import com.xhc.model.Ordersdetails;
import com.xhc.model.Users;
import com.xhc.service.IOrderService;
import com.xhc.tool.Cart;

public class OrderAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IOrderService orderService;

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	/**
	 * 提交订单
	 * @return
	 * @throws Exception
	 */
	public String checkOut() throws Exception {
		Map session = (Map) ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		Users user = (Users) session.get("user");
		if (user == null) {
			return ERROR;
		}
		Orders order = new Orders();
		order.setCreateTime(new Timestamp(new Date().getTime()));
		order.setUsers(user);
		
		int num=cart.getTotalNum();
		double sum=cart.getTotalPrice();
		order.setNum(num);
		order.setSum(sum);
		for (Iterator iter = cart.getItems().values().iterator(); iter.hasNext();) {
			Ordersdetails od = (Ordersdetails) iter.next();
			order.getOrdersdetailses().add(od);
			od.setOrders(order);
		}
		order.setUsers(user);
		orderService.saveOrder(order);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("order", order);
		session.remove("cart");
		return SUCCESS;
	}
}
