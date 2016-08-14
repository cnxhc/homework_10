package com.xhc.service.impl;

import java.util.List;

import com.xhc.dao.ICatalogDAO;
import com.xhc.service.ICatalogService;

public class CatalogService implements ICatalogService {
	private ICatalogDAO catalogDAO;

	public ICatalogDAO getCatalogDAO() {
		return catalogDAO;
	}

	public void setCatalogDAO(ICatalogDAO catalogDAO) {
		this.catalogDAO = catalogDAO;
	}

	@Override
	public List getAllCatalogs() {
		// TODO Auto-generated method stub
		return catalogDAO.getAllCatalogs();
	}

}
