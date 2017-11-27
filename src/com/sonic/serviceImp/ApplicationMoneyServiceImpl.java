package com.sonic.serviceImp;

import java.util.List;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Application;
import com.sonic.service.ApplicationMoneyService;

public class ApplicationMoneyServiceImpl implements ApplicationMoneyService{
	private GenericDao genericDao;

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDaoImp) {
		this.genericDao = genericDaoImp;
	}
	@Override
	public List<Application> getMoneyApplicationList(String page, String rows) {
		// TODO Auto-generated method stub
		
				int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
						: page);// 第几页
				int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
						: rows);// 每页多少行

				return genericDao.query("from Application where applicationCategory ='money'", currentpage, pagesize);
	}

	@Override
	public int getMoneyApplicationTotal() {
		// TODO Auto-generated method stub
		return genericDao.countQuery("from Application where applicationCategory ='money'");
	}

	@Override
	public List<Application> getMoneyApplicationSearchList(String hql,
			String page, String rows) {
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query(hql, currentpage, pagesize);
	}

	@Override
	public int getMoneyApplicationSearchedTotal(String hql) {
		// TODO Auto-generated method stub
		return genericDao.countQuery(hql);
	}

	@Override
	public void deleteMoneyApplicationById(int applicationId) {
		// TODO Auto-generated method stub
		genericDao.delById(Application.class, applicationId);
	}

}
