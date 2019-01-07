package cn.edu.zjut.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.po.Business;
import cn.edu.zjut.po.Liaisonuser;

public interface IAdminService {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	ServletContext application=ServletActionContext.getServletContext();
	HttpSession session=ServletActionContext.getRequest().getSession();
	public List liaisonJudge();
	public List businessJudge();
	public Liaisonuser findliaisonuser(int liaisonuserID);
	public Business findbusiness(int businessID);
	public boolean passliaison(int liaisonuserID);
	public boolean refuseliaison(int liaisonuserID);
	public boolean passbusiness(int businessID);
	public boolean refusebusiness(int businessID);
}
