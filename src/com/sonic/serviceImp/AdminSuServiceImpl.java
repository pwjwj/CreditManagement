package com.sonic.serviceImp;

import java.util.List;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Admin;
import com.sonic.pojo.StuBase;
import com.sonic.service.AdminSuService;

public class AdminSuServiceImpl implements AdminSuService{
	private GenericDao genericDao;
	public GenericDao getGenericDao() {
		return genericDao;
	}
 
	public void setGenericDao(GenericDao genericDaoImp) {
		this.genericDao = genericDaoImp;
	}
	@Override
	public List<Admin> getAdminBaseList(String hql,String page, String rows) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query(hql, currentpage, pagesize);
	}

	@Override
	public int getAdminTotal() {
		// TODO Auto-generated method stub
		return genericDao.countQuery("from Admin");
	}

	@Override
	public List<Admin> getAdminSearchList(String hql, String page, String rows) {
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
	public void saveStuBaseOrUpdate(Admin admin) {
		// TODO Auto-generated method stub
		genericDao.saveOrUpdate(admin);
	}

	//如果删除不行的话  就转为使用id
	@Override
	public void deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		genericDao.delById(Admin.class, adminId);
	}

	@Override
	public Admin getUser(String userName) {
		// TODO Auto-generated method stub
		return (Admin) genericDao.get("from AdminSu where username ='"+userName+"'");
	}

}
