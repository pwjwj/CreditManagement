package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Info;

public interface InfoService {
	//��ȡ֪ͨ��Ϣ
	public List<Info> getAllInfoList(String page,String rows);
	public int getInfoTotal();
}
