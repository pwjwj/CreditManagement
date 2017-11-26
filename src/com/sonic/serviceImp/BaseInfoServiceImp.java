package com.sonic.serviceImp;

import java.util.List;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Creditcategory;
import com.sonic.pojo.Info;
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

	//@Override
	/*public List<StuBase> getUserListByAuthority(String Authority, String page,
			String rows) {
		// TODO Auto-generated method stub
		//当为缺省值的时候进行赋值  
        int currentpage = Integer.parseInt((page == null || page == "0") ? "1": page);//第几页  
        int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10": rows);//每页多少行  
          
		return dao.query("from Users u where u.authority = '"+ Authority+"'", currentpage, pagesize);
	}*/

	/*@Override
	public int getUserTotalByAuthority(String Authority) {
		// TODO Auto-generated method stub
		return 0;
	}
*/
	@Override
	public StuBase getUser(String id) {
		// TODO Auto-generated method stub
		return (StuBase) genericDao.get("from StuBase where name ='"+id+"'");
	}

	/*@Override
	public List<StuBase> getStuCreditActivityList(String page, String rows) {
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
*/
	/*@Override
	public List<Creditcategory> getCreditCategoryList(String page, String rows) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query("from Creditcategory", currentpage, pagesize);
	}

	@Override
	public int getCreditCategoryTotal() {
		// TODO Auto-generated method stub
		return genericDao.countQuery("from Creditcategory");
	}
*/
	/*@Override
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
*/
	/*@Override
	public List<Info> getAllGoodsList(String page, String rows) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query("from Goods", currentpage, pagesize);
	}
	
	@Override
	public int getGoodsTotal() {
		// TODO Auto-generated method stub
		return genericDao.countQuery("from Goods");
	}*/

	
	/*@Override
	public void saveUserOrUpdate(StuBase user) {
		// TODO Auto-generated method stub
		dao.saveOrUpdate(user);
	}*/

	/*@Override
	public void delete(List<StuBase> list) {
		// TODO Auto-generated method stub
		if (list != null){
			for(int i = 0; i < list.size(); i++){
				dao.delById(StuBase.class, list.get(i).getNumber());
			}
		}
	}*/
}
