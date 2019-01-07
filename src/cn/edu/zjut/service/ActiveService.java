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

import cn.edu.zjut.dao.ActiveDAO;
import cn.edu.zjut.dao.BusinessDAO;
import cn.edu.zjut.dao.BusinessdemandDAO;
import cn.edu.zjut.dao.IActiveDAO;
import cn.edu.zjut.dao.LiaisonuserDAO;
import cn.edu.zjut.dao.LoginDAO;
import cn.edu.zjut.po.Business;
import cn.edu.zjut.po.Businessdemand;
import cn.edu.zjut.po.Liaisondemand;
import cn.edu.zjut.po.Liaisonuser;
import cn.edu.zjut.po.Login;
import cn.edu.zjut.po.Shopactive;
import cn.edu.zjut.po.Theorder;

public class ActiveService implements IActiveService{
	//HttpServletRequest request=ServletActionContext.getRequest();
	//HttpServletResponse response=ServletActionContext.getResponse();
	//ServletContext application=ServletActionContext.getServletContext();
	//HttpSession session=ServletActionContext.getRequest().getSession();
	
	private IActiveDAO activeDAO=null;
	
	public void setActiveDAO(IActiveDAO activeDAO) {
		this.activeDAO = activeDAO;
	}
	
	public boolean AddActive(Shopactive shopactive)  //创建商家营销活动
	{
		Transaction tran = null; 
		//ActiveDAO dao=new ActiveDAO();
		try
		{
			//dao.getSession().beginTransaction();
			tran=((ActiveDAO) activeDAO).getSession().beginTransaction();
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String publisheddate=df.format(new Date());
			shopactive.setPublisheddate(publisheddate);
			Business business=(Business)application.getAttribute("business");
			shopactive.setBusiness(business);
			activeDAO.save(shopactive);
			tran.commit();
			return true;
		}
		catch (Exception e) 
		{
			if(tran != null) tran.rollback();
			return false;
		} finally 
		{
			//dao.getSession().close();
			((ActiveDAO) activeDAO).getSession().close();
		}
	}
	public List findMyShopActive()  //显示自己的营销活动
	{
		Business business=(Business)application.getAttribute("business");
		String hql;
		//ActiveDAO dao=new ActiveDAO();
		
		hql="from Shopactive where businessID="+business.getBusinessID();
		List list=activeDAO.findByHql(hql);
		//dao.getSession().close();
		((ActiveDAO) activeDAO).getSession().close();
		return list;
	}
	public List findAllShopActive()  //显示所有的营销活动
	{
		
		String hql;
		//ActiveDAO dao=new ActiveDAO();
		hql="select new cn.edu.zjut.bean.AllShopActive(shop.shopname,shopactive.title,"
				+ "shopactive.description,shopactive.publisheddate) "
				+ "from Shop shop,Shopactive shopactive Where shop.business.businessID=shopactive.business.businessID";
		List list=activeDAO.findByHql(hql);
		//dao.getSession().close();
		((ActiveDAO) activeDAO).getSession().close();
		return list;
	}

	public boolean delMyShopActive(Shopactive shopactive)  //删除某条自己的营销活动
	{
		Transaction tran = null; 
		//ActiveDAO dao=new ActiveDAO();		
		//dao.getSession().close();
		((ActiveDAO) activeDAO).getSession().close();
		try
		{
			tran=((ActiveDAO) activeDAO).getSession().beginTransaction();
			activeDAO.del(shopactive);
			tran.commit();
			return true;
		}
		catch (Exception e) 
		{
			if(tran != null) tran.rollback();
			return false;
		} 
		finally 
		{
			//dao.getSession().close();
			((ActiveDAO)activeDAO).getSession().close();
		}
	}
	
	public Shopactive findbyID(int i) //根据ID查出某个营销活动
	{
		String hql;
		hql="from Shopactive where shopactiveID="+i;
		//ActiveDAO dao=new ActiveDAO();
		Shopactive shopactive=activeDAO.findById(i);
		application.setAttribute("Shopactive", shopactive);
		return shopactive;
	}
	public boolean updateShopActiveInfo(Shopactive shopactive)  //更新营销活动信息
	{
		//ActiveDAO dao=new ActiveDAO();
		Transaction tran = null;
		shopactive.setBusiness((Business)application.getAttribute("business"));
		System.out.println(shopactive.getDescription());
		System.out.println(shopactive.getShopactiveID());
		System.out.println(shopactive.getTitle());
		System.out.println(shopactive.getPublisheddate());
		System.out.println(shopactive.getBusiness().getName());
		try
		{
			//tran=dao.getSession().beginTransaction();
			tran=((ActiveDAO) activeDAO).getSession().beginTransaction();
			activeDAO.update(shopactive);
			tran.commit();
			return true;
		}
		catch (Exception e) 
		{
			if(tran != null) tran.rollback();
			return false;
		} 
		finally 
		{
			//dao.getSession().close();
			((ActiveDAO) activeDAO).getSession().close();
		}
	}
}
