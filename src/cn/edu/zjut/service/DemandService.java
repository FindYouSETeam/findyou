package cn.edu.zjut.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.zjut.bean.LiaisonDetail;
import cn.edu.zjut.dao.BusinessdemandDAO;
import cn.edu.zjut.dao.IActiveDAO;
import cn.edu.zjut.dao.IBusinessdemandDAO;
import cn.edu.zjut.dao.IIntentionDAO;
import cn.edu.zjut.dao.ILiaisonDAO;
import cn.edu.zjut.dao.ILiaisondemandDAO;
import cn.edu.zjut.dao.IOrderDAO;
import cn.edu.zjut.dao.IShopDAO;
import cn.edu.zjut.dao.IntentionDAO;
import cn.edu.zjut.dao.LiaisonDAO;
import cn.edu.zjut.dao.LiaisondemandDAO;
import cn.edu.zjut.dao.OrderDAO;
import cn.edu.zjut.dao.ShopDAO;
import cn.edu.zjut.po.Business;
import cn.edu.zjut.po.Businessdemand;
import cn.edu.zjut.po.Intention;
import cn.edu.zjut.po.Liaison;
import cn.edu.zjut.po.Liaisondemand;
import cn.edu.zjut.po.Liaisonuser;
import cn.edu.zjut.po.Shop;
import cn.edu.zjut.po.Theorder;

public class DemandService implements IDemandService{
	//HttpServletRequest request=ServletActionContext.getRequest();
	//HttpServletResponse response=ServletActionContext.getResponse();
	//ServletContext application=ServletActionContext.getServletContext();
	//HttpSession session=ServletActionContext.getRequest().getSession();
	//@Autowired
	//private ServletContext application;
	
	private ILiaisondemandDAO liaisondemandDAO=null;
	private IBusinessdemandDAO businessdemandDAO=null;
	private IIntentionDAO intentionDAO=null;
	private IShopDAO shopDAO=null;
	private IOrderDAO orderDAO=null;
	private ILiaisonDAO liaisonDAO=null;
	
	public void setLiaisondemandDAO(ILiaisondemandDAO liaisondemandDAO) {
		this.liaisondemandDAO = liaisondemandDAO;
	}

	public void setBusinessdemandDAO(IBusinessdemandDAO businessdemandDAO) {
		this.businessdemandDAO = businessdemandDAO;
	}

	public void setIntentionDAO(IIntentionDAO intentionDAO) {
		this.intentionDAO = intentionDAO;
	}

