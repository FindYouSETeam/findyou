package cn.edu.zjut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Transactional
public class PassageDAO extends BaseHibernateDAO implements IPassageDAO{

    private Log log = LogFactory.getLog(PassageDAO.class);

    public List findByHql(String hql) {
		log.debug("finding LoginUser instance by hql");
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
    }
}
