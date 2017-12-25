package com.sonic.daoImp;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sonic.dao.GenericDao;



public class GenericDaoImp extends HibernateDaoSupport implements GenericDao {

	@Override
	public Object get(String hql) {
		if (this.getHibernateTemplate().find(hql).size()==0){
			Object object=null;
			return object;
		}
		else{
			return this.getHibernateTemplate().find(hql).get(0);
		}
	}
	@Override
	public Object getById(Class entityClass,Serializable id){
		return this.getHibernateTemplate().get(entityClass, id);
	}
	@Override
	public Object getObject(String entityName, Serializable id) {
		return this.getHibernateTemplate().get(entityName, id);
	}
	
	@Override
	public Object loadById(Class entityClass, Serializable id) {
		return this.getHibernateTemplate().load(entityClass, id);
	}

	@Override
	public Object loadObject(String entityName, Serializable id) {
		return this.getHibernateTemplate().load(entityName, id);
	}

	@Override
	public void delById(Class entityClass, Serializable id) {
		this.getHibernateTemplate().delete(getHibernateTemplate().get(entityClass, id));
	}

	//²ßÂÔÄ£Ê½
	@Override
	public void saveOrUpdate(Object entity) {
		
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public int countAll(String entityClass) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List query(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	/*@Override
	public List query(final String hql,final int pageNo,final int pageSize) {
		 List list = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				List result = arg0.createQuery(hql).setFirstResult(pageNo-1)
				        .setMaxResults(pageSize)
				        .list();
				    return result;
			}
			  });
		return list;
	}*/
	@Override
	public List query(final String hql,final int pageNo,final int pageSize) {
		 List list = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session arg0)
					throws HibernateException, SQLException {
					List result = arg0.createQuery(hql).setFirstResult((pageNo - 1) * pageSize)
				        .setMaxResults(pageSize)
				        .list();
				    return result;
				}
			  });
		return list;
	}
	@Override
	public List query(final String hql,final Date date) {
		 List list = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				List result = arg0.createQuery(hql).setDate(0, date)
				        .list();
				    return result;
			}
			  });
		return list;
	}
	
	@Override
	public List query(final String hql,final Date startTime, final Date endTime){
		 List list = getHibernateTemplate().executeFind(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session arg0)
						throws HibernateException, SQLException {
					List result = arg0.createQuery(hql).setDate(0, startTime).setDate(1, endTime)
					        .list();
					    return result;
				}
				  });
			return list;
	}

	@Override
	public int countQuery(String hql) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(hql).size();
	}

	@Override
	public int update(String hql) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql);
		
		query.executeUpdate();
		return 0;
	}
	

}
