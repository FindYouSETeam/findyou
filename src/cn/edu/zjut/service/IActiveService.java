package cn.edu.zjut.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.po.Shopactive;

public interface IActiveService {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	ServletContext application=ServletActionContext.getServletContext();
	HttpSession session=ServletActionContext.getRequest().getSession();
	public boolean AddActive(Shopactive shopactive);  //创建商家营销活动
	public List findMyShopActive();  //显示自己的营销活动
	public List findAllShopActive();  //显示所有的营销活动
	public boolean delMyShopActive(Shopactive shopactive);  //删除某条自己的营销活动
	public Shopactive findbyID(int i); //根据ID查出某个营销活动
	public boolean updateShopActiveInfo(Shopactive shopactive);  //更新营销活动信息
}
