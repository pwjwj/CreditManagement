package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Goods;
import com.sonic.pojo.Info;

public interface GoodsService {
	//获取物资信息
	public List<Info> getAllGoodsList(String hql,String page,String rows);
	public int getGoodsTotal();
	
	
	public List<Goods> getGoodsSearchList(String hql, String page, String rows);
	public int getGoodsSearchedTotal(String hql);
	
	public void saveGoodsOrUpdate(Goods goods);
	
	public void deleteGoodsById(int goodsId);
	
}
