package com.xhc.dao;

import java.util.List;

import com.xhc.model.Goods;

public interface IFlowerDAO {
	// 获取新入库的鲜花
	public List<Goods> getNewFlower();

	// 根据分类号catalogId分页显示鲜花
	public List<Goods> getFlowerByCatalogidPaging(int catalogId,int currentPage,int pageSize);

	// 获取分类号catalogId总的鲜花数量
	public int getTotalByCatalog(int catalogId);
	//根据id获取鲜花
	public Goods getGoodsById(int id);
	//添加鲜花
	public boolean addOrUpdateGood(Goods goods);
	//获取鲜花总记录数
	public int getTotalNum();
	//分页获取所有鲜花
	public List<Goods> getAllGoods(int currentPage,int pageSize);
	//删除鲜花
	public boolean deleteGoodsById(int id);
}
