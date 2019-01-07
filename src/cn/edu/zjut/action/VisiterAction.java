package cn.edu.zjut.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.dao.ActiveDAO;
import cn.edu.zjut.dao.BusinessdemandDAO;
import cn.edu.zjut.po.Business;
import cn.edu.zjut.po.Liaisonuser;
import cn.edu.zjut.po.Shopactive;
import cn.edu.zjut.service.ActiveService;
import cn.edu.zjut.service.DemandService;
import cn.edu.zjut.service.IActiveService;
import cn.edu.zjut.service.IDemandService;
import cn.edu.zjut.service.IUserService;
import cn.edu.zjut.service.UserService;

public class VisiterAction {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	ServletContext application=ServletActionContext.getServletContext();
	HttpSession session=ServletActionContext.getRequest().getSession();
	
	private List AllshopactiveList;
	private List demandlist;
	private List liaisondemandlist;
	
	private IActiveService activeService=null;
	private IUserService userService =null;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public void setActiveService(IActiveService activeService) {
		this.activeService = activeService;
	}
	
	public List getAllshopactiveList() {
		return AllshopactiveList;
	}
	public void setAllshopactiveList(List allshopactiveList) {
		AllshopactiveList = allshopactiveList;
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
	
	
	public String VisiterToSeeActive()   //显示所有的营销活动
	{
		//ActiveService activeService=new ActiveService();
		AllshopactiveList=activeService.findAllShopActive();
		return "success";		
	}
	public String VisiterToSeeLiaison()   //外联页面点击首页显示所有的商家列表
	{
		//DemandService demandServ=new DemandService();
		//UserService userServ=new UserService();
		demandlist=userService.findallbusinessService();
		return "success";
	}
	public String VisiterToSeeBusiness()   //游客查看所有的外联列表
	{
		//DemandService demandServ=new DemandService();
		//UserService userServ=new UserService();
		demandlist=userService.findliaisonService();
		return "success";
	}

}
