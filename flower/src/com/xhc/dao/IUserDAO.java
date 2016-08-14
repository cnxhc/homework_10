package com.xhc.dao;

import java.util.List;

import com.xhc.model.Users;

public interface IUserDAO {
	// 用户注册
	public boolean addOrUpdateUser(Users user);
	//修改用户信息
	public boolean updateUser(Users user);
	// 校验用户登录
	public Users checkUser(Users user);

	// 根据id获取用户
	public Users getUsersById(int id);

	// 分页查询所有用户
	public List<Users> getAllUser(int currentPage, int pageSize);

	// 统计用户总数
	public int getTotalNum();

	// 删除用户
	public boolean deleteUsersById(int id);
}
