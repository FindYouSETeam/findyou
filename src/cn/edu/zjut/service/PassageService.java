package cn.edu.zjut.service;

import cn.edu.zjut.dao.IPassageDAO;
import cn.edu.zjut.dao.PassageDAO;

import java.util.List;

public class PassageService implements IPassageService{
	private IPassageDAO passageDAO=null;
	
    public void setPassageDAO(IPassageDAO passageDAO) {
		this.passageDAO = passageDAO;
	}

	public Object query(long id) {
        String hql = "from Passage where id = '"+id+"'";
        //PassageDAO dao = new PassageDAO();
        //List list = dao.findByHql(hql);
        List list = passageDAO.findByHql(hql);
        return list.get(0);
    }
}

