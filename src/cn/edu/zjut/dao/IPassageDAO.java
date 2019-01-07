package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public interface IPassageDAO {
    Log log = LogFactory.getLog(PassageDAO.class);
    public List findByHql(String hql);
}
