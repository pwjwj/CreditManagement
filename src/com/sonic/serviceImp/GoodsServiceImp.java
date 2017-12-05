package com.sonic.serviceImp;

import java.util.List;

import com.sonic.dao.GenericDao;
import com.sonic.pojo.Goods;
import com.sonic.pojo.Info;
import com.sonic.service.GoodsService;

public class GoodsServiceImp implements GoodsService{
	private GenericDao genericDao;
	public GenericDao getGenericDao() {
		return genericDao;
	}
 
	public void setGenericDao(GenericDao genericDaoImp) {
		this.genericDao = genericDaoImp;
	}
	
	@Override
	public List<Info> getAllGoodsList(String hql,String page, String rows) {
		// TODO Auto-generated method stub
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行

		return genericDao.query(hql, currentpage, pagesize);
	}
	
	@Override
	public int getGoodsTotal() {
		// TODO Auto-generated method stub
		return genericDao.countQuery("from Goods");
	}

	@Override
	public void saveGoodsOrUpdate(Goods goods) {
		// TODO Auto-generated method stub
		genericDao.saveOrUpdate(goods);
	}

	@Override
	public List<Goods> getGoodsSearchList(String hql, String page, String rows) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
						: page);// 第几页
				int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
						: rows);// 每页多少行

				return genericDao.query(hql, currentpage, pagesize);
	}

	@Override
	public int getGoodsSearchedTotal(String hql) {
		// TODO Auto-generated method stub
		return genericDao.countQuery(hql);
	}

	@Override
	public void deleteGoodsById(int goodsId) {
		// TODO Auto-generated method stub
		genericDao.delById(Goods.class, goodsId);
	}
}
