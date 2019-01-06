package cn.edu.zjut.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

public class AdminDAO extends BaseHibernateDAO{
	private Log log = LogFactory.getLog(BusinessDAO.class);
	public void updateByHQl(String hql)
	{
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
			}
	}
}
