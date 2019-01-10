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
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zjut.dao.IIntentionDAO;
import cn.edu.zjut.dao.IOrderDAO;
import cn.edu.zjut.dao.IntentionDAO;
import cn.edu.zjut.dao.OrderDAO;
import cn.edu.zjut.po.Business;
import cn.edu.zjut.po.Intention;
import cn.edu.zjut.po.Liaisonuser;
import cn.edu.zjut.po.Theorder;

public class TheorderService implements ITheorderService{
	//HttpServletRequest request =ServletActionContext.getRequest();
    //HttpServletResponse response= ServletActionContext.getResponse();
    //ServletContext application= ServletActionContext.getServletContext();
    //HttpSession session= ServletActionContext.getRequest().getSession();
	
    private IOrderDAO orderDAO=null; 
	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	

	//根据LiaisonuserID和status获取不同状态的order
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
		//IntentionDAO dao = new IntentionDAO();
		System.out.println(hql);
	    //List list = dao.findByHql(hql);
	    //dao.getSession().close();

        List list = orderDAO.findByHql(hql);

        //((OrderDAO) orderDAO).getSession().close();
	    return list;
	}
	
	//根据BusinessID和status获取不同状态的order
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
		//IntentionDAO dao = new IntentionDAO();
		System.out.println(hql);
	    //List list = dao.findByHql(hql);
	    //dao.getSession().close();

        List list = orderDAO.findByHql(hql);

        //((OrderDAO) orderDAO).getSession().close();
	    return list;
	}
	
	//根据orderID获取order
	 public Theorder findOrderByOID(int orderID)
	    {
	        //OrderDAO dao = new OrderDAO();
	        String hql = "from Theorder where orderID="+orderID;
	        //List list = dao.findByHql(hql);
	        //dao.getSession().close();

            List list = orderDAO.findByHql(hql);

            //((OrderDAO) orderDAO).getSession().close();
	        return (Theorder) list.get(0);
	    }
	 
	 //完成订单
	 public boolean finishOrder(int orderID)
	    {
		 	//OrderDAO dao=new OrderDAO();
            ///Transaction tran=null;
			try 
			{ 
			     Theorder order= findOrderByOID(orderID);
			     //tran = dao.getSession().beginTransaction();
                /// tran = ((OrderDAO) orderDAO).getSession().beginTransaction();
                System.out.println(order.getOrderID());
                System.out.println(order.getStartTime());
                // order.setOrderID(4);
			     order.setStatus("完成");
			     DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 String finishTime=df.format(new Date());
				 order.setFinishTime(finishTime);
                System.out.println("set");
                System.out.println(order.getFinishTime());
                System.out.println(order.getStatus());
				 orderDAO.update(order);
                System.out.println("update");

                ///tran.commit();

                System.out.println("commit");
                // ((OrderDAO) orderDAO).getSession().close();
                System.out.println("close");
                //((OrderDAO) orderDAO).getSession().flush();
			     return true;
			} 
			catch (Exception e) 
			{
                ///if(tran != null)
                ///tran.rollback();
				return false;
			} 
			finally 
			{
                //((OrderDAO) orderDAO).getSession().close();
                System.out.println("close");
			}
	    } 
}
