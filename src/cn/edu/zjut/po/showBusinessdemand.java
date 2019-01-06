package cn.edu.zjut.po;

import java.sql.Blob;

public class showBusinessdemand implements java.io.Serializable{
	public showBusinessdemand(int businessdemandID, String publisheddate, String period, String mincapital,
			String maxcapital, String overallnum, String status, int businessID, int shopID, String shopname,
			Blob qualification, String shoptype, String shopdetail, Blob shopfront, String address) {
		super();
		this.businessdemandID = businessdemandID;
		this.publisheddate = publisheddate;
		this.period = period;
		this.mincapital = mincapital;
		this.maxcapital = maxcapital;
		this.overallnum = overallnum;
		this.status = status;
		this.businessID = businessID;
		this.shopID = shopID;
		this.shopname = shopname;
		this.qualification = qualification;
		this.shoptype = shoptype;
		this.shopdetail = shopdetail;
		this.shopfront = shopfront;
		this.address = address;
	}
	public showBusinessdemand()
	{
		
	}
	private int businessdemandID;
	private String publisheddate;
	private String period;
	private String mincapital;
	private String maxcapital;
	private String overallnum;
	private String status;
	private	int businessID;
	private int shopID;
	private String shopname;
	private Blob qualification;
	private String shoptype;
	private String shopdetail;
	private Blob shopfront;
	private String address;
	public int getBusinessdemandID() {
		return businessdemandID;
	}
	public void setBusinessdemandID(int businessdemandID) {
		this.businessdemandID = businessdemandID;
	}
	public String getPublisheddate() {
		return publisheddate;
	}
	public void setPublisheddate(String publisheddate) {
		this.publisheddate = publisheddate;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getMincapital() {
		return mincapital;
	}
	public void setMincapital(String mincapital) {
		this.mincapital = mincapital;
	}
	public String getMaxcapital() {
		return maxcapital;
	}
	public void setMaxcapital(String maxcapital) {
		this.maxcapital = maxcapital;
	}
	public String getOverallnum() {
		return overallnum;
	}
	public void setOverallnum(String overallnum) {
		this.overallnum = overallnum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBusinessID() {
		return businessID;
	}
	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}
	public int getShopID() {
		return shopID;
	}
	public void setShopID(int shopID) {
		this.shopID = shopID;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public Blob getQualification() {
		return qualification;
	}
	public void setQualification(Blob qualification) {
		this.qualification = qualification;
	}
	public String getShoptype() {
		return shoptype;
	}
	public void setShoptype(String shoptype) {
		this.shoptype = shoptype;
	}
	public String getShopdetail() {
		return shopdetail;
	}
	public void setShopdetail(String shopdetail) {
		this.shopdetail = shopdetail;
	}
	public Blob getShopfront() {
		return shopfront;
	}
	public void setShopfront(Blob shopfront) {
		this.shopfront = shopfront;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
