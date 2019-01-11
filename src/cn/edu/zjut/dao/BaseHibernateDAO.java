package cn.edu.zjut.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;
public class BaseHibernateDAO {
	private SessionFactory sessionFactory;
	public Session getSession()
	{ 
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) 
	{ 
		this.sessionFactory = sessionFactory; 
	}
}
