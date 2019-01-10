package cn.edu.zjut.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;
public class BaseHibernateDAO {
	private SessionFactory sessionFactory;
	public Session getSession()
	{
        //return sessionFactory.openSession();
        return sessionFactory.getCurrentSession();
        // 为当前线程绑定一个session对象,让dao中使用 getCurrentSession的方法可以获取到对应的session
        /*Session session = this.sessionFactory.openSession();
        TransactionSynchronizationManager.bindResource(this.sessionFactory, session);
        try {
            return session;
        } finally {
          TransactionSynchronizationManager.unbindResourceIfPossible(this.sessionFactory);
            if (session != null) {
                session.close();
            }
        }*/
	}
	public void setSessionFactory(SessionFactory sessionFactory) 
	{ 
		this.sessionFactory = sessionFactory; 
	}
}
