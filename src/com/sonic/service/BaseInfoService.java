package com.sonic.service;

import java.util.List;


import com.sonic.pojo.Admin;
import com.sonic.pojo.AdminSu;
import com.sonic.pojo.StuBase;


public interface BaseInfoService {
	//在基本信息管理里面获取对应学生的信息list
	public List<StuBase> getStuBaseList(String hql,String page,String rows);
	public List<StuBase> getStuBaseList(String hql);
	public int getUserTotal();
	
	public List<Admin> getAdminSelfBaseList(String name);
	
	
	/*//获取通知信息
	public List<Info> getAllInfoList(String page,String rows);
	public int getInfoTotal();*/
	
	/*//获取物资信息
	public List<Info> getAllGoodsList(String page,String rows);
	public int getGoodsTotal();*/
	
	//public List<StuBase> getUserList(String page,String rows);
	//public int getUserTotalByAuthority(String Authority);
	public Admin getTUser(String id);
	public AdminSu getSUser(String id);
	public StuBase getUser(String userId);
	//public void saveUserOrUpdate(StuBase user);
	//public void delete(List<StuBase> list);
	
	public List<StuBase> getStuSearchList(String hql, String page, String rows);
	public int getSearchedTotal(String hql);
	
	public Admin getUserById(int adminId);
	public void saveStuBaseOrUpdate(StuBase stu);
	
	public void deleteStu(int newsId);
	
	public void saveAdminOrUpdate(Admin admin);
}
