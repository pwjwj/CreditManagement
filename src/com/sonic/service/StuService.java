package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Admin;
import com.sonic.pojo.Application;
import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.Info;
import com.sonic.pojo.StuBase;

public interface StuService {
	public List<StuBase> getStuSelfBaseList(String name);
	public List<Creditactivity> getStuSelfCreditActivityList(String page,String rows,String name);
	public int getStuSelfCreditActivityTotal(String hql);
	public List<Creditactivity> getStuCreditActivitySearchList(String hql, String page, String rows);
	public int getSearchedTotal(String hql);
	public StuBase getUser(String userName);
	
	public StuBase getStuByNumber(int currentStuNumber);
	
	public void saveStuBaseOrUpdate(StuBase stuBase);
	public List<Info> getAllInfoList(String page,String rows);
	public int getInfoTotal();
	
	
	public List<Info> getInfoSearchList(String hql, String page, String rows);
	public int getInfoSearchedTotal(String hql);
	
	
	public List<Application> getAllApplicationsList(String page,String rows, String name, int actualNumber);
	public int getApplicationsTotal(String name, int actualNumber);
	
	public void saveApplocationSelfOrUpdate(Application application);
	
}
