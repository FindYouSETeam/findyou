package cn.edu.zjut.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.bean.OrderItem;
import cn.edu.zjut.po.Business;
import cn.edu.zjut.po.Businessdemand;
import cn.edu.zjut.po.Liaisondemand;
import cn.edu.zjut.po.Liaisonuser;
import cn.edu.zjut.service.ITheorderService;
import cn.edu.zjut.service.IUserService;
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
	private String businessdemandID;
	private String liaisondemandID;
	private ITheorderService orderService =null;
	private IUserService userService =null;
	
	public String getBusinessdemandID() {
		return businessdemandID;
	}
	public void setBusinessdemandID(String businessdemandID) {
		this.businessdemandID = businessdemandID;
	}
	public String getLiaisondemandID() {
		return liaisondemandID;
	}
	public void setLiaisondemandID(String liaisondemandID) {
		this.liaisondemandID = liaisondemandID;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public void setOrderService(ITheorderService orderService) {
		this.orderService = orderService;
	}
	//getter和setter
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
	
	//获取完成的订单
	public String getOrderDone()
	{
		//TheorderService orderServ = new TheorderService();
	 	//IntentionService intenServ = new IntentionService();
	    Business business=(Business) application.getAttribute("business");
	    Liaisonuser liaisonuser=(Liaisonuser) application.getAttribute("liaisonuser");
	    if(business!=null)
	    {	
	    	if(business.getName()!=null)
	    	{
	    		System.out.println("是商家");
	    		doneList = orderService.getOrderByStatusAndBID("完成");
		    	return "Businesssuccess";
	    	}
	    	
	    }
	    if(liaisonuser!=null)
	    {
	    	if(liaisonuser.getName()!=null)
	    	{
	    		System.out.println("是外联");
	    		doneList = orderService.getOrderByStatusAndLID("完成");
				return "Liaisonsuccess";
	    	}
	    }
        return "fail";
	}
	
	//获取进行中的订单
	public String getOrderDoing()
	{
		//TheorderService orderServ = new TheorderService();
		//IntentionService intenServ = new IntentionService();
	    Business business=(Business) application.getAttribute("business");
	    Liaisonuser liaisonuser=(Liaisonuser) application.getAttribute("liaisonuser");
	    if(business!=null)
	    {	
	    	if(business.getName()!=null)
	    	{
	    		doingList = orderService.getOrderByStatusAndBID("进行中");
				return "Businesssuccess";
	    	}
	    }
	    if(liaisonuser!=null)
	    {
	    	if(liaisonuser.getName()!=null)
	    	{
	    		doingList = orderService.getOrderByStatusAndLID("进行中");
	    		System.out.println("ords有用");
	    		
		    	return "Liaisonsuccess";
	        }
	    }
	    
        return "fail";
	}
	
	

	
	
	//完成订单
	public String finishOrder()
	{
	//TheorderService orderServ = new TheorderService();
	//orderServ.finishOrder(orderID);
	    if(orderService.finishOrder(orderID))
	    {
	    	getOrderDoing();
	    	Business business=(Business) application.getAttribute("business");
	    	Liaisonuser liaisonuser=(Liaisonuser) application.getAttribute("liaisonuser");
	    	if(business!=null)
	    	return "Businesssuccess";
	    	else if(liaisonuser!=null)
	    	return "Liaisonsuccess";
	    	else
	    	return "fail";
	    }
	    else
	return "fail";


	}
	public String LiaisonSeeDoingDetail()
	{
		
		System.out.println("in");
		//orderServ.finishOrder(orderID);
		
		Businessdemand businessdemand=userService.findBusinessdemandbyID(Integer.parseInt(businessdemandID));
		Liaisondemand liaisondemand =userService.findLiaisondemandbyID(Integer.parseInt(liaisondemandID));
		int SeeDetail=1;
		application.setAttribute("SeeDetail", SeeDetail);
		application.setAttribute("businessdemand", businessdemand);
		application.setAttribute("liaisondemand", liaisondemand);
		doingList = orderService.getOrderByStatusAndLID("进行中");
		return "LiaisonSeeDoingDetailSuccess";
			
	}
	public String closeLiaisonSeeDoingDetail()
	{
		
		System.out.println("in");
		//orderServ.finishOrder(orderID);
			
		int SeeDetail=0;
		application.setAttribute("SeeDetail", SeeDetail);
		doingList = orderService.getOrderByStatusAndLID("进行中");
		return "closeLiaisonSeeDoingDetailSuccess";
	}
	public String LiaisonSeeDoneDetail()
	{
		
		System.out.println("in");
		//orderServ.finishOrder(orderID);
		
		Businessdemand businessdemand=userService.findBusinessdemandbyID(Integer.parseInt(businessdemandID));
		Liaisondemand liaisondemand =userService.findLiaisondemandbyID(Integer.parseInt(liaisondemandID));
		int SeeDetail=1;
		application.setAttribute("SeeDetail", SeeDetail);
		application.setAttribute("businessdemand", businessdemand);
		application.setAttribute("liaisondemand", liaisondemand);
		doneList = orderService.getOrderByStatusAndLID("完成");
		System.out.println("LiaisonSeeDoneDetailSuccess");
		return "LiaisonSeeDoneDetailSuccess";
			
	}
	public String closeLiaisonSeeDoneDetail()
	{
		
		System.out.println("in");
		//orderServ.finishOrder(orderID);
				
		int SeeDetail=0;
		application.setAttribute("SeeDetail", SeeDetail);
		doneList = orderService.getOrderByStatusAndLID("完成");
		System.out.println("LiaisonSeeDoneDetailSuccess");
		return "closeLiaisonSeeDoneDetailSuccess";
	}
	public String BusinessSeeDoingDetail()
	{
		
		System.out.println("in");
		//orderServ.finishOrder(orderID);
		
		System.out.println(businessdemandID);
		System.out.println(liaisondemandID);
		Businessdemand businessdemand=userService.findBusinessdemandbyID(Integer.parseInt(businessdemandID));
		Liaisondemand liaisondemand =userService.findLiaisondemandbyID(Integer.parseInt(liaisondemandID));
		int SeeDetail=1;
		application.setAttribute("SeeDetail", SeeDetail);
		application.setAttribute("businessdemand", businessdemand);
		application.setAttribute("liaisondemand", liaisondemand);
		doingList = orderService.getOrderByStatusAndBID("进行中");
		return "BusinessSeeDoingDetailSuccess";
			
	}
	public String closeBusinessSeeDoingDetail()
	{
		
		System.out.println("in");
		//orderServ.finishOrder(orderID);
			
		int SeeDetail=0;
		application.setAttribute("SeeDetail", SeeDetail);
		doingList = orderService.getOrderByStatusAndBID("进行中");
		return "closeBusinessSeeDoingDetailSuccess";
	}
	public String BusinessSeeDoneDetail()
	{
		
		System.out.println("in");
		//orderServ.finishOrder(orderID);
		
		System.out.println(businessdemandID);
		System.out.println(liaisondemandID);
		Businessdemand businessdemand=userService.findBusinessdemandbyID(Integer.parseInt(businessdemandID));
		Liaisondemand liaisondemand =userService.findLiaisondemandbyID(Integer.parseInt(liaisondemandID));
		int SeeDetail=1;
		application.setAttribute("SeeDetail", SeeDetail);
		application.setAttribute("businessdemand", businessdemand);
		application.setAttribute("liaisondemand", liaisondemand);
		doneList = orderService.getOrderByStatusAndBID("完成");
		System.out.println("LiaisonSeeDoneDetailSuccess");
		return "BusinessSeeDoneDetailSuccess";
			
	}
	public String closeBusinessSeeDoneDetail()
	{
		
		System.out.println("in");
		//orderServ.finishOrder(orderID);
				
		int SeeDetail=0;
		application.setAttribute("SeeDetail", SeeDetail);
		doneList = orderService.getOrderByStatusAndBID("完成");
		System.out.println("LiaisonSeeDoneDetailSuccess");
		return "closeBusinessSeeDoneDetailSuccess";
	}
	
}
