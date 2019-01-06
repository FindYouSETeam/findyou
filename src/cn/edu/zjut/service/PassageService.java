package cn.edu.zjut.service;

import cn.edu.zjut.dao.PassageDAO;

import java.util.List;

public class PassageService {

    public Object query(long id) {
        String hql = "from Passage where id = '"+id+"'";
        PassageDAO dao = new PassageDAO();
        List list = dao.findByHql(hql);
        return list.get(0);
    }
}

