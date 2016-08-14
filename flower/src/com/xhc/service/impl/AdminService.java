package com.xhc.service.impl;

import com.xhc.dao.IAdminDAO;
import com.xhc.model.Admin;
import com.xhc.service.IAdminService;

public class AdminService implements IAdminService {
	private IAdminDAO adminDAO;
	
	public IAdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(IAdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public Admin checkAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDAO.checkAdmin(admin);
	}

}
