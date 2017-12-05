package com.sonic.serviceImp;

import java.util.List;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Admin;
import com.sonic.pojo.Application;
import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.Info;
import com.sonic.pojo.StuBase;
import com.sonic.service.StuService;

public class StuServiceImpl implements StuService {
	private GenericDao genericDao;

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDaoImp) {
		this.genericDao = genericDaoImp;
	}

	@Override
	public List<StuBase> getStuSelfBaseList(String name) {
		// TODO Auto-generated method stub

		return genericDao.query("from StuBase where name ='" + name + "'");
	}

	@Override
	public List<Creditactivity> getStuCreditActivitySearchList(String hql,
			String page, String rows) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query(hql, currentpage, pagesize);
	}

	@Override
	public int getSearchedTotal(String hql) {
		// TODO Auto-generated method stub
		return genericDao.countQuery(hql);
	}

	@Override
	public StuBase getUser(String userName) {
		// TODO Auto-generated method stub
		return (StuBase) genericDao.get("from StuBase where name ='" + userName
				+ "'");
	}

	@Override
	public List<Creditactivity> getStuSelfCreditActivityList(String page,
			String rows, String Name) {
		// TODO Auto-generated method stub

		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query("from Creditactivity where name='"+Name+"'", currentpage, pagesize);
	}

	@Override
	public int getStuSelfCreditActivityTotal(String hql) {
		// TODO Auto-generated method stub
		return genericDao.countQuery(hql);
	}

	@Override
	public StuBase getStuByNumber(int currentStuNumber) {
		// TODO Auto-generated method stub
		return (StuBase) genericDao.get("from StuBase where number ='"+currentStuNumber+"'");
	}

	@Override
	public void saveStuBaseOrUpdate(StuBase stuBase) {
		// TODO Auto-generated method stub
		genericDao.saveOrUpdate(stuBase);
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

	@Override
	public List<Info> getInfoSearchList(String hql, String page, String rows) {
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
	public List<Application> getAllApplicationsList(String page, String rows,String name,int actualNumber) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行
		
		return genericDao.query("from Application where applicationName='"+name+"' and applicationNumber="+actualNumber, currentpage, pagesize);
	}

	@Override
	public int getApplicationsTotal(String name, int actualNumber) {
		// TODO Auto-generated method stub
		return genericDao.countQuery("from Application where applicationName='"+name+"' and applicationNumber="+actualNumber);
	}

	@Override
	public void saveApplocationSelfOrUpdate(Application application) {
		// TODO Auto-generated method stub
		genericDao.saveOrUpdate(application);
	}

}
