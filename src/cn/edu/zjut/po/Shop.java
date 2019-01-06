package cn.edu.zjut.po;

import java.sql.Blob;

public class Shop {
	private int shopID;
	private String shopname;
	private Blob qualification;
	private String shoptype;
	private String shopdetail;
	private Blob shopfront;
	private String address;
	private Business business;
	
	
	
	public Shop() {}
	public Shop(int shopID) {
		super();
		this.shopID = shopID;
	}
	public Shop(int shopID, String shopname, Blob qualification, String shoptype, String shopdetail, Blob shopfront,
			String address,Business business) {
		super();
		this.shopID = shopID;
		this.shopname = shopname;
		this.qualification = qualification;
		this.shoptype = shoptype;
		this.shopdetail = shopdetail;
		this.shopfront = shopfront;
		this.address = address;
		this.business=business;
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
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	
}
