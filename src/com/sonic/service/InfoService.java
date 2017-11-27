package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Creditcategory;
import com.sonic.pojo.Info;

public interface InfoService {
	//获取通知信息
	public List<Info> getAllInfoList(String page,String rows);
	public int getInfoTotal();
	
	public void saveInfoOrUpdate(Info info);
	
	public void deleteInfoById(int infoId);
	
	
	public List<Info> getInfoSearchList(String hql, String page, String rows);
	public int getInfoSearchedTotal(String hql);
	
	
}
