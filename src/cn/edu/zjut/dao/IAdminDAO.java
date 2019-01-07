package cn.edu.zjut.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

public interface IAdminDAO {
	Log log = LogFactory.getLog(BusinessDAO.class);
	public void updateByHQl(String hql);
}
