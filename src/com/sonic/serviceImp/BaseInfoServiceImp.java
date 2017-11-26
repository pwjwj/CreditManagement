package com.sonic.serviceImp;

import java.util.List;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Admin;
import com.sonic.pojo.AdminSu;
import com.sonic.pojo.StuBase;
import com.sonic.service.BaseInfoService;

public class BaseInfoServiceImp implements BaseInfoService {
	private GenericDao genericDao;
	public GenericDao getGenericDao() {
		return genericDao;
	}
 
	public void setGenericDao(GenericDao genericDaoImp) {
		this.genericDao = genericDaoImp;
	}


	@Override
	public List<StuBase> getStuBaseList(String page, String rows) {
		//获取学生基本信息的list
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query("from StuBase", currentpage, pagesize);
	}

	@Override
	public int getUserTotal() {
		// TODO Auto-generated method stub
		return genericDao.countQuery("from StuBase");
	}

	
	@Override
	public Admin getTUser(String id) {
		// TODO Auto-generated method stub
		return (Admin) genericDao.get("from Admin where username ='"+id+"'");
	}

	@Override
	public AdminSu getSUser(String id) {
		// TODO Auto-generated method stub
		return (AdminSu) genericDao.get("from AdminSu where username ='"+id+"'");
	}

	@Override
	public StuBase getUser(String id) {
		// TODO Auto-generated method stub
		return (StuBase) genericDao.get("from StuBase where name ='"+id+"'");
	}

	@Override
	public List<StuBase> getStuSearchList(String hql, String page, String rows) {
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
	public void saveStuBaseOrUpdate(StuBase stu) {
		// TODO Auto-generated method stub
		genericDao.saveOrUpdate(stu);
	}

	@Override
	public void deleteStu(int stuId) {
		// TODO Auto-generated method stub
		genericDao.delById(StuBase.class, stuId);
	}

	
}
