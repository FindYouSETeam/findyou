package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.zjut.po.Liaisonassess;

public interface ILiaisonassessDAO {
	Log log = LogFactory.getLog(LiaisonassessDAO.class);
	public void save(Liaisonassess instance);
	public List findByHql(String hql);
	public void update(Liaisonassess instance);
	public void delete(Liaisonassess instance);
}
