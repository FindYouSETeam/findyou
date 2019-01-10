package cn.edu.zjut.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zjut.po.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Transactional
public class OrderDAO extends BaseHibernateDAO implements IOrderDAO{
    private Log log = LogFactory.getLog(OrderDAO.class);

    public void save(Theorder instance) {
        log.debug("saving Order instance");
        try {
            getSession().save(instance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public List findByHql(String hql) {
        log.debug("finding Order instance by hql");
        try {
            String queryString = hql;
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by hql failed", re);
            throw re;
        }
    }

    public void update(Theorder instance) {
        log.debug("updating Order instance");
        //Transaction tran=getSession().beginTransaction();
        try {
            getSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed",re);
            throw re;
        }
        //tran.commit();
        //getSession().flush();
        //getSession().close();
    }

    public void delete(Theorder instance) {
        log.debug("deleting Order instance");
        try {
            getSession().delete(instance);
            log.debug("delete successful");
        } catch(RuntimeException re) {
            log.error("delete failed",re);
            throw re;
        }
    }
}
