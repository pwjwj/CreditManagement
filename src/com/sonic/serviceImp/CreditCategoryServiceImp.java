package com.sonic.serviceImp;

import java.util.List;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Creditcategory;
import com.sonic.service.CreditCategoryService;

public class CreditCategoryServiceImp implements CreditCategoryService{
	private GenericDao genericDao;
	public GenericDao getGenericDao() {
		return genericDao;
	}
 
	public void setGenericDao(GenericDao genericDaoImp) {
		this.genericDao = genericDaoImp;
	}
	@Override
	public List<Creditcategory> getCreditCategoryList(String page, String rows) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query("from Creditcategory", currentpage, pagesize);
	}

	@Override
	public int getCreditCategoryTotal() {
		// TODO Auto-generated method stub
		return genericDao.countQuery("from Creditcategory");
	}

}
