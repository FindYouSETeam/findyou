package cn.edu.zjut.dao;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zjut.po.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Transactional
public class LoginDAO extends BaseHibernateDAO implements ILoginDAO{
	private Log log = LogFactory.getLog(LoginDAO.class);
	public void save(Login instance) {
		log.debug("saving Login instance");
		try {
		getSession().save(instance);
		log.debug("save successful");
		} catch (RuntimeException re) {
		log.error("save failed", re);
		throw re;
		}
		}
	public List findByHql(String hql) {
		log.debug("finding Login instance by hql");
		try {
		String queryString = hql;
		Query queryObject = getSession().createQuery(queryString);
		return queryObject.list();
		} catch (RuntimeException re) {
		log.error("find by hql failed", re);
		throw re;
		}
		}
	public void update(Login instance)
	{
		log.debug("updating Login instance");
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
	public void delete(Login instance)
	{
		log.debug("deleting Login instance");
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
