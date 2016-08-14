package com.xhc.tool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.xhc.model.Ordersdetails;

public class Cart {
	private Map items;

	public Map getItems() {
		return items;
	}

	public void setItems(Map items) {
		this.items = items;
	}

	public Cart() {
		if (items == null) {
			items = new HashMap<String, Ordersdetails>();
		}
	}

	public void addGoods(String goodsName, Ordersdetails ordersDetails) {
		if (items.containsKey(goodsName)) {
			Ordersdetails _ordersDetails = (Ordersdetails) items.get(goodsName);
			ordersDetails.setNum(_ordersDetails.getNum());
			items.put(goodsName, ordersDetails);
		} else {
			items.put(goodsName, ordersDetails);
		}
	}

	public void updateCart(String goodsName, int num) {
		Ordersdetails ordersdetails = (Ordersdetails) items.get(goodsName);
		ordersdetails.setNum(num);
		items.put(goodsName, ordersdetails);
	}
	public double getTotalPrice() {
		double totalPrice=0.0;
		for (Iterator it = items.values().iterator(); it.hasNext();) {
			Ordersdetails ordersdetails = (Ordersdetails) it.next();
			totalPrice += ordersdetails.getPrice() * ordersdetails.getNum();
		}
		return totalPrice;
	}
	public int getTotalNum(){
		int totalNum=0;
		for (Iterator it = items.values().iterator(); it.hasNext();) {
			Ordersdetails ordersdetails = (Ordersdetails) it.next();
			totalNum += ordersdetails.getNum();
		}
		return totalNum;
	}
}
