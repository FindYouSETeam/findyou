package cn.edu.zjut.bean;

import cn.edu.zjut.po.Businessdemand;
import cn.edu.zjut.po.Liaisonassess;
import cn.edu.zjut.po.Liaisondemand;
import cn.edu.zjut.po.Shopassess;

public class OrderItem {
	private int orderID;
	private int businessdemandID;
	private int liaisondemandID;
	private String startTime;
	private String finishTime;
	private String status;
	
	
	public OrderItem() {
		super();
	}
	
	public OrderItem(int orderID) {
		super();
		this.orderID = orderID;
	}

	public OrderItem(int orderID, int businessdemandID, int liaisondemandID, String startTime, String finishTime,
			String status) {
		super();
		this.orderID = orderID;
		this.businessdemandID = businessdemandID;
		this.liaisondemandID = liaisondemandID;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.status = status;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getBusinessdemandID() {
		return businessdemandID;
	}
	public void setBusinessdemandID(int businessdemandID) {
		this.businessdemandID = businessdemandID;
	}
	public int getLiaisondemandID() {
		return liaisondemandID;
	}
	public void setLiaisondemandID(int liaisondemandID) {
		this.liaisondemandID = liaisondemandID;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
