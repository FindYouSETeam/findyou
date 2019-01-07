package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.zjut.po.Login;

public interface ILoginDAO {
	Log log = LogFactory.getLog(LoginDAO.class);
	public void save(Login instance);
	public List findByHql(String hql);
	public void update(Login instance);
	public void delete(Login instance);
}
