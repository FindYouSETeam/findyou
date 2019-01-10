package cn.edu.zjut.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.bean.LiaisonDetail;
import cn.edu.zjut.po.Business;
import cn.edu.zjut.po.Businessdemand;
import cn.edu.zjut.po.Liaison;
import cn.edu.zjut.po.Liaisondemand;
import cn.edu.zjut.po.Liaisonuser;
import cn.edu.zjut.po.Shop;
import cn.edu.zjut.service.DemandService;
import cn.edu.zjut.service.IDemandService;
import cn.edu.zjut.service.IUserService;
import cn.edu.zjut.service.UserService;

public class DemandAction {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	ServletContext application=ServletActionContext.getServletContext();
	HttpSession session=ServletActionContext.getRequest().getSession();
	private Liaisondemand liaisondemand;
	private Businessdemand businessdemand;
	private LiaisonDetail liaisondetail;
	private List historybusinessdemandlist;
	private List historyliaisondemandlist;
	private IDemandService demandService=null;
	private IUserService userService=null;
	public void setDemandService(IDemandService demandService) {
		this.demandService = demandService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public LiaisonDetail getLiaisondetail() {
		return liaisondetail;
	}
	public void setLiaisondetail(LiaisonDetail liaisondetail) {
		this.liaisondetail = liaisondetail;
	}
	public Businessdemand getBusinessdemand() {
		return businessdemand;
	}
	public void setBusinessdemand(Businessdemand businessdemand) {
		this.businessdemand = businessdemand;
	}
	private List liaisonList;
	private List demandlist;
	public List getDemandlist() {
		return demandlist;
	}
	public void setDemandlist(List demandlist) {
		this.demandlist = demandlist;
	}
	private List businessrequestList;
	private List liaisonrequestList;
	public List getLiaisonrequestList() {
		return liaisonrequestList;
	}
	public void setLiaisonrequestList(List liaisonrequestList) {
		this.liaisonrequestList = liaisonrequestList;
	}
	private String liaisonID;
	public String getLiaisonID() {
		return liaisonID;
	}
	public void setLiaisonID(String liaisonID) {
		this.liaisonID = liaisonID;
	}
	private String intentionID;
	private String businessdemandID;
	private String liaisondemandID;
	private String reject;
	private String shopID;
	private String liaisonuserID;
	public String getLiaisonuserID() {
		return liaisonuserID;
	}
	public void setLiaisonuserID(String liaisonuserID) {
		this.liaisonuserID = liaisonuserID;
	}
	public String getShopID() {
		return shopID;
	}
	public void setShopID(String shopID) {
		this.shopID = shopID;
	}
	public String getIntentionID() {
		return intentionID;
	}
	public void setIntentionID(String intentionID) {
		this.intentionID = intentionID;
	}
	public String getReject() {
		return reject;
	}
	public void setReject(String reject) {
		this.reject = reject;
	}
	public List getBusinessrequestList() {
		return businessrequestList;
	}
	public void setBusinessrequestList(List businessrequestList) {
		this.businessrequestList = businessrequestList;
	}
	public List getLiaisonList() {
		return liaisonList;
	}
	public void setLiaisonList(List liaisonList) {
		this.liaisonList = liaisonList;
	}
	public String getLiaisondemandID() {
		return liaisondemandID;
	}
	public void setLiaisondemandID(String liaisondemandID) {
		this.liaisondemandID = liaisondemandID;
	}
	public String getBusinessdemandID() {
		return businessdemandID;
	}
	public void setBusinessdemandID(String businessdemandID) {
		this.businessdemandID = businessdemandID;
	}
	public Liaisondemand getLiaisondemand() {
		return liaisondemand;
	}

	public void setLiaisondemand(Liaisondemand liaisondemand) {
		this.liaisondemand = liaisondemand;
	}
	
	
	public List getHistorybusinessdemandlist() {
		return historybusinessdemandlist;
	}
	public void setHistorybusinessdemandlist(List historybusinessdemandlist) {
		this.historybusinessdemandlist = historybusinessdemandlist;
	}
	public List getHistoryliaisondemandlist() {
		return historyliaisondemandlist;
	}
	public void setHistoryliaisondemandlist(List historyliaisondemandlist) {
		this.historyliaisondemandlist = historyliaisondemandlist;
	}
	public String createLiaisonDemand()   //创建外联意向
	{
		//DemandService demandService=new DemandService();
		if(demandService.saveliaDemandService(liaisondemand))
		{
			return "createsuccess";
		}
		else return "createfail";
	}
	
	public String createBusinessDemand()   //创建商家意向
	{
		//DemandService demandService=new DemandService();
		if(demandService.savebusinessDemandService(businessdemand))
		{
			System.out.println("creat");
			return "createsuccess";
		}
		else return "createfail";
	}
	
	
	public String createIntention()  //外联对商家有意向
	{
		//UserService userServ=new UserService();
		Businessdemand businessdemand=userService.findBusinessdemandbyID(Integer.parseInt(businessdemandID));
		Liaisondemand liaisondemand =userService.findLiaisondemandbyID(Integer.parseInt(liaisondemandID));
		//DemandService demandService=new DemandService();
		if(demandService.createIntention(businessdemand, liaisondemand))
		{
			return "createsuccess";
		}
		else return "creatfail";
	}
	public void showLiasondemand()   //展示外联已有意向
	{
		//DemandService demandService=new DemandService();
		liaisonList=demandService.findliaisondemand();
	}
	public String findbusinessrequest()    //显示商家对外联的请求
	{
		//DemandService demandService=new DemandService();
		businessrequestList=demandService.findbusinessrequest();
		return "success";
	}
	public String findliaisonrequest()    //显示外联对商家的请求
	{
		//DemandService demandService=new DemandService();
		liaisonrequestList=demandService.findliaisonrequest();
		return "success";
	}
	public String rejectBusinessrequestOrnot() //拒绝或接受
	{
		//DemandService demandService=new DemandService();
		Business business=(Business) application.getAttribute("business");
	    Liaisonuser liaisonuser=(Liaisonuser) application.getAttribute("liaisonuser");
	        if(business!=null)
	        {

	        	if(business.getName()!=null)
	        	{
	        		if(demandService.rejectBusinessOrnot(Integer.parseInt(reject), Integer.parseInt(intentionID)))
	        		{
	        			return "Businesssuccess";
	        		}
	        	}
	        	
	        }
	        if(liaisonuser!=null)
	        {
	        	if(liaisonuser.getName()!=null)
	        	{
	        		if(demandService.rejectBusinessOrnot(Integer.parseInt(reject), Integer.parseInt(intentionID)))
	        		{
	        			return "Liaisonsuccess";
	        		}
	        	}
	        }
	        return "fail";
	}
	public String shouwLiaisondetail()  //显示外联的详细信息
	{
		//DemandService demandService=new DemandService();
		Liaison liaison=demandService.findLiaisonbyID(Integer.parseInt(liaisonID));
		application.setAttribute("liaison", liaison);
		return "success";
	}
	public String showShopdetail()  //显示店铺的详细信息
	{
		//DemandService demandService=new DemandService();
		Shop shop=demandService.findShopbyID(Integer.parseInt(shopID));
		application.setAttribute("shop", shop);
		businessrequestList=demandService.findbusinessrequest();
		return "success";
	}
	public String closeShopdetail()  //关闭店铺的详细信息
	{
		Shop s=new Shop();
		//DemandService demandService=new DemandService();
		application.setAttribute("shop", s);
		businessrequestList=demandService.findbusinessrequest();
		return "success";
	}
	public String showliaisondetail()  //显示外联的详细信息
	{
		//DemandService demandService=new DemandService();
		System.out.println("进入action");
		LiaisonDetail liaisonDetail=demandService.findliaisonbyID(Integer.parseInt(liaisonuserID));
		System.out.println("获取到");
		System.out.println(liaisonDetail.getAddress());
		System.out.println(liaisonDetail.getPhone());
		application.setAttribute("LiaisonDetail", liaisonDetail);
		//UserService userServ=new UserService();
		demandlist=userService.findliaisonService(); 
		return "success";
	}
	public String closeliaisondetail()   //关闭外联的详细信息
	{
		LiaisonDetail liaisonDetail=new LiaisonDetail();
		//DemandService demandService=new DemandService();
		application.setAttribute("LiaisonDetail", liaisonDetail);
		//UserService userServ=new UserService();
		demandlist=userService.findliaisonService(); 
		return "success";
	}
	public String liaisoncreateIntention()   //外联对商家有意向
	{
		//UserService userServ=new UserService();
		Businessdemand businessdemand=userService.findBusinessdemandbyID(Integer.parseInt(businessdemandID));
		Liaisondemand liaisondemand =userService.findLiaisondemandbyID(Integer.parseInt(liaisondemandID));
		//DemandService demandService=new DemandService();
		if(demandService.createIntention(businessdemand, liaisondemand))
		{
			return "liaisoncreatesuccess";
		}
		else return "creatfail";
	}
	public String businesscreateIntention()   //商家对外联有意向
	{
		//UserService userServ=new UserService();
		Businessdemand businessdemand=userService.findBusinessdemandbyID(Integer.parseInt(businessdemandID));
		Liaisondemand liaisondemand =userService.findLiaisondemandbyID(Integer.parseInt(liaisondemandID));
		//DemandService demandService=new DemandService();
        if (demandService.BusinesscreateIntention(businessdemand, liaisondemand))
		{
			return "businesscreatesuccess";
		}
		else return "creatfail";
	}
	public String seehistoryliaisondemand()   //外联查看发布的历史订单
	{
		//UserService userServ=new UserService();
		Liaisonuser liaisonuser=(Liaisonuser ) application.getAttribute("liaisonuser");
		int liaisonID=liaisonuser.getLiaisonuserID();
		System.out.println("busineesID"+liaisonID);
		historyliaisondemandlist=userService.findliaisondemandbyliaisonID(liaisonID);
		return "seesuccess";
	}
	public String seehistorybusinessdemand()   //商家查看发布的历史订单
	{
		//UserService userServ=new UserService();
		Business business=(Business) application.getAttribute("business");
		int businessID=business.getBusinessID();
		System.out.println("busineesID"+businessID);
		historybusinessdemandlist=userService.findBusinessdemandbybussinessID(businessID);
		return "seesuccess";
	}
}
