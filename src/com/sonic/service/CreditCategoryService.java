package com.sonic.service;

import java.util.List;

import com.sonic.pojo.Creditcategory;

public interface CreditCategoryService {
	//��ȡ������Ŀ��Ϣ
		public List<Creditcategory> getCreditCategoryList(String page,String rows);
		public int getCreditCategoryTotal();
}
