package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.zjut.po.Shopactive;

public interface IActiveDAO {
	Log log = LogFactory.getLog(ActiveDAO.class);
	public void save(Shopactive instance);
	public List findByHql(String hql);
	public Shopactive findById(int i);
	public void del(Shopactive instance);
	public void update(Shopactive instance);
}
