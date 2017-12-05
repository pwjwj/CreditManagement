package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Application;

public interface ApplicationGoodsService {
	public List<Application> getGoodsApplicationList(String page,String rows);
	public int getGoodsApplicationTotal();
	
	
	public void saveApplicationOrUpdate(Application application);
	public List<Application> getGoodsApplicationSearchList(String hql, String page, String rows);
	public int getGoodsApplicationSearchedTotal(String hql);
	
	public void deleteGoodsApplicationById(int applicationId);
}
