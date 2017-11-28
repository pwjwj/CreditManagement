package com.sonic.serviceImp;

import java.util.List;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Application;
import com.sonic.service.ApplicationGoodsService;

public class ApplicationGoodsServiceImpl implements ApplicationGoodsService{
	private GenericDao genericDao;

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDaoImp) {
		this.genericDao = genericDaoImp;
	}
	@Override
	public List<Application> getGoodsApplicationList(String page, String rows) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query(
				"from Application where applicationCategory ='goods'",
				currentpage, pagesize);
	}

	@Override
	public int getGoodsApplicationTotal() {
		// TODO Auto-generated method stub
		return genericDao
				.countQuery("from Application where applicationCategory ='goods'");
	}

	@Override
	public List<Application> getGoodsApplicationSearchList(String hql,
			String page, String rows) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query(hql, currentpage, pagesize);
	}

	@Override
	public int getGoodsApplicationSearchedTotal(String hql) {
		// TODO Auto-generated method stub
		return genericDao.countQuery(hql);
	}

	@Override
	public void deleteGoodsApplicationById(int applicationId) {
		// TODO Auto-generated method stub
		genericDao.delById(Application.class, applicationId);
	}

}
