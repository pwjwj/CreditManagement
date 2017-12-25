package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Admin;
import com.sonic.pojo.StuBase;

public interface AdminSuService {
	public List<Admin> getAdminBaseList(String hql,String page,String rows);
	public int getAdminTotal();
	public List<Admin> getAdminSearchList(String hql, String page, String rows);
	public int getSearchedTotal(String hql);
	public void saveStuBaseOrUpdate(Admin admin);
	
	public void deleteAdmin(int adminId);
	
	public Admin getUser(String userName);
}
