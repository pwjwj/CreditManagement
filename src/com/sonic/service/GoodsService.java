package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Info;

public interface GoodsService {
	//��ȡ������Ϣ
	public List<Info> getAllGoodsList(String page,String rows);
	public int getGoodsTotal();
}
