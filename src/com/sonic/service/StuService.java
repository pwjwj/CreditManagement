package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Admin;
import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.StuBase;

public interface StuService {
	public List<StuBase> getStuSelfBaseList(String name);
	public List<Creditactivity> getStuSelfCreditActivityList(String page,String rows,String name);
	public int getStuSelfCreditActivityTotal(String hql);
	public List<Creditactivity> getStuCreditActivitySearchList(String hql, String page, String rows);
	public int getSearchedTotal(String hql);
	public StuBase getUser(String userName);
}
