package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import cn.edu.zjut.po.*;
public class ActiveDAO extends BaseHibernateDAO implements IActiveDAO {
	private Log log = LogFactory.getLog(ActiveDAO.class);
	public void save(Shopactive instance) 
	{
		log.debug("saving Shopactive instance");
		try 
		{
			getSession().save(instance);
			log.debug("save successful");
		} 
		catch (RuntimeException re) 
		{
			log.error("save failed", re);
			throw re;
		}
	}
	public List findByHql(String hql) 
	{
		log.debug("finding ShopActiveList instance by hql");
		try 
		{
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} 
		catch (RuntimeException re) 
		{
			log.error("find by hql failed", re);
			throw re;
		}
	}
	
	public Shopactive findById(int i) {
		return getSession().get(Shopactive.class, i);
	}
	
	public void del(Shopactive instance)
	{
		log.debug("delete Shopactive instance");
		try 
		{
			getSession().delete(instance);
			log.debug("delete successful");
		} 
		catch (RuntimeException re) 
		{
			log.error("delete failed", re);
			throw re;
		}
	}
	public void update(Shopactive instance)
	{
		log.debug("updating Shopactive instance");
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
}
