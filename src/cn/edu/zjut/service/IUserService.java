package cn.edu.zjut.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.dao.BusinessdemandDAO;
import cn.edu.zjut.dao.LiaisondemandDAO;
import cn.edu.zjut.po.Business;
import cn.edu.zjut.po.Businessdemand;
import cn.edu.zjut.po.Liaison;
import cn.edu.zjut.po.Liaisonassess;
import cn.edu.zjut.po.Liaisondemand;
import cn.edu.zjut.po.Liaisonuser;
import cn.edu.zjut.po.Login;
import cn.edu.zjut.po.Shop;
import cn.edu.zjut.po.Shopassess;

public interface IUserService {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	ServletContext application=ServletActionContext.getServletContext();
	HttpSession session=ServletActionContext.getRequest().getSession();
	public boolean business_register_basic(Business business,Login login);  //商家注册基础模块
	public boolean business_register_detail(Business business,Shop shop); //商家注册详细模块
	public boolean user_register_basic(Liaisonuser liaisonuser,Login login);  //用户注册基础模块
	public boolean user_register_detail(Liaisonuser liaisonuser,Liaison liaison); //用户注册详细模块
	public boolean createShopAssess( Shopassess shopassess,int orderID);  //评价店铺
	public boolean LoginService(Login login,String type);//登录
	public Businessdemand findBusinessdemandbyID(int businessdemandID); //用businessdemandID查询指定商家需求信息
	public Liaisondemand findLiaisondemandbyID(int liaisondemandID); //用liaisondemandID查外联指定需求信息
	public List findallbusinessService(); //外联登录显示所有商家的需求列表
	public List findliaisonService(); //商家登录显示所有外联的需求列表
	public boolean updateBusinessInfo(Business business,Login login);   //更新商家信息
	public boolean updateLiaisonInfo(Liaisonuser liaisonuser,Login login);   //更新外联信息
	public boolean createLiaisonAssess( Liaisonassess assess,int orderID); //评价外联
	public List findBusinessdemandbybussinessID(int businessID); //用businessID查询历史发布订单
	public List findliaisondemandbyliaisonID(int liaisonID); //外联查看历史订单
}
