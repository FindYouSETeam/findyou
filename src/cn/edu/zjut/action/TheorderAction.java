package cn.edu.zjut.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.bean.OrderItem;
import cn.edu.zjut.po.Business;
import cn.edu.zjut.po.Liaisonuser;
import cn.edu.zjut.service.IntentionService;
import cn.edu.zjut.service.TheorderService;

public class TheorderAction {
	HttpServletRequest request= ServletActionContext.getRequest();
    HttpServletResponse response= ServletActionContext.getResponse();
    ServletContext application= ServletActionContext.getServletContext();
    HttpSession session= ServletActionContext.getRequest().getSession();
	private List doneList;
	private List doingList;
	private int orderID;
	
	//getter��setter
	public List getDoneList() {
		return doneList;
	}
	public void setDoneList(List doneList) {
		this.doneList = doneList;
	}
	public List getDoingList() {
		return doingList;
	}
	public void setDoingList(List doingList) {
		this.doingList = doingList;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	//获取商家或外联已完成订单
	public String getOrderDone()
	{
		TheorderService orderServ = new TheorderService();
	 	IntentionService intenServ = new IntentionService();
	    Business business=(Business) application.getAttribute("business");
	    Liaisonuser liaisonuser=(Liaisonuser) application.getAttribute("liaisonuser");
	    if(business!=null)
	    {	
	    	if(business.getName()!=null)
	    	{
	    		System.out.println("是商家");
	    		doneList = orderServ.getOrderByStatusAndBID("完成");
		    	return "Businesssuccess";
	    	}
	    	
	    }
	    if(liaisonuser!=null)
	    {
	    	if(liaisonuser.getName()!=null)
	    	{
	    		System.out.println("是外联");
	    		doneList = orderServ.getOrderByStatusAndLID("完成");
				return "Liaisonsuccess";
	    	}
	    }
        return "fail";
	}
	
	//��ȡ�����еĶ����б�
	public String getOrderDoing()
	{
		TheorderService orderServ = new TheorderService();
		IntentionService intenServ = new IntentionService();
	    Business business=(Business) application.getAttribute("business");
	    Liaisonuser liaisonuser=(Liaisonuser) application.getAttribute("liaisonuser");
	    if(business!=null)
	    {	
	    	if(business.getName()!=null)
	    	{
	    		doingList = orderServ.getOrderByStatusAndBID("进行中");
				return "Businesssuccess";
	    	}
	    }
	    if(liaisonuser!=null)
	    {
	    	if(liaisonuser.getName()!=null)
	    	{
	    		doingList = orderServ.getOrderByStatusAndLID("进行中");
		    	return "Liaisonsuccess";
	        }
	    }
	    
        return "fail";
	}
	
	//������תΪ���
	public String finishOrder()
	{
		TheorderService orderServ = new TheorderService();
		//orderServ.finishOrder(orderID);
	    if(orderServ.finishOrder(orderID))
	    {
	    	getOrderDoing();
	    	return "success";
	    }
	    else
			return "failed";	
	}
	
}
