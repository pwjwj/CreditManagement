package com.sonic.serviceImp;

import java.util.List;

import org.hibernate.SessionFactory;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Admin;
import com.sonic.pojo.AdminSu;
import com.sonic.pojo.StuBase;
import com.sonic.service.BaseInfoService;

public class BaseInfoServiceImp implements BaseInfoService {
	private GenericDao genericDao;
	private SessionFactory sessionFactory;
	public GenericDao getGenericDao() {
		return genericDao;
	}
 
	public void setGenericDao(GenericDao genericDaoImp) {
		this.genericDao = genericDaoImp;
	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<StuBase> getStuBaseList(String hql,String page, String rows) {
		//获取学生基本信息的list
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		System.out.println("currentpage   "+currentpage);
		return genericDao.query(hql, currentpage, pagesize);
		
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

	@Override
	public List<Admin> getAdminSelfBaseList(String name) {
		// TODO Auto-generated method stub
		return genericDao.query("from Admin where username ='" + name + "'");
	}

	@Override
	public Admin getUserById(int adminId) {
		// TODO Auto-generated method stub
		return (Admin) genericDao.get("from Admin where id ='"+adminId+"'");
	}

	@Override
	public void saveAdminOrUpdate(Admin admin) {
		// TODO Auto-generated method stub
		genericDao.saveOrUpdate(admin);
	}

	@Override
	public List<StuBase> getStuBaseList(String hql) {
		// TODO Auto-generated method stub
		return genericDao.query(hql);
	}
	
}
