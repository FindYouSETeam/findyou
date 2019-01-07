package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.zjut.po.Business;

public interface IBusinessDAO {
	Log log = LogFactory.getLog(BusinessDAO.class);
	public void save(Business instance);
	public List findByHql(String hql);
	public void update(Business instance);
	public void delete(Business instance);	
}
