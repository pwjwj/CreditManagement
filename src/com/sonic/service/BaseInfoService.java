package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Application;
import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.Creditcategory;
import com.sonic.pojo.Goods;
import com.sonic.pojo.Info;
import com.sonic.pojo.StuBase;


public interface BaseInfoService {
	//�ڻ�����Ϣ���������ȡ��Ӧѧ������Ϣlist
	public List<StuBase> getStuBaseList(String page,String rows);
	public int getUserTotal();
	
	
	
	
	/*//��ȡ֪ͨ��Ϣ
	public List<Info> getAllInfoList(String page,String rows);
	public int getInfoTotal();*/
	
	/*//��ȡ������Ϣ
	public List<Info> getAllGoodsList(String page,String rows);
	public int getGoodsTotal();*/
	
	//public List<StuBase> getUserList(String page,String rows);
	//public int getUserTotalByAuthority(String Authority);
	public StuBase getUser(String id);
	//public void saveUserOrUpdate(StuBase user);
	//public void delete(List<StuBase> list);
}
