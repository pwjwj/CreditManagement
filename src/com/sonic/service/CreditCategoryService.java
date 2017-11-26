package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Creditcategory;

public interface CreditCategoryService {
	//获取信用类目信息
		public List<Creditcategory> getCreditCategoryList(String page,String rows);
		public int getCreditCategoryTotal();
}
