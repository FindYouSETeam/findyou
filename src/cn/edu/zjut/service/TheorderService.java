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

import cn.edu.zjut.dao.IntentionDAO;
import cn.edu.zjut.dao.OrderDAO;
import cn.edu.zjut.po.Business;
import cn.edu.zjut.po.Intention;
import cn.edu.zjut.po.Liaisonuser;
import cn.edu.zjut.po.Theorder;

public class TheorderService {
	HttpServletRequest request =ServletActionContext.getRequest();
    HttpServletResponse response= ServletActionContext.getResponse();
    ServletContext application= ServletActionContext.getServletContext();
    HttpSession session= ServletActionContext.getRequest().getSession();
    
	//���ݶ���״̬���Ҷ���
	public List getOrderByStatusAndLID(String status)
	{
		Liaisonuser user = (Liaisonuser)application.getAttribute("liaisonuser");
        int LID = user.getLiaisonuserID();
		//int LID=1;
		String hql="select new cn.edu.zjut.bean.OrderItem(theorder.orderID,theorder.businessdemand.businessdemandID,"
				+ "theorder.liaisondemand.liaisondemandID,theorder.startTime,theorder.finishTime,theorder.status)" 
					+ "from Theorder theorder,Liaisondemand liaisondemand,Liaisonuser liaisonuser " 
					+ " where liaisonuser.liaisonuserID="+LID+" and theorder.status='" + status+ "'"
					+ " and theorder.liaisondemand.liaisondemandID=liaisondemand.liaisondemandID and liaisondemand.liaisonuser.liaisonuserID=liaisonuser.liaisonuserID";		
		IntentionDAO dao = new IntentionDAO();
		System.out.println(hql);
	    List list = dao.findByHql(hql);
	    dao.getSession().close();
	    return list;
	}
	
	public List getOrderByStatusAndBID(String status)
	{
		Business user = (Business)application.getAttribute("business");
	    int BID = user.getBusinessID();
		//int BID=1;
	    String hql="select new cn.edu.zjut.bean.OrderItem(theorder.orderID,theorder.businessdemand.businessdemandID,"
				+ "theorder.liaisondemand.liaisondemandID,theorder.startTime,theorder.finishTime,theorder.status)" 
					+ "from Theorder theorder,Businessdemand businessdemand,Business business " 
					+ " where business.businessID="+BID+" and theorder.status='" + status+ "'"
					+ " and theorder.businessdemand.businessdemandID=businessdemand.businessdemandID and businessdemand.business.businessID=business.businessID";	
		IntentionDAO dao = new IntentionDAO();
		System.out.println(hql);
	    List list = dao.findByHql(hql);
	    dao.getSession().close();
	    return list;
	}
	
	//����order��ȡ����
	 public Theorder findOrderByOID(int orderID)
	    {
	        OrderDAO dao = new OrderDAO();
	        String hql = "from Theorder where orderID="+orderID;
	        List list = dao.findByHql(hql);
	        dao.getSession().close();
	        return (Theorder) list.get(0);
	    }
	 
	 //��ɶ���
	 public boolean finishOrder(int orderID)
	    {
		 	OrderDAO dao=new OrderDAO();
	        Transaction tran=null;
			try 
			{ 
			     Theorder order= findOrderByOID(orderID);
			     //�����ô���
			     /*System.out.println("ID:"+order.getOrderID());
			     System.out.println("ST:"+order.getStartTime());
			     System.out.println("FT:"+order.getFinishTime());
			     System.out.println("FT:"+order.getStatus());*/
			    
			      tran = dao.getSession().beginTransaction();
			     //����״̬Ϊ���
			     order.setStatus("完成");
			     
			     //�������ʱ��
			     DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 String finishTime=df.format(new Date());
				 order.setFinishTime(finishTime);
			     dao.update(order);
			     
			     //�����ô���
			     /*System.out.println("ID:"+order.getOrderID());
			     System.out.println("ST:"+order.getStartTime());
			     System.out.println("FT:"+order.getFinishTime());
			     System.out.println("FT:"+order.getStatus());
			     System.out.println("BD:"+order.getBusinessdemand().getBusinessdemandID());
			     System.out.println("LD:"+order.getLiaisondemand().getLiaisondemandID());*/
			     
			     tran.commit();
			     dao.getSession().close();
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
				dao.getSession().close();
			}
	    } 
}
