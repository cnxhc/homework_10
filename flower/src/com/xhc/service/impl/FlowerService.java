package com.xhc.service.impl;

import java.util.List;

import com.xhc.dao.IFlowerDAO;
import com.xhc.model.Goods;
import com.xhc.service.IFlowerService;

public class FlowerService implements IFlowerService {
	private IFlowerDAO flowerDAO;
	
	public IFlowerDAO getFlowerDAO() {
		return flowerDAO;
	}

	public void setFlowerDAO(IFlowerDAO flowerDAO) {
		this.flowerDAO = flowerDAO;
	}

	@Override
	public List<Goods> getNewFlower() {
		// TODO Auto-generated method stub
		return flowerDAO.getNewFlower();
	}

	@Override
	public List<Goods> getFlowerByCatalogidPaging(int catalogId, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return flowerDAO.getFlowerByCatalogidPaging(catalogId, currentPage, pageSize);
	}

	@Override
	public int getTotalByCatalog(int catalogId) {
		// TODO Auto-generated method stub
		return flowerDAO.getTotalByCatalog(catalogId);
	}

	@Override
	public Goods getGoodsById(int id) {
		// TODO Auto-generated method stub
		return flowerDAO.getGoodsById(id);
	}

	@Override
	public boolean addOrUpdateGood(Goods goods) {
		// TODO Auto-generated method stub
		return flowerDAO.addOrUpdateGood(goods);
	}

	@Override
	public List getAllGoods(int currentPage,int pageSize) {
		// TODO Auto-generated method stub
		return flowerDAO.getAllGoods(currentPage, pageSize);
	}

	@Override
	public int getTotalNum() {
		// TODO Auto-generated method stub
		return flowerDAO.getTotalNum();
	}

	@Override
	public boolean deleteGoodsById(int id) {
		// TODO Auto-generated method stub
		return flowerDAO.deleteGoodsById(id);
	}

}
