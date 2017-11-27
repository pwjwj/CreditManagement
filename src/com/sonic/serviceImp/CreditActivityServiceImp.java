package com.sonic.serviceImp;

import java.util.List;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.StuBase;
import com.sonic.service.CreditActivityService;

public class CreditActivityServiceImp implements CreditActivityService{
	private GenericDao genericDao;
	public GenericDao getGenericDao() {
		return genericDao;
	}
 
	public void setGenericDao(GenericDao genericDaoImp) {
		this.genericDao = genericDaoImp;
	}
	@Override
	public List<Creditactivity> getStuCreditActivityList(String page, String rows) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query("from Creditactivity", currentpage, pagesize);
	}

	@Override
	public int getCreditActivityTotal() {
		// TODO Auto-generated method stub
		return genericDao.countQuery("from Creditactivity");
	}

	@Override
	public void saveCreditActivityOrUpdate(Creditactivity ca) {
		// TODO Auto-generated method stub
		genericDao.saveOrUpdate(ca);
	}

}
