package cn.edu.zjut.service;

import cn.edu.zjut.dao.IPassageDAO;
import cn.edu.zjut.dao.PassageDAO;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public class PassageListService implements IPassageListService{
	private IPassageDAO passageDAO=null;
	
    public void setPassageDAO(IPassageDAO passageDAO) {
		this.passageDAO = passageDAO;
	}

	public List query() {
        String hql = "from Passage ";
        //PassageDAO dao = new PassageDAO();
        //List list = dao.findByHql(hql);
        List list = passageDAO.findByHql(hql);
        return list;
    }
}

