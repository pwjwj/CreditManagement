package com.sonic.service;

import java.util.List;

import com.sonic.pojo.StuBase;

public interface CreditActivityService {
	//��ȡ���û��Ϣ
	public List<StuBase> getStuCreditActivityList(String page,String rows);
	public int getCreditActivityTotal();
}
