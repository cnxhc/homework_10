package com.xhc.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xhc.model.Goods;
import com.xhc.model.Ordersdetails;
import com.xhc.service.IFlowerService;
import com.xhc.tool.Cart;

public class ShoppingAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private int num;
	private String goodsName;
	private int id;
	private IFlowerService flowerService;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public IFlowerService getFlowerService() {
		return flowerService;
	}
	public void setFlowerService(IFlowerService flowerService) {
		this.flowerService = flowerService;
	}

	/**
	 * 添加商品到购物车
	 * @return
	 */
	public String addToCart(){
		Goods good=flowerService.getGoodsById(id);
		Ordersdetails od=new Ordersdetails();
		od.setGoodsName(good.getGoodsName());
		od.setNum(num);
		System.out.println(num);
		od.setPrice(good.getPrice());
		System.out.println(good.getPrice());
		System.out.println(good.getGoodsName());
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart) session.get("cart");
		if(cart==null)
			cart=new Cart();
		cart.addGoods(good.getGoodsName(), od);
		session.put("cart",cart);
		return SUCCESS;
	}
	/**
	 * 更新购物车
	 * @return
	 */
	public String updateCart(){
		Map session=(Map) ActionContext.getContext().getSession();

		Cart cart=(Cart) session.get("cart");
		cart.updateCart(goodsName, num);
		session.put("cart",cart);
		return SUCCESS;
	}
	/**
	 * 核实订单
	 * @return
	 */
	public String checkOut(){
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart) session.get("cart");
		cart.updateCart(goodsName, num);
		session.put("cart", cart);
		return SUCCESS;
	}
}
