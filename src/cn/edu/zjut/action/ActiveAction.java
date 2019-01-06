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
import cn.edu.zjut.service.UserService;

public class ActiveAction {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	ServletContext application=ServletActionContext.getServletContext();
	HttpSession session=ServletActionContext.getRequest().getSession();
	private Shopactive shopactive;
	private List shopactiveList;
	private List AllshopactiveList;
	public List getAllshopactiveList() {
		return AllshopactiveList;
	}
	public void setAllshopactiveList(List allshopactiveList) {
		AllshopactiveList = allshopactiveList;
	}
	private String shopactiveID;
	public String getShopactiveID() {
		return shopactiveID;
	}
	public void setShopactiveID(String shopactiveID) {
		this.shopactiveID = shopactiveID;
	}
	public Shopactive getShopactive() {
		return shopactive;
	}
	public void setShopactive(Shopactive shopacitve) {
		this.shopactive = shopacitve;
	}
	public List getShopactiveList() {
		return shopactiveList;
	}
	public void setShopactiveList(List shopactiveList) {
		this.shopactiveList = shopactiveList;
	}
	public String AddActive()   //创建商家营销活动
	{
		ActiveService activeService=new ActiveService();
		if(activeService.AddActive(shopactive))
		{
			System.out.println("add");
			return "addsuccess";
		}
		else return "fail";
	}
	public String findMyShopActive()  //显示自己的营销活动
	{
		ActiveService activeService=new ActiveService();
		shopactiveList=activeService.findMyShopActive();
		return "success";		
	}
	public String VisterToSeeActive()  //显示所有的营销活动
	{
		ActiveService activeService=new ActiveService();
		AllshopactiveList=activeService.findAllShopActive();
		return "success";		
	}
	public String delMyShopActive()  //删除自己的营销活动
	{
		ActiveService activeService=new ActiveService();
		shopactive=activeService.findbyID(Integer.parseInt(shopactiveID));
		if(activeService.delMyShopActive(shopactive))
			return "success";
		else
			return "fail";
	}
	public String updateShopActiveInfo()  //修改自己的营销活动
	{
		ActiveService activeService=new ActiveService();
		if(activeService.updateShopActiveInfo(shopactive))
			return "success";
		else
			return "fail";
	}
	public String ToChangeMyShopActive()  //跳转到某个营销活动
	{
		ActiveService activeService=new ActiveService();
		shopactive=activeService.findbyID(Integer.parseInt(shopactiveID));
		return "success";
	}
}
