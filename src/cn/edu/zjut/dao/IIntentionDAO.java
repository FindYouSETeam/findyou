package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.zjut.po.Intention;

public interface IIntentionDAO {
	Log log = LogFactory.getLog(IntentionDAO.class);
	public void save(Intention instance);
	public List findByHql(String hql);
	public void update(Intention instance);
	public void delete(Intention instance);
}
