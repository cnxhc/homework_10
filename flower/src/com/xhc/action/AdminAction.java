package com.xhc.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xhc.model.Admin;
import com.xhc.model.Users;
import com.xhc.service.IAdminService;

public class AdminAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	private Admin admin;
	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	/**
	 * 校验登录
	 * @return
	 */
	public String checkAdmin(){
		Map session=ActionContext.getContext().getSession();
		Admin admin1=adminService.checkAdmin(admin);
		if(admin1!=null&&admin1.getUsername()!=null&&admin1.getPassword()!=null){
			session.put("admin", admin1);
			return SUCCESS;
		}
		return ERROR;
	}
	/**
	 * 用户退出
	 * @return
	 */
	public String adminlogOut(){
		Map session=ActionContext.getContext().getSession();
		session.remove(admin);
		return SUCCESS;
	}
}
