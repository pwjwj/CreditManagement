package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Info;

public interface InfoService {
	//获取通知信息
	public List<Info> getAllInfoList(String page,String rows);
	public int getInfoTotal();
}
