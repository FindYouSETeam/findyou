package cn.edu.zjut.service;

import cn.edu.zjut.dao.PassageDAO;

import java.util.List;

public class PassageListService {

    public List query() {
        String hql = "from Passage ";
        PassageDAO dao = new PassageDAO();
        List list = dao.findByHql(hql);
        return list;
    }
}

