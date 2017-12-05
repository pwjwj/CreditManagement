package com.sonic.serviceImp;

import java.util.List;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Admin;
import com.sonic.pojo.Creditactivity;
import com.sonic.pojo.Creditactivityview;
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
	public List<Object> getStuCreditActivityList(String page, String rows) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行
		System.out.println("进来object这里了");
		//String hql = "select new com.test.UsersVoGoods(u.userName, u.teltphone, u.address, g.goodsName) from Users u, Goods g where u.userId=g.userId";
		/*String hql="select c.id,c.name,c.number,c.categoryId,c.detail,c.dates,stu.credit " +
				"from Creditactivity c,StuBase stu where c.number=stu.number";*/
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

	@Override
	public void deleteCreditActivity(int creditActivityId) {
		// TODO Auto-generated method stub
		genericDao.delById(Creditactivity.class, creditActivityId);
	}

	@Override
	public List<Creditactivity> getCreditActivitySearchList(String hql,
			String page, String rows) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
						: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
						: rows);// 每页多少行

		return genericDao.query(hql, currentpage, pagesize);
	}

	@Override
	public int getCreditActivitySearchedTotal(String hql) {
		// TODO Auto-generated method stub
		return genericDao.countQuery(hql);
	}

	@Override
	public Creditactivity getCreditActivity(int activityId) {
		// TODO Auto-generated method stub
		return (Creditactivity) genericDao.get("from Creditactivity where id ='"+activityId+"'");
	}

	@Override
	public void saveCreditactivityBaseOrUpdate(Creditactivity ca) {
		// TODO Auto-generated method stub
		System.out.println("ca.getDetail()   "+ca.getDetail());
		genericDao.saveOrUpdate(ca);
	}

}
