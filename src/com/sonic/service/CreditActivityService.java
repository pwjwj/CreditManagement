package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.StuBase;

public interface CreditActivityService {
	//��ȡ���û��Ϣ
	public List<Object> getStuCreditActivityList(String page,String rows);
	public int getCreditActivityTotal();
	public void saveCreditActivityOrUpdate(Creditactivity ca);
	public List<Creditactivity> getCreditActivitySearchList(String hql, String page, String rows);
	public int getCreditActivitySearchedTotal(String hql);
	public void deleteCreditActivity(int creditActivityId);
	
	public void saveCreditactivityBaseOrUpdate(Creditactivity ca);
	public Creditactivity getCreditActivity(int activityId);
}
