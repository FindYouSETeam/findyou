// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IntentionService.java

package cn.edu.zjut.service;

import cn.edu.zjut.dao.IntentionDAO;
import cn.edu.zjut.po.Business;
import cn.edu.zjut.po.Intention;
import cn.edu.zjut.po.Liaisonuser;

import java.io.PrintStream;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class IntentionService
{
	HttpServletRequest request =ServletActionContext.getRequest();
    HttpServletResponse response= ServletActionContext.getResponse();
    ServletContext application= ServletActionContext.getServletContext();
    HttpSession session= ServletActionContext.getRequest().getSession();
    
    //����liaisionuserID��ȡ���û������¼
    public List getIntentionByLID()
    {
    	Liaisonuser user = (Liaisonuser)application.getAttribute("liaisonuser");
        int LID = user.getLiaisonuserID();
        String hql = "select new cn.edu.zjut.bean.IntentionItem(shop.shopname,shop.shopID, intention.businessdemand.businessdemandID,intention.liaisondemand.liaisondemandID, "
        		+ "liaisondemand.mincapital,liaisondemand.maxcapital,intention.applyDate,intention.status, intention.intentionID)"
        		+ "from Shop shop,Businessdemand businessdemand,Business business,Liaisonuser liaisonuser,Liaison liaison,Liaisondemand liaisondemand,Intention intention "
        		+ "where liaisonuser.liaisonuserID="+LID+" and whoApply=0 "
        		+ "and liaisonuser.liaisonuserID=liaison.liaisonuser.liaisonuserID and liaisonuser.liaisonuserID=liaisondemand.liaisonuser.liaisonuserID "
        		+ "and intention.liaisondemand.liaisondemandID=liaisondemand.liaisondemandID and intention.businessdemand.businessdemandID=businessdemand.businessdemandID "
        		+ "and businessdemand.business.businessID=business.businessID and business.businessID=shop.business.businessID ";
        IntentionDAO dao = new IntentionDAO();
        List list = dao.findByHql(hql);
        dao.getSession().close();
        return list;
    }
    
    //����bussinessID��ȡ���û������¼
    public List getIntentionByBID()
    {
        Business user = (Business)application.getAttribute("business");
        int BID = user.getBusinessID();
        System.out.println("商家开查");
        System.out.println(BID);
        String hql = "select new cn.edu.zjut.bean.IntentionItem(liaison.departmentdetail,liaison.liaisonID, intention.businessdemand.businessdemandID,"
        		+ "intention.liaisondemand.liaisondemandID, liaisondemand.mincapital,liaisondemand.maxcapital,intention.applyDate,intention.status, intention.intentionID)"
        		+ "from Shop shop,Businessdemand businessdemand,Business business,Liaisonuser liaisonuser,Liaison liaison,Liaisondemand liaisondemand,Intention intention "
        		+ "where business.businessID="+BID+" and whoApply=1 "
        		+ "and liaisonuser.liaisonuserID=liaison.liaisonuser.liaisonuserID and liaisonuser.liaisonuserID=liaisondemand.liaisonuser.liaisonuserID "
        		+ "and intention.liaisondemand.liaisondemandID=liaisondemand.liaisondemandID and intention.businessdemand.businessdemandID=businessdemand.businessdemandID "
        		+ "and businessdemand.business.businessID=business.businessID and business.businessID=shop.business.businessID ";
        IntentionDAO dao = new IntentionDAO();
        System.out.println(hql);
        List list = dao.findByHql(hql);
        dao.getSession().close();
        return list;
    }
    
    //����intentionID����intention����
    public Intention findIntentionByIID(int intentionID)
    {
        IntentionDAO dao = new IntentionDAO();
        String hql = "from Intention where intentionID="+intentionID;
        List list = dao.findByHql(hql);
        dao.getSession().close();
        return (Intention)list.get(0);
    }
    
    //����intentionIDȡ��һ��intention
    public boolean cancelIntention(int intentionID)
    {
    	IntentionDAO dao=new IntentionDAO();
        Transaction tran=null;
		try 
		{ 
		    
		     //System.out.println("service1");
		     Intention intention = findIntentionByIID(intentionID);
		     //System.out.println("service2"); 
		     
		     tran = dao.getSession().beginTransaction();
		     intention.setStatus("已取消");
		     dao.update(intention);
		     //System.out.println("service3");
		     tran.commit();
		     dao.getSession().close();
		     return true;
		} 
		catch (Exception e) 
		{ 
			if(tran!= null) 
				tran.rollback(); 
			return false;
		} 
		finally 
		{
			dao.getSession().close();
		}
    } 
}
