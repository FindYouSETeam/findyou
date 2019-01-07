package cn.edu.zjut.dao;
import java.util.List;
import org.hibernate.Query;

import cn.edu.zjut.bean.LiaisonDetail;
import cn.edu.zjut.po.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class LiaisonDAO extends BaseHibernateDAO implements ILiaisonDAO{
	private Log log = LogFactory.getLog(LiaisonDAO.class);
	public void save(Liaison instance) 
	{
		log.debug("saving Liaison instance");
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
		log.debug("finding Liaison instance by hql");
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
	
	public void update(Liaison instance)
	{
		log.debug("updating Liaison instance");
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
	public void delete(Liaison instance)
	{
		log.debug("deleting Liaison instance");
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
