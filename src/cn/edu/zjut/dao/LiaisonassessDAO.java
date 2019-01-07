package cn.edu.zjut.dao;
import java.util.List;
import org.hibernate.Query;

import cn.edu.zjut.po.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class LiaisonassessDAO extends BaseHibernateDAO implements ILiaisonassessDAO{
	private Log log = LogFactory.getLog(LiaisonassessDAO.class);
	public void save(Liaisonassess instance) {
		log.debug("saving Liaisonassess instance");
		try {
		getSession().save(instance);
		log.debug("save successful");
		} catch (RuntimeException re) {
		log.error("save failed", re);
		throw re;
		}
		}
	public List findByHql(String hql) {
		log.debug("finding Liaisonassess instance by hql");
		try {
		String queryString = hql;
		Query queryObject = getSession().createQuery(queryString);
		return queryObject.list();
		} catch (RuntimeException re) {
		log.error("find by hql failed", re);
		throw re;
		}
		}
	public void update(Liaisonassess instance)
	{
		log.debug("updating Liaisonassess instance");
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
	public void delete(Liaisonassess instance)
	{
		log.debug("deleting Liaisonassess instance");
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
