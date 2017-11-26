package com.sonic.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public interface GenericDao {
	 /** ����ָ�����ĳ־û����� */
	 public Object get(String hql);
	 /** ����ָ�����ĳ־û�����*/
	 public Object getById(Class entityClass,Serializable id);
	 /** �������������ĳ־û����� */
	 public Object getObject(String entityName, Serializable id);
	
	 /** ����ָ��ID�ĳ־û����� */
	 public Object loadById(Class entityClass,Serializable id);
	 
	 /** �������������ĳ־û����� */
	 public Object loadObject(String entityName, Serializable id);
	 
	 /** ɾ��ָ��ID�ĳ־û����� */
	 public void delById(Class entityClass,Serializable id);
	 
	 /** ��������ָ���ĳ־û����� */
	 public void saveOrUpdate(Object entity);
	 
	 /** ͳ��ָ��������г־û����� */
	 public int countAll(String entityClass);
	 
	 /** ��ѯָ��������������ĳ־û����� */
	 public List query(String hql);
	 
	 public List query(final String hql,final Date date);
	 
	 public List query(final String hql,final Date startTime, final Date endTime);
	 
	 /** ��ҳ��ѯָ��������������ĳ־û����� */
	 public List query(String hql,int pageNo,int pageSize);
	 
	 /** ͳ��ָ����Ĳ�ѯ��� */
	 public int countQuery(String hql);
	 
	 /** ������������ */
	 public int update(String hql);
	 
}
