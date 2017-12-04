package com.sonic.serviceImp;

import java.util.List;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Creditcategory;
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
		System.out.println(genericDao.countQuery("from Info"));
		return genericDao.countQuery("from Info");
	}

	@Override
	public void saveInfoOrUpdate(Info info) {
		// TODO Auto-generated method stub
		genericDao.saveOrUpdate(info);
	}

	@Override
	public void deleteInfoById(int infoId) {
		// TODO Auto-generated method stub
		genericDao.delById(Info.class, infoId);
	}

	@Override
	public List<Info> getInfoSearchList(String hql, String page,
			String rows) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query(hql, currentpage, pagesize);
	}

	@Override
	public int getInfoSearchedTotal(String hql) {
		// TODO Auto-generated method stub
		return genericDao.countQuery(hql);
	}

	@Override
	public Info getInfo(int infoSelectedId) {
		// TODO Auto-generated method stub
		return (Info) genericDao.get("from Info where id ='"+infoSelectedId+"'");
	}


}
