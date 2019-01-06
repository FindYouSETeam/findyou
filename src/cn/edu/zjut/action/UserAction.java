package cn.edu.zjut.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.bean.LiaisonDetail;
import cn.edu.zjut.po.*;
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
	private List liaisondemandlist;
	private int orderID;
	private Shopassess shopassess;
	private Liaisonassess liaisonassess;
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
			demandlist=userServ.findliaisonService();   
			return "gotobusiness";
		}
		if(flag==true&&type.equals("liaisonuser"))
		{
			demandlist=userServ.findallbusinessService();
			liaisondemandlist=demandServ.findliaisondemand();
			return "gotoliaisonuser";
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
		UserService userServ=new UserService();
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
	
}
