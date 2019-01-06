package cn.edu.zjut.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.po.*;
import cn.edu.zjut.bean.*;
import cn.edu.zjut.bean.showBusinessdemand;
import cn.edu.zjut.service.AdminService;
import cn.edu.zjut.service.DemandService;
import cn.edu.zjut.service.UserService;
public class UserAction{
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	ServletContext application=ServletActionContext.getServletContext();
	HttpSession session=ServletActionContext.getRequest().getSession();
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Liaisonuser getLiaisonuser() {
		return liaisonuser;
	}
	public void setLiaisonuser(Liaisonuser liaisonuser) {
		this.liaisonuser = liaisonuser;
	}
	public Liaison getLiaison() {
		return liaison;
	}
	public void setLiaison(Liaison liaison) {
		this.liaison = liaison;
	}
	private Business business;
	private Login login;
	private Shop shop;
	private Liaisonuser liaisonuser;
	private Liaison liaison;
	private List demandlist;
	private List businessdemandlist;
	private List liaisondemandlist;
	private int orderID;
	private Shopassess shopassess;
	private Liaisonassess liaisonassess;
	private List judgeliaisonlist;
	private List judgebusinesslist;
	private String pass;
	private String  liaisonuserID;
	private String businessID;
	
	
	
	public List getBusinessdemandlist() {
		return businessdemandlist;
	}
	public void setBusinessdemandlist(List businessdemandlist) {
		this.businessdemandlist = businessdemandlist;
	}
	public String getBusinessID() {
		return businessID;
	}
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}
	public String getLiaisonuserID() {
		return liaisonuserID;
	}
	public void setLiaisonuserID(String liaisonuserID) {
		this.liaisonuserID = liaisonuserID;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public List getJudgeliaisonlist() {
		return judgeliaisonlist;
	}
	public void setJudgeliaisonlist(List judgeliaisonlist) {
		this.judgeliaisonlist = judgeliaisonlist;
	}
	public List getJudgebusinesslist() {
		return judgebusinesslist;
	}
	public void setJudgebusinesslist(List judgebusinesslist) {
		this.judgebusinesslist = judgebusinesslist;
	}
	public Shopassess getShopassess() {
		return shopassess;
	}
	public void setShopassess(Shopassess shopassess) {
		this.shopassess = shopassess;
	}
	public Liaisonassess getLiaisonassess() {
		return liaisonassess;
	}
	public void setLiaisonassess(Liaisonassess liaisonassess) {
		this.liaisonassess = liaisonassess;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public List getDemandlist() {
		return demandlist;
	}
	public void setDemandlist(List demandlist) {
		this.demandlist = demandlist;
	}


	public List getLiaisondemandlist() {
		return liaisondemandlist;
	}
	public void setLiaisondemandlist(List liaisondemandlist) {
		this.liaisondemandlist = liaisondemandlist;
	}
	public UserAction() {
		
	}
	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}
	public String business_register_detail()  //商家注册详细
	{
		UserService userServ =new UserService();
		if(userServ.business_register_detail(business,shop))
		{
			return "business_register_detailsuccess";
		}
		else return "business_register_detailfail";
	}
	public String business_register_basic() //商家注册基础
	{
		UserService userServ =new UserService();
		if(userServ.business_register_basic(business,login))
		return "business_register_basicsuccess";
		else
		return "business_register_basicfail";
	}
	public String user_register_detail() //用户注册详细
	{
		UserService userServ =new UserService();
		if(userServ.user_register_detail(liaisonuser,liaison))
		{
			return "user_register_detailsuccess";
		}
		else return "user_register_detailfail";
	}
	public String user_register_basic()//用户注册基础
	{
		UserService userServ =new UserService();
		if(userServ.user_register_basic(liaisonuser,login))
		return "user_register_basicsuccess";
		else
		return "user_register_basicfail";
	}
	public String login() {  //登录
		String type=request.getParameter("type");
		UserService userServ =new UserService();
		DemandService demandServ=new DemandService();
		boolean flag=userServ.LoginService(login, type);
		if(flag==true&&type.equals("business"))
		{
			System.out.println("商家判断一下账号");
			Business business=(Business) application.getAttribute("business");
			System.out.println(business.getAuditing());
			if(business.getAuditing()==-1)
				return "refuse";
			else if(business.getAuditing()==0)
				return "wait";
			else
			{
				
				int intbusinessID=business.getBusinessID();
				System.out.println("ID"+intbusinessID);
				businessdemandlist=userServ.findBusinessdemandbybussinessID(intbusinessID);
				System.out.println("size"+businessdemandlist.size());
				System.out.println(((showBusinessdemand)businessdemandlist.get(0)).getPublisheddate());
				demandlist=userServ.findliaisonService();   
				return "gotobusiness";
			}
		}
		else if(flag==true&&type.equals("liaisonuser"))
		{
			Liaisonuser liaisonuser=(Liaisonuser) application.getAttribute("liaisonuser");
			if(liaisonuser.getAuditing()==-1)
				return "refuse";
			else if(liaisonuser.getAuditing()==0)
				return "wait";
			else
			{
				demandlist=userServ.findallbusinessService();
				liaisondemandlist=demandServ.findliaisondemand();
				return "gotoliaisonuser";
			}			
		}
		else if(type.equals("admin"))
		{
			return "gotoadmin";
		}
		else
		{
			return "loginfail";
		}
	}
	public String exit() {  //退出
		Liaisonuser liaisonuser =new Liaisonuser();
		Business business=new Business();
		System.out.println("退出");
		application.setAttribute("business", business);
		application.setAttribute("liaisonuser", liaisonuser);
		return "success";
	}
	public String updateBusinessInfo()  //修改商家信息
	{
		UserService userServ=new UserService();
		if(userServ.updateBusinessInfo(business, login))
		{
			return "updatesuccess";
		}
		else return "upatefail";
	}
	public String updateLiaisonInfo()  //修改外联信息
	{
		UserService userServ=new UserService();
		if(userServ.updateLiaisonInfo(liaisonuser, login))  
		{
			return "updatesuccess";
		}
		else return "updatefail";
	}
	public String findallbusiness()   //外联页面点击首页显示所有的商家列表
	{
		DemandService demandServ=new DemandService();
		UserService userServ=new UserService();
		demandlist=userServ.findallbusinessService();
		liaisondemandlist=demandServ.findliaisondemand();
		return "success";
	}
	public String findallliaison()   //商家页面点击首页显示所有的外联列表
	{
		System.out.println("点击回首页按钮");
		UserService userServ=new UserService();
		Business business=(Business) application.getAttribute("business");
		int businessID=business.getBusinessID();
		businessdemandlist=userServ.findBusinessdemandbybussinessID(businessID);
		demandlist=userServ.findliaisonService();   
		
		return "success";
	}
	public String CreateShopAssess(int orderID) //评价商店
	{
		Theorder t=new Theorder();
		t.setOrderID(orderID);
		System.out.println("开始评价");
		System.out.println(orderID);
		shopassess.setTheorder(t);
		UserService userServ=new UserService();
		if(userServ.createShopAssess(shopassess,orderID))
		{
			return "createsuccess";
		}
		else return "createfail";
		
	}
	public String CreateLiaisonAssess()//评价外联
	{
		Theorder t=new Theorder();
		t.setOrderID(orderID);
		System.out.println("开始评价");
		System.out.println(orderID);
		liaisonassess.setTheorder(t);
		UserService userServ=new UserService();
		if(userServ.createLiaisonAssess(liaisonassess,orderID))
		{
			return "createsuccess";
		}
		else return "createfail";
		
	}
	public String GoCreateLiaisonAssess()//跳转评价外联
	{		
		System.out.println("进入action");
		System.out.println(orderID);
		application.setAttribute("orderID", orderID);
		System.out.println("获取到");
			return "createsuccess";
	}
	public String GoCreateShopAssess()//跳转评价商家
	{		
		System.out.println("进入action");
		System.out.println(orderID);
		application.setAttribute("orderID", orderID);
		System.out.println("获取到");
			return "createsuccess";
	}
	public String judgeliaison()  //跳转审核外联页
	{
		AdminService adminServ =new AdminService();
		judgeliaisonlist=adminServ.liaisonJudge();
		application.setAttribute("judgeliaisonlist", judgeliaisonlist);
		return "success";
	}
	public String judgebusiness()
	{
		AdminService adminServ =new AdminService();
		judgebusinesslist=adminServ.businessJudge();
		application.setAttribute("judgebusinesslist", judgebusinesslist);
		return "success";
	}
	public String passliaison()
	{
		AdminService adminServ =new AdminService();
		if(pass.equals("1"))
		{
			if(adminServ.passliaison(Integer.parseInt(liaisonuserID))==true)
			{
				return "success";
			}
			else
			{
				return "fail";
			}
		}
		else
		{
			if(adminServ.refuseliaison(Integer.parseInt(liaisonuserID))==true)
			{
				return "success";
			}
			else
			{
				return "fail";
			}
		}
	}
	
	
	public String passbusiness()
	{
		AdminService adminServ =new AdminService();
		if(pass.equals("1"))
		{
			if(adminServ.passbusiness(Integer.parseInt(businessID))==true)
			{
				return "success";
			}
			else
			{
				return "fail";
			}
		}
		else
		{
			if(adminServ.refusebusiness(Integer.parseInt(businessID))==true)
			{
				return "success";
			}
			else
			{
				return "fail";
			}
		}
	}
	
}
