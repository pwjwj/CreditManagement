package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Application;
import com.sonic.pojo.Info;

public interface ApplicationService {
	public List<Application> getApplicationList(String page,String rows);
	public int getApplicationTotal();
	

	public List<Application> getApplicationSearchList(String hql, String page, String rows);
	public int getApplicationSearchedTotal(String hql);
	
	public void deleteApplicationById(int applicationId);
}
