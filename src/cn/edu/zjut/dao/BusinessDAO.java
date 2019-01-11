package cn.edu.zjut.dao;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zjut.po.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Transactional
public class BusinessDAO extends BaseHibernateDAO implements IBusinessDAO{
	private Log log = LogFactory.getLog(BusinessDAO.class);
	public void save(Business instance) {
		log.debug("saving Business instance");
		try {
		getSession().save(instance);
		log.debug("save successful");
		} catch (RuntimeException re) {
		log.error("save failed", re);
		throw re;
		}
		}
	public List findByHql(String hql) {
		log.debug("finding Business instance by hql");
		try {
		String queryString = hql;
		Query queryObject = getSession().createQuery(queryString);
		return queryObject.list();
		} catch (RuntimeException re) {
		log.error("find by hql failed", re);
		throw re;
		}
		}
	public void update(Business instance)
	{
		log.debug("updating Business instance");
		try
		{
			getSession().update(instance);
			log.debug("update successful");
		}
		catch (RuntimeException re)
		{
			log.error("update failed",re);
			throw re;
		}
	}
	public void delete(Business instance)
	{
		log.debug("deleting Business instance");
		try
		{
			getSession().delete(instance);
			log.debug("delete successful");
		}
		catch(RuntimeException re)
		{
			log.error("delete failed",re);
			throw re;
		}
	}
	
}