	public void setShopDAO(IShopDAO shopDAO) {
		this.shopDAO = shopDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	public void setLiaisonDAO(ILiaisonDAO liaisonDAO) {
		this.liaisonDAO = liaisonDAO;
	}

	public boolean saveliaDemandService(Liaisondemand liaisondemand)  //创建外联需求
	{
		Transaction tran = null; 
		//LiaisondemandDAO dao=new LiaisondemandDAO();
		try
		{
			//tran=dao.getSession().beginTransaction();
			tran=((LiaisondemandDAO) liaisondemandDAO).getSession().beginTransaction();
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String publisheddate=df.format(new Date());
			liaisondemand.setPublisheddate(publisheddate);
			liaisondemand.setStatus("待匹配");
			Liaisonuser liaisonuser=(Liaisonuser)application.getAttribute("liaisonuser");
			liaisondemand.setLiaisonuser(liaisonuser);
			liaisondemandDAO.save(liaisondemand);
			tran.commit();
			return true;
		}
		catch (Exception e) 
		{
			if(tran != null)
				tran.rollback();
			return false;
		} 
		finally 
		{
			//dao.getSession().close();
			((LiaisondemandDAO) liaisondemandDAO).getSession().close();
		}
	}
	
	public boolean savebusinessDemandService(Businessdemand businessdemand)  //创建商家需求
	{
		Transaction tran = null; 
		//BusinessdemandDAO dao=new BusinessdemandDAO();
		try
		{
			//tran=dao.getSession().beginTransaction();
			tran=((BusinessdemandDAO) businessdemandDAO).getSession().beginTransaction();
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String publisheddate=df.format(new Date());
			businessdemand.setPublisheddate(publisheddate);
			businessdemand.setStatus("待匹配");
			Business business=(Business)application.getAttribute("business");
			businessdemand.setBusiness(business);;
			businessdemandDAO.save(businessdemand);
			tran.commit();
			return true;
		}
		catch (Exception e) 
		{
			if(tran != null) 
				tran.rollback();
			return false;
		} 
		finally 
		{
			//dao.getSession().close();
			((BusinessdemandDAO) businessdemandDAO).getSession().close();
		}
	}
	
	public boolean createIntention(Businessdemand businessdemand,Liaisondemand liaisondemand)//外联对商家 有意向
	{
		Transaction tran=null;
		//IntentionDAO dao=new IntentionDAO();
		try
		{
			//tran=dao.getSession().beginTransaction();
			tran=((IntentionDAO) intentionDAO).getSession().beginTransaction();
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String applyDate=df.format(new Date());
			Intention intention=new Intention();
			intention.setApplyDate(applyDate);
			intention.setBusinessdemand(businessdemand);
			intention.setLiaisondemand(liaisondemand);
			intention.setStatus("待回复");
			intention.setWhoApply(false);
			System.out.println("set successfully");
			intentionDAO.save(intention);
			tran.commit();
			return true;
		}
		catch (Exception e) 
		{
			if(tran != null) 
				tran.rollback();
			return false;
		} 
		finally 
		{
			//dao.getSession().close();
			((IntentionDAO) intentionDAO).getSession().close();
		}
	}
	public List findliaisondemand()   //显示外联已有的需求
	{
		String hql;
		Liaisonuser liaisonuser=(Liaisonuser)application.getAttribute("liaisonuser");
		//LiaisondemandDAO dao=new LiaisondemandDAO();
		hql="from Liaisondemand demand WHERE demand.liaisonuser.liaisonuserID="+liaisonuser.getLiaisonuserID();
		List list=liaisondemandDAO.findByHql(hql);
		return list;
	}
	public List findall()  //点击首页显示所有商家意向
	{
		String hql;
		List list;
		//BusinessdemandDAO dao=new BusinessdemandDAO();
		hql="select new cn.edu.zjut.bean.showBusinessdemand(demand.businessdemandID,demand.publisheddate,demand.period,demand.mincapital,"
				+ "demand.maxcapital,demand.overallnum,demand.status,demand.business.businessID,"
				+ "shop.shopID,shop.shopname,shop.qualification,shop.shoptype,shop.shopdetail,shop.shopfront,shop.address) "
				+ "from Businessdemand demand,Shop shop Where demand.business.businessID=shop.business.businessID";
		list=businessdemandDAO.findByHql(hql);
		((BusinessdemandDAO) businessdemandDAO).getSession().close();
		return list;
	}
	
	public List findbusinessrequest()  //显示商家对外联的请求
	{
		Liaisonuser liaisonuser=(Liaisonuser)application.getAttribute("liaisonuser");
		String hql;
		//BusinessdemandDAO dao=new BusinessdemandDAO();
		hql="select new cn.edu.zjut.bean.judgebusiness(shop.shopID,intention.intentionID,shop.shopname,businessdemand.mincapital,businessdemand.maxcapital,businessdemand.publisheddate,businessdemand.overallnum,business.phone)"
				+ "from Shop shop,Businessdemand businessdemand,Business business,Liaisonuser liaisonuser,"
				+ "Liaison liaison,Liaisondemand liaisondemand,Intention intention"
				+ " where liaisonuser.liaisonuserID="+liaisonuser.getLiaisonuserID()
				+ " and liaisonuser.liaisonuserID=liaison.liaisonuser.liaisonuserID and liaisonuser.liaisonuserID=liaisondemand.liaisonuser.liaisonuserID" + 
				" and intention.liaisondemand.liaisondemandID=liaisondemand.liaisondemandID and intention.status='寰呭洖澶�'" + 
				" and intention.businessdemand.businessdemandID=businessdemand.businessdemandID and businessdemand.business.businessID=business.businessID" + 
				" and business.businessID=shop.business.businessID and intention.whoApply=1";
		List list=businessdemandDAO.findByHql(hql);
		((BusinessdemandDAO) businessdemandDAO).getSession().close();
		return list;
	}
	public List findliaisonrequest() //显示外联对商家的请求
	{
		Business business=(Business)application.getAttribute("business");
		String hql;
		System.out.println(business.getBusinessID());
		//LiaisondemandDAO dao=new LiaisondemandDAO();
		hql="select new cn.edu.zjut.bean.judgeliaison(liaison.liaisonID,intention.intentionID,liaison.departmentdetail,liaisondemand.activityname,liaisondemand.mincapital,liaisondemand.maxcapital,liaisondemand.publisheddate,liaison.liaisonuser.phone)"
				+ " from Liaison liaison,Liaisondemand liaisondemand,Liaisonuser liaisonuser,Business business,Shop shop,Businessdemand businessdemand,Intention intention"
				+ " where business.businessID="+business.getBusinessID()
				+ " and business.businessID=shop.business.businessID and business.businessID=businessdemand.business.businessID"
				+ " and intention.businessdemand.businessdemandID=businessdemand.businessdemandID and intention.status='寰呭洖澶�'"
				+ " and intention.liaisondemand.liaisondemandID=liaisondemand.liaisondemandID and liaisondemand.liaisonuser.liaisonuserID=liaisonuser.liaisonuserID"
				+ " and liaisonuser.liaisonuserID=liaison.liaisonuser.liaisonuserID and intention.whoApply=0";
		List list=liaisondemandDAO.findByHql(hql);
		((LiaisondemandDAO) liaisondemandDAO).getSession().close();
		return list;
	}
	public Liaison findLiaisonbyID(int liaisonID) //用外联ID查找外联组织信息
	{
		String hql;
		//LiaisonDAO dao=new LiaisonDAO();
		hql="from Liaison liaison where liaison.liaisonID="+liaisonID;
		List list=liaisonDAO.findByHql(hql);
		((LiaisonDAO) liaisonDAO).getSession().close();
		return (Liaison)list.get(0);
	}
	public Shop findShopbyID(int shopID)//用店铺ID查找店铺信息
	{
		String hql;
		//ShopDAO dao=new ShopDAO();
		hql="from Shop shop where shop.shopID="+shopID;
		List list=shopDAO.findByHql(hql);
		((ShopDAO) shopDAO).getSession().close();
		return (Shop)list.get(0);
	}
	public LiaisonDetail findliaisonbyID(int liaisonuserID)//用外联ID查找外联信息
	{
		String hql;
		//LiaisonDAO dao=new LiaisonDAO();
		hql="select new cn.edu.zjut.bean.LiaisonDetail(liaison.departmentdetail,liaison.address,liaison.liaisonuser.phone)"
				+ " from Liaison liaison,Liaisonuser liaisonuser"
				+ " where liaison.liaisonuser.liaisonuserID="+liaisonuserID;
		List list=liaisonDAO.findByHql(hql);
		((LiaisonDAO) liaisonDAO).getSession().close();
		return (LiaisonDetail)list.get(0);
	}
	public Intention findIntentionbyID(int intentionID) //用intentionID查找对应intention
	{
		String hql;
		//IntentionDAO dao=new IntentionDAO();
		hql="from Intention intention where intention.intentionID="+intentionID;
		List list=intentionDAO.findByHql(hql);
		((IntentionDAO) intentionDAO).getSession().close();
		return (Intention)list.get(0);
	}
	public boolean rejectBusinessOrnot(int reject,int intentionID)  //拒绝或是接受请求
	{
		Transaction tran = null; 
		//OrderDAO dao=new OrderDAO();
		//IntentionDAO intentiondao=new IntentionDAO();
		//LiaisondemandDAO liadao=new LiaisondemandDAO();
		//BusinessdemandDAO businessdao=new BusinessdemandDAO();
		Intention intention=(Intention)findIntentionbyID(intentionID);
		if(reject==0)
		{
			try
			{
				tran=((OrderDAO) orderDAO).getSession().beginTransaction();
				Theorder order=new Theorder();
				order.setBusinessdemand(intention.getBusinessdemand());
				order.setLiaisondemand(intention.getLiaisondemand());
				order.setOrderID(intention.getIntentionID());
				DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String startTime=df.format(new Date());
				order.setStartTime(startTime);
				intention.setStatus("同意");
				Liaisondemand liaisondemand=intention.getLiaisondemand();
				Businessdemand businessdemand=intention.getBusinessdemand();
				businessdemand.setStatus("匹配成功");
				liaisondemand.setStatus("匹配成功");
				liaisondemandDAO.update(liaisondemand);
				businessdemandDAO.update(businessdemand);
				orderDAO.save(order);
				intentionDAO.update(intention);
				tran.commit();
				return true;
			}
			catch (Exception e) 
			{
				if(tran != null) 
					tran.rollback();
				return false;
			} 
			finally 
			{
				((OrderDAO) orderDAO).getSession().close();
			}
		}
		else
		{
			try
			{
				tran=((IntentionDAO) intentionDAO).getSession().beginTransaction();
				intention.setStatus("拒绝");
				intentionDAO.update(intention);
				tran.commit();
				return true;
			}catch (Exception e) {
				if(tran != null) tran.rollback();
				return false;
				} finally {
				((OrderDAO) orderDAO).getSession().close();
				}
		}
	}
}
