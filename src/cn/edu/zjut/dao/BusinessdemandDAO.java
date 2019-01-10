package cn.edu.zjut.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zjut.po.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Transactional
public class BusinessdemandDAO extends BaseHibernateDAO implements IBusinessdemandDAO{
    private Log log = LogFactory.getLog(BusinessdemandDAO.class);

    public void save(Businessdemand instance) {
        log.debug("saving Businessdemand instance");
        try {
            getSession().save(instance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public List findByHql(String hql) {
        log.debug("finding Businessdemand instance by hql");
        try {
            String queryString = hql;
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by hql failed", re);
            throw re;
        }
    }

    public void update(Businessdemand instance) {
        log.debug("updating Businessdemand instance");
        try {
            getSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed",re);
            throw re;
        }
    }

    public void delete(Businessdemand instance) {
        log.debug("deleting Businessdemand instance");
        try {
            getSession().delete(instance);
            log.debug("delete successful");
        } catch(RuntimeException re) {
            log.error("delete failed",re);
            throw re;
        }
    }
}
