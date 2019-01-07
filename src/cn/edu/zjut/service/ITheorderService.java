package cn.edu.zjut.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.po.Theorder;

public interface ITheorderService {
	HttpServletRequest request =ServletActionContext.getRequest();
    HttpServletResponse response= ServletActionContext.getResponse();
    ServletContext application= ServletActionContext.getServletContext();
    HttpSession session= ServletActionContext.getRequest().getSession();
	//根据LiaisonuserID和status获取不同状态的order
	public List getOrderByStatusAndLID(String status);
	//根据BusinessID和status获取不同状态的order
	public List getOrderByStatusAndBID(String status);
	//根据orderID获取order
	 public Theorder findOrderByOID(int orderID);
	 //完成订单
	 public boolean finishOrder(int orderID);
}
