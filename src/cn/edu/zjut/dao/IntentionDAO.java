package cn.edu.zjut.dao;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zjut.po.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
@Transactional
public class IntentionDAO extends BaseHibernateDAO implements IIntentionDAO{
	private Log log = LogFactory.getLog(IntentionDAO.class);
	public void save(Intention instance) {
		log.debug("saving Intention instance");
		try {
		getSession().save(instance);
		log.debug("save successful");
		} catch (RuntimeException re) {
		log.error("save failed", re);
		throw re;
		}
		}
	public List findByHql(String hql) {
		log.debug("finding Intention instance by hql");
		try {
		String queryString = hql;
		Query queryObject = getSession().createQuery(queryString);
		return queryObject.list();
		} catch (RuntimeException re) {
		log.error("find by hql failed", re);
		throw re;
		}
		}
	public void update(Intention instance)
	{
		log.debug("updating Intention instance");
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
	public void delete(Intention instance)
	{
		log.debug("deleting Intention instance");
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
