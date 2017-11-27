package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.StuBase;

public interface CreditActivityService {
	//获取信用活动信息
	public List<Creditactivity> getStuCreditActivityList(String page,String rows);
	public int getCreditActivityTotal();
	public void saveCreditActivityOrUpdate(Creditactivity ca);
}
