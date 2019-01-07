package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.zjut.po.Shop;

public interface IShopDAO {
	Log log = LogFactory.getLog(ShopDAO.class);
	public void save(Shop instance);
	public List findByHql(String hql);
	public void update(Shop instance);
	public void delete(Shop instance);
}
