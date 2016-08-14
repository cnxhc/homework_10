package com.xhc.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xhc.model.Users;
import com.xhc.service.IUserService;
import com.xhc.util.Pager;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IUserService userService;
	private Users user;
	// 当前页码
	private int currentPage = 1;
	// 用户id
	private int id;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * 注册用户
	 */
	public String addOrUpdateUser() {
		Map session = (Map) ActionContext.getContext().getSession();
		if (user != null && user.getUserName().trim() != null && user.getPassword() != null
				&& user.getRealName() != null && user.getAddress() != null && user.getEmail() != null) {
			if (userService.addOrUpdateUser(user)) {
				user = null;
				return SUCCESS;
			}
		}
		System.out.println(user.getUserName());
		user = null;
		return ERROR;
	}

	/*
	 * 校验用户登录
	 */
	public String checkUser() {
		Map session = ActionContext.getContext().getSession();
		Users user1 = userService.checkUser(user);
		if (user1 != null&&user1.getId()!=null&&user1.getUserName()!=null&&user1.getPassword()!=null) {
			System.out.println(user1!=null);
			System.out.println(user1.getUserName());
			System.out.println(user1.getId());
			session.put("user", user1);
			return SUCCESS;
		}
		return ERROR;
	}
	//更新用户信息
	public String updateUser() {
		Map session = (Map) ActionContext.getContext().getSession();
		if (user != null && user.getUserName().trim() != null && user.getPassword() != null
				&& user.getRealName() != null && user.getAddress() != null && user.getEmail() != null) {
			if (userService.updateUser(user)) {
				user = null;
				return SUCCESS;
			}
		}
		System.out.println(user.getUserName());
		user = null;
		return ERROR;
	}

	/*
	 * 用户注销
	 */
	public String logOut() {
		Map session = ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;
	}

	// 分页查询所有用户
	public String browseAllUser() {
		int totalSize = userService.getTotalNum();
		Pager page = new Pager(currentPage, totalSize);
		List users = userService.getAllUser(currentPage, page.getPageSize());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("users", users);
		request.put("page", page);
		return SUCCESS;
	}

	// 显示一个用户，用于修改该用户信息
	public String displayOneUser() {
		Users modifyUsers = userService.getUsersById(id);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("user", modifyUsers);
		return SUCCESS;
	}

	// 修改该用户信息
	public String modifyUser() {
		Users modifyUsers = userService.getUsersById(id);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("user", modifyUsers);
		return SUCCESS;
	}

	/*
	 * 删除鲜花
	 */
	public String deleteOneUser() throws Exception {
		userService.deleteUsersById(id);
		return SUCCESS;

	}
}
