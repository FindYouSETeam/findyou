package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import cn.edu.zjut.po.Intention;
import cn.edu.zjut.po.Liaison;

public interface ILiaisonDAO {
	Log log = LogFactory.getLog(LiaisonDAO.class);
	public void save(Liaison instance);
	public List findByHql(String hql);
	public void update(Liaison instance);
	public void delete(Liaison instance);
}
