package com.sonic.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public interface GenericDao {
	 /** 加载指定语句的持久化对象 */
	 public Object get(String hql);
	 /** 加载指定语句的持久化对象*/
	 public Object getById(Class entityClass,Serializable id);
	 /** 加载满足条件的持久化对象 */
	 public Object getObject(String entityName, Serializable id);
	
	 /** 加载指定ID的持久化对象 */
	 public Object loadById(Class entityClass,Serializable id);
	 
	 /** 加载满足条件的持久化对象 */
	 public Object loadObject(String entityName, Serializable id);
	 
	 /** 删除指定ID的持久化对象 */
	 public void delById(Class entityClass,Serializable id);
	 
	 /** 保存或更新指定的持久化对象 */
	 public void saveOrUpdate(Object entity);
	 
	 /** 统计指定类的所有持久化对象 */
	 public int countAll(String entityClass);
	 
	 /** 查询指定类的满足条件的持久化对象 */
	 public List query(String hql);
	 
	 public List query(final String hql,final Date date);
	 
	 public List query(final String hql,final Date startTime, final Date endTime);
	 
	 /** 分页查询指定类的满足条件的持久化对象 */
	 public List query(String hql,int pageNo,int pageSize);
	 
	 /** 统计指定类的查询结果 */
	 public int countQuery(String hql);
	 
	 /** 条件更新数据 */
	 public int update(String hql);
	 
}
