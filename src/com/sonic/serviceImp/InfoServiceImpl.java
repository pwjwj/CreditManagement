package com.sonic.serviceImp;

import java.util.List;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Info;
import com.sonic.service.InfoService;

public class InfoServiceImpl implements InfoService{
	private GenericDao genericDao;
	public GenericDao getGenericDao() {
		return genericDao;
	}
 
	public void setGenericDao(GenericDao genericDaoImp) {
		this.genericDao = genericDaoImp;
	}
	@Override
	public List<Info> getAllInfoList(String page, String rows) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query("from Info", currentpage, pagesize);
	}

	@Override
	public int getInfoTotal() {
		// TODO Auto-generated method stub
		return genericDao.countQuery("from Info");
	}


}
