package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.zjut.po.Liaisondemand;

public interface ILiaisondemandDAO {
	Log log = LogFactory.getLog(LiaisondemandDAO.class);
	public void save(Liaisondemand instance);
	public List findByHql(String hql);
	public void update(Liaisondemand instance);
	public void delete(Liaisondemand instance);
}
