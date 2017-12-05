package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.Creditcategory;

public interface CreditCategoryService {
	//获取信用类目信息
		public List<Creditcategory> getCreditCategoryList(String hql,String page,String rows);
		public int getCreditCategoryTotal();
		
		
		public Creditcategory getCreditCategory(int activityId);
		public void saveCreditCategoryOrUpdate(Creditcategory cc);
		
		public List<Creditcategory> getCreditCategorySearchList(String hql, String page, String rows);
		public int getCreditCategorySearchedTotal(String hql);
		
		public void deleteCreditCategoryById(int creditCategoryId);
}
