package cn.edu.zjut.dao;
import java.util.List;
import org.hibernate.Query;

import cn.edu.zjut.po.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class LiaisonuserDAO extends BaseHibernateDAO{
	private Log log = LogFactory.getLog(LiaisonuserDAO.class);
	public void save(Liaisonuser instance) {
		log.debug("saving Liaisonuser instance");
		try {
		getSession().save(instance);
		log.debug("save successful");
		} catch (RuntimeException re) {
		log.error("save failed", re);
		throw re;
		}
		}
	public List findByHql(String hql) {
		log.debug("finding Liaisonuser instance by hql");
		try {
		String queryString = hql;
		Query queryObject = getSession().createQuery(queryString);
		return queryObject.list();
		} catch (RuntimeException re) {
		log.error("find by hql failed", re);
		throw re;
		}
		}
	public void update(Liaisonuser instance)
	{
		log.debug("updating Liaisonuser instance");
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
	public void delete(Liaisonuser instance)
	{
		log.debug("deleting Liaisonuser instance");
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
