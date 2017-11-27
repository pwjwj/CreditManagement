package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Application;

public interface ApplicationMoneyService {
	public List<Application> getMoneyApplicationList(String page,String rows);
	public int getMoneyApplicationTotal();
	

	public List<Application> getMoneyApplicationSearchList(String hql, String page, String rows);
	public int getMoneyApplicationSearchedTotal(String hql);
	
	public void deleteMoneyApplicationById(int applicationId);
}
