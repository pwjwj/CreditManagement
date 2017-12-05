package com.sonic.serviceImp;

import java.util.List;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Application;
import com.sonic.pojo.Info;
import com.sonic.service.ApplicationService;

public class ApplicationServiceImpl implements ApplicationService {
	private GenericDao genericDao;

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDaoImp) {
		this.genericDao = genericDaoImp;
	}

	@Override
	public List<Application> getApplicationList(String hql,String page, String rows) {
		// TODO Auto-generated method stub
		
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query(hql, currentpage, pagesize);
	}

	@Override
	public int getApplicationTotal() {
		// TODO Auto-generated method stub
		return genericDao.countQuery("from Application");
	}

	@Override
	public List<Application> getApplicationSearchList(String hql, String page,
			String rows) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query(hql, currentpage, pagesize);
	}

	@Override
	public int getApplicationSearchedTotal(String hql) {
		// TODO Auto-generated method stub
		return genericDao.countQuery(hql);
	}

	@Override
	public void deleteApplicationById(int applicationId) {
		// TODO Auto-generated method stub
		genericDao.delById(Application.class, applicationId);
	}

	@Override
	public void saveApplicationOrUpdate(Application application) {
		// TODO Auto-generated method stub
		genericDao.saveOrUpdate(application);
	}

}
