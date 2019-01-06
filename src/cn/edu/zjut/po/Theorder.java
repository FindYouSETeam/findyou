package cn.edu.zjut.po;

public class Theorder {
	private int orderID;
	private Businessdemand businessdemand;
	private Liaisondemand liaisondemand;
	private Liaisonassess liaisonassess;
	private Shopassess shopassess;
	private String startTime;
	private String finishTime;
	private String status;
	
	
	public Theorder() {
		super();
	}
	
	public Theorder(int orderID) {
		super();
		this.orderID = orderID;
	}

	public Theorder(int orderID, Businessdemand businessdemand, Liaisondemand liaisondemand,
			Liaisonassess liaisonassess, Shopassess shopassess, String startTime, String finishTime, String status) {
		super();
		this.orderID = orderID;
		this.businessdemand = businessdemand;
		this.liaisondemand = liaisondemand;
		this.liaisonassess = liaisonassess;
		this.shopassess = shopassess;
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
	public Businessdemand getBusinessdemand() {
		return businessdemand;
	}
	public void setBusinessdemand(Businessdemand businessdemand) {
		this.businessdemand = businessdemand;
	}
	public Liaisondemand getLiaisondemand() {
		return liaisondemand;
	}
	public void setLiaisondemand(Liaisondemand liaisondemand) {
		this.liaisondemand = liaisondemand;
	}
	public Liaisonassess getLiaisonassess() {
		return liaisonassess;
	}
	public void setLiaisonassess(Liaisonassess liaisonassess) {
		this.liaisonassess = liaisonassess;
	}
	public Shopassess getShopassess() {
		return shopassess;
	}
	public void setShopassess(Shopassess shopassess) {
		this.shopassess = shopassess;
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
