package cn.edu.zjut.service;
import java.sql.Blob;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.BusinessDAO;
import cn.edu.zjut.dao.BusinessdemandDAO;
import cn.edu.zjut.dao.LiaisonDAO;
import cn.edu.zjut.dao.LiaisonassessDAO;
import cn.edu.zjut.dao.LiaisondemandDAO;
import cn.edu.zjut.dao.LiaisonuserDAO;
import cn.edu.zjut.dao.LoginDAO;
import cn.edu.zjut.dao.ShopDAO;
import cn.edu.zjut.dao.ShopassessDAO;
import cn.edu.zjut.po.*;

public class UserService {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	ServletContext application=ServletActionContext.getServletContext();
	HttpSession session=ServletActionContext.getRequest().getSession();
	public boolean business_register_basic(Business business,Login login)  //商家注册基础模块
	{
		Transaction tran = null; 
		BusinessDAO dao=new BusinessDAO();
		LoginDAO logindao=new LoginDAO();
		try
		{
			tran=dao.getSession().beginTransaction();
			logindao.save(login);
			business.setLogin(login);
			application.setAttribute("business", business);
			dao.save(business);
			tran.commit();
			return true;
		}catch (Exception e) {
			if(tran != null) tran.rollback();
			return false;
			} finally {
			dao.getSession().close();
			}
			}
	public boolean business_register_detail(Business business,Shop shop) //商家注册详细模块
	{
		business=(Business)application.getAttribute("business");
		String hql = "from Business where account='" + business.getLogin().getAccount()
				+ "'";
		Transaction tran = null; 
		BusinessDAO dao=new BusinessDAO();
		ShopDAO shopdao=new ShopDAO();
		try
		{
			List list=dao.findByHql(hql);
			dao.getSession().close();
			tran=dao.getSession().beginTransaction();
			business=(Business)list.get(0);
			shop.setBusiness(business);
			shopdao.save(shop);
			tran.commit();
			return true;
		}catch (Exception e) {
			if(tran != null) tran.rollback();
			return false;
			} finally {
			dao.getSession().close();
			}
	}
	public boolean user_register_basic(Liaisonuser liaisonuser,Login login)  //用户注册基础模块
	{
		Transaction tran = null; 
		LiaisonuserDAO dao=new LiaisonuserDAO();
		LoginDAO logindao=new LoginDAO();
		try
		{
			tran=dao.getSession().beginTransaction();
			logindao.save(login);
			liaisonuser.setLogin(login);
			application.setAttribute("liaisonuser", liaisonuser);
			dao.save(liaisonuser);
			tran.commit();
			return true;
		}catch (Exception e) {
			if(tran != null) tran.rollback();
			return false;
			} finally {
			dao.getSession().close();
			}
			}
	public boolean user_register_detail(Liaisonuser liaisonuser,Liaison liaison) //用户注册详细模块
	{
		liaisonuser=(Liaisonuser)application.getAttribute("liaisonuser");
		String hql= "from Liaisonuser where account='" + liaisonuser.getLogin().getAccount()+"'";
		Transaction tran = null; 
		BusinessDAO dao=new BusinessDAO();
		LiaisonDAO liasiondao=new LiaisonDAO();
		try
		{
			List list=dao.findByHql(hql);
			dao.getSession().close();
			tran=dao.getSession().beginTransaction();
			liaisonuser=(Liaisonuser)list.get(0);
			liaison.setLiaisonuser(liaisonuser);
			liasiondao.save(liaison);
			tran.commit();
			return true;
		}catch (Exception e) {
			if(tran != null) tran.rollback();
			return false;
			} finally {
			dao.getSession().close();
			}
	}
	public boolean createShopAssess( Shopassess shopassess,int orderID)  //评价店铺
	{
		Transaction tran=null;
		ShopassessDAO dao=new ShopassessDAO();
		try
		{
			tran=dao.getSession().beginTransaction();
			//shopassess.getTheorder().setOrderID(orderID);
			dao.save(shopassess);
			tran.commit();
			return true;
		}catch (Exception e) {
			if(tran != null) tran.rollback();
			return false;
			} finally {
			dao.getSession().close();
			}
		
	}
	public boolean LoginService(Login login,String type)              //登录    
	{
		String hql;
	try
	{
		if(type.equals("liaisonuser"))
		{
			LiaisonuserDAO dao=new LiaisonuserDAO();
			hql=  "from Liaisonuser where account='"+login.getAccount()+"'";
			List list=dao.findByHql(hql);
			Liaisonuser liaisonuser =( Liaisonuser)list.get(0);
			application.setAttribute("liaisonuser", liaisonuser);
			System.out.println("外联登录放application");
			System.out.println(liaisonuser.getName());
			dao.getSession().close();

		}
		if(type.equals("business"))
		{
			BusinessDAO dao= new BusinessDAO(); 	
			hql= "from Business where account='"+login.getAccount()+"'";
			List list=dao.findByHql(hql);
			Business business=(Business)list.get(0);
			application.setAttribute("business", business);
			System.out.println("商家登录放application");
			System.out.println(business.getName());
			dao.getSession().close();
		}
		return true;
		}
		catch (Exception e) {
				return false;
	}
	}
	public Businessdemand findBusinessdemandbyID(int businessdemandID) //用businessdemandID查询指定商家需求信息
	{
		String hql;
		List list;
		BusinessdemandDAO dao=new BusinessdemandDAO();
		hql="from Businessdemand where businessdemandID="+businessdemandID;
		list=dao.findByHql(hql);
		Businessdemand businessdemand=(Businessdemand)list.get(0);
		dao.getSession().close();
		return businessdemand;
	}
	public Liaisondemand findLiaisondemandbyID(int liaisondemandID) //用liaisondemandID查外联指定需求信息
	{
		String hql;
		List list;
		BusinessdemandDAO dao=new BusinessdemandDAO();
		hql="from Liaisondemand where liaisondemandID="+liaisondemandID;
		list=dao.findByHql(hql);
		Liaisondemand liaisondemand=(Liaisondemand)list.get(0);
		dao.getSession().close();
		return liaisondemand;
	}
	public List findallbusinessService() //外联登录显示所有商家的需求列表
	{
		String hql;
		List list;
		BusinessdemandDAO dao=new BusinessdemandDAO();
		hql="select new cn.edu.zjut.bean.showBusinessdemand(demand.businessdemandID,demand.publisheddate,demand.period,demand.mincapital,"
				+ "demand.maxcapital,demand.overallnum,demand.status,demand.business.businessID,"
				+ "shop.shopID,shop.shopname,shop.qualification,shop.shoptype,shop.shopdetail,shop.shopfront,shop.address) "
				+ "from Businessdemand demand,Shop shop Where demand.business.businessID=shop.business.businessID";
		list=dao.findByHql(hql);
		dao.getSession().close();
		return list;
	}
	public List findliaisonService() //商家登录显示所有外联的需求列表
	{
			String hql;
			List list;
			LiaisondemandDAO dao=new LiaisondemandDAO();
			hql="select new cn.edu.zjut.po.ShowLiaisondemand(demand.liaisondemandID,demand.publisheddate,demand.period,demand.activityname,demand.mincapital,"
					+ "demand.maxcapital,demand.activitydetail,demand.overallnum,demand.status,demand.conductdetail,"
					+"demand.liaisonuser.liaisonuserID,demand.type,"
					+ "liaison.departmentdetail,liaison.address,liaisonuser.phone)"
					+ "from Liaisondemand demand,Liaison liaison,Liaisonuser liaisonuser Where demand.liaisonuser.liaisonuserID=liaison.liaisonuser.liaisonuserID"
					+ " and liaison.liaisonuser.liaisonuserID=liaisonuser.liaisonuserID";
					list=dao.findByHql(hql);
			
			dao.getSession().close();
			
			return list;
	}
	public boolean updateBusinessInfo(Business business,Login login)   //更新商家信息
	{
		BusinessDAO businessdao=new BusinessDAO();
		LoginDAO logindao=new LoginDAO();
		Transaction tran = null; 
		try
		{
			tran=businessdao.getSession().beginTransaction();
			logindao.update(login);
			business.setLogin(login);
			application.setAttribute("business", business);
			businessdao.update(business);
			tran.commit();
			return true;
		}catch (Exception e) {
			if(tran != null) tran.rollback();
			return false;
			} finally {
			businessdao.getSession().close();
			}
	}
	public boolean updateLiaisonInfo(Liaisonuser liaisonuser,Login login)   //更新外联信息
	{
		LiaisonuserDAO liaisonuserdao=new LiaisonuserDAO();
		LoginDAO logindao=new LoginDAO();
		Transaction tran = null; 
		try
		{
			tran=logindao.getSession().beginTransaction();
			liaisonuser.setLogin(login);
			login.setLiaisonuser(liaisonuser);
			logindao.update(login);
			liaisonuserdao.update(liaisonuser);
			tran.commit();
			application.setAttribute("liaisonuser", liaisonuser);
			return true;
		}catch (Exception e) {
			if(tran != null) tran.rollback();
			return false;
			} finally {
				liaisonuserdao.getSession().close();
			}
	}
	public boolean createLiaisonAssess( Liaisonassess assess,int orderID) //评价外联
	{
		Transaction tran=null;
		LiaisonassessDAO dao=new LiaisonassessDAO();
		try
		{
			tran=dao.getSession().beginTransaction();
			dao.save(assess);
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
