package cn.edu.zjut.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.bean.LiaisonDetail;

import cn.edu.zjut.po.Businessdemand;
import cn.edu.zjut.po.Intention;
import cn.edu.zjut.po.Liaison;
import cn.edu.zjut.po.Liaisondemand;
import cn.edu.zjut.po.Shop;

public interface IDemandService {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	ServletContext application=ServletActionContext.getServletContext();
	HttpSession session=ServletActionContext.getRequest().getSession();
	public boolean saveliaDemandService(Liaisondemand liaisondemand);  //创建外联需求
	public boolean savebusinessDemandService(Businessdemand businessdemand);  //创建商家需求
	public boolean createIntention(Businessdemand businessdemand,Liaisondemand liaisondemand);//外联对商家 有意向

    public boolean BusinesscreateIntention(Businessdemand businessdemand, Liaisondemand liaisondemand);//商家对外联 有意向
	public List findliaisondemand();   //显示外联已有的需求
	public List findall();  //点击首页显示所有商家意向
	public List findbusinessrequest();  //显示商家对外联的请求
	public List findliaisonrequest(); //显示外联对商家的请求
	public Liaison findLiaisonbyID(int liaisonID); //用外联ID查找外联组织信息
	public Shop findShopbyID(int shopID);//用店铺ID查找店铺信息
	public LiaisonDetail findliaisonbyID(int liaisonuserID);//用外联ID查找外联信息
	public Intention findIntentionbyID(int intentionID); //用intentionID查找对应intention
	public boolean rejectBusinessOrnot(int reject,int intentionID);  //拒绝或是接受请求

    public List findoverbusiness(int businessdemandID);//查找多余的商家需求申请

    public List findoverliaison(int liaisondemandID);//查找多余的外联需求申请

    public void updateIntention(List list);//修改多余的需求申请
}
