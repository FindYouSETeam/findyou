package cn.edu.zjut.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.po.Intention;


public interface IIntentionService {
	HttpServletRequest request =ServletActionContext.getRequest();
    HttpServletResponse response= ServletActionContext.getResponse();
    ServletContext application= ServletActionContext.getServletContext();
    HttpSession session= ServletActionContext.getRequest().getSession();
    //根据LiaisonuserID获取用户的申请记录
    public List getIntentionByLID();
    //根据BusinessID获取用户的申请记录
    public List getIntentionByBID();
    //根据intentionID获取intention
    public Intention findIntentionByIID(int intentionID);
    //根据intentionID取消intention
    public boolean cancelIntention(int intentionID);
}
