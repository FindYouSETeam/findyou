package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.zjut.po.Shopassess;

public interface IShopassessDAO {
	Log log = LogFactory.getLog(ShopassessDAO.class);
	public void save(Shopassess instance);
	public List findByHql(String hql);
	public void update(ShopassessDAO instance);
	public void delete(ShopassessDAO instance);
}
