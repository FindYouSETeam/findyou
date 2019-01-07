package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.zjut.po.Liaisonuser;

public interface ILiaisonuserDAO {
	Log log = LogFactory.getLog(LiaisonuserDAO.class);
	public void save(Liaisonuser instance);
	public List findByHql(String hql);
	public void update(Liaisonuser instance);
	public void delete(Liaisonuser instance);
}
