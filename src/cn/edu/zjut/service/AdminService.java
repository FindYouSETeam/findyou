package cn.edu.zjut.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Transaction;

import cn.edu.zjut.dao.AdminDAO;
import cn.edu.zjut.dao.BusinessDAO;
import cn.edu.zjut.dao.LiaisonuserDAO;
import cn.edu.zjut.dao.LoginDAO;
import cn.edu.zjut.po.Business;
import cn.edu.zjut.po.Liaisonuser;

public class AdminService {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	ServletContext application=ServletActionContext.getServletContext();
	HttpSession session=ServletActionContext.getRequest().getSession();
	public List liaisonJudge()
	{
		String hql;
		List list;
		LiaisonuserDAO dao=new LiaisonuserDAO();
		hql="select new cn.edu.zjut.bean.liaisonjudge(liaisonuser.liaisonuserID,liaisonuser.login.account,liaisonuser.name,liaisonuser.IDCard,liaisonuser.phone,liaisonuser.liaison.departmentdetail,liaisonuser.liaison.address"
				+ ")"
				+ "from Liaisonuser liaisonuser,Liaison liaison "
				+ "WHERE liaisonuser.liaisonuserID=liaison.liaisonuser.liaisonuserID and liaisonuser.auditing=0";
		list=dao.findByHql(hql);
		dao.getSession().close();
		return list;
		
	}
	
	public List businessJudge()
	{
		String hql;
		List list;
		BusinessDAO dao=new BusinessDAO();
		hql="select new cn.edu.zjut.bean.businessjudge(business.businessID,business.login.account,business.name,business.IDCard,business.phone,business.shop.shopname,business.shop.shoptype,business.shop.shopdetail,business.shop.address"
				+ ")"
				+ "from Business business,Shop shop  "
				+ "WHERE business.businessID=shop.business.businessID and business.auditing=0";
		list=dao.findByHql(hql);
		dao.getSession().close();
		return list;
		
	}
	
	public Liaisonuser findliaisonuser(int liaisonuserID)
	{
		LiaisonuserDAO dao=new LiaisonuserDAO();
		String hql= "from Liaisonuser where liaisonuserID=" + liaisonuserID;
		Transaction tran = null; 
		try
		{
			List list=dao.findByHql(hql);
			dao.getSession().close();
			tran=dao.getSession().beginTransaction();
			Liaisonuser liaisonuser=(Liaisonuser)list.get(0);
			tran.commit();
			return liaisonuser;
		}catch (Exception e) {
			if(tran != null) tran.rollback();
			return null;
			} finally {
			dao.getSession().close();
			}
	}
	public Business findbusiness(int businessID)
	{
		BusinessDAO dao=new BusinessDAO();
		String hql= "from Business where businessID=" + businessID;
		Transaction tran = null; 
		try
		{
			List list=dao.findByHql(hql);
			dao.getSession().close();
			tran=dao.getSession().beginTransaction();
			Business business=(Business)list.get(0);
			tran.commit();
			return business;
		}catch (Exception e) {
			if(tran != null) tran.rollback();
			return null;
			} finally {
			dao.getSession().close();
			}
	}
	
	public boolean passliaison(int liaisonuserID)
	{
		/*AdminDAO dao =new AdminDAO();
		String hql;
		hql="update Liaisonuser liaisonuser set liaisonuser.auditing=1 where liaisonuser.liaisonuserID="+liaisonuserID;
		dao.updateByHQl(hql);
		dao.getSession().close();*/
		LiaisonuserDAO dao=new LiaisonuserDAO();
		Liaisonuser liaisonuser=findliaisonuser(liaisonuserID);
		Transaction tran = null; 
		try
		{
			tran=dao.getSession().beginTransaction();
			liaisonuser.setAuditing(1);
			dao.update(liaisonuser);
			tran.commit();
			return true;
		}catch (Exception e) {
			if(tran != null) tran.rollback();
			return false;
			} finally {
			dao.getSession().close();
			}
	}
	public boolean refuseliaison(int liaisonuserID)
	{
		LiaisonuserDAO dao=new LiaisonuserDAO();
		Liaisonuser liaisonuser=findliaisonuser(liaisonuserID);
		Transaction tran = null; 
		try
		{
			tran=dao.getSession().beginTransaction();
			liaisonuser.setAuditing(-1);
			dao.update(liaisonuser);
			tran.commit();
			return true;
		}catch (Exception e) {
			if(tran != null) tran.rollback();
			return false;
			} finally {
			dao.getSession().close();
			}
	}
	
	
	public boolean passbusiness(int businessID)
	{
		BusinessDAO dao=new BusinessDAO();
		Business business=findbusiness(businessID);
		Transaction tran = null; 
		try
		{
			tran=dao.getSession().beginTransaction();
			business.setAuditing(1);
			dao.update(business);
			tran.commit();
			return true;
		}catch (Exception e) {
			if(tran != null) tran.rollback();
			return false;
			} finally {
			dao.getSession().close();
			}
	}
	public boolean refusebusiness(int businessID)
	{
		BusinessDAO dao=new BusinessDAO();
		Business business=findbusiness(businessID);
		Transaction tran = null; 
		try
		{
			tran=dao.getSession().beginTransaction();
			business.setAuditing(-1);
			dao.update(business);
			tran.commit();
			return true;
		}catch (Exception e) {
			if(tran != null) tran.rollback();
			return false;
			} finally {
			dao.getSession().close();
			}
	}
}
