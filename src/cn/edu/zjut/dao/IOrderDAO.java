package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.zjut.po.Theorder;

public interface IOrderDAO {
	Log log = LogFactory.getLog(OrderDAO.class);
	public void save(Theorder instance);
	public List findByHql(String hql);
	public void update(Theorder instance);
	public void delete(Theorder instance);
}
