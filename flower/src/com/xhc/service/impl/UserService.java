package com.xhc.service.impl;

import java.util.List;

import com.xhc.dao.IUserDAO;
import com.xhc.model.Users;
import com.xhc.service.IUserService;

public class UserService implements IUserService {
	private IUserDAO userDAO;
	
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean addOrUpdateUser(Users user) {
		// TODO Auto-generated method stub
		return userDAO.addOrUpdateUser(user);
	}

	@Override
	public Users checkUser(Users user) {
		// TODO Auto-generated method stub
		return userDAO.checkUser(user);
	}

	@Override
	public List<Users> getAllUser(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return userDAO.getAllUser(currentPage, pageSize);
	}

	@Override
	public int getTotalNum() {
		// TODO Auto-generated method stub
		return userDAO.getTotalNum();
	}

	@Override
	public boolean deleteUsersById(int id) {
		// TODO Auto-generated method stub
		return userDAO.deleteUsersById(id);
	}

	@Override
	public Users getUsersById(int id) {
		// TODO Auto-generated method stub
		return userDAO.getUsersById(id);
	}

	@Override
	public boolean updateUser(Users user) {
		// TODO Auto-generated method stub
		return userDAO.updateUser(user);
	}

}
