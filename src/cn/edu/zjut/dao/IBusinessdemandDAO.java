package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.zjut.po.Businessdemand;

public interface IBusinessdemandDAO {
	Log log = LogFactory.getLog(BusinessdemandDAO.class);
	public void save(Businessdemand instance);
	public List findByHql(String hql);
	public void update(Businessdemand instance);
	public void delete(Businessdemand instance);

}
