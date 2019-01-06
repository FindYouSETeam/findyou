package cn.edu.zjut.po;

import java.util.HashSet;
import java.util.Set;

public class Business {
	private int businessID;
	private String name;
	private String IDCard;
	private String phone;
	private boolean auditing;
	private Login login;
	private Shop shop;
	private Set businessdemand = new HashSet(0); 

	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public Business() {}
	public Business(int businessID) {
		super();
		this.businessID = businessID;
	}
	public Business(int businessID, String name, String iDCard, String phone, boolean auditing,Login login,Shop shop,Set businessdemand) {
		super();
		this.businessID = businessID;
		this.name = name;
		IDCard = iDCard;
		this.phone = phone;
		this.auditing = auditing;
		this.login=login;
		this.shop=shop;
		this.businessdemand=businessdemand;
	}
	
	public int getBusinessID() {
		return businessID;
	}
	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean getAuditing() {
		return auditing;
	}
	public void setAuditing(boolean auditing) {
		this.auditing = auditing;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Set getBusinessdemand() {
		return businessdemand;
	}
	public void setBusinessdemand(Set businessdemand) {
		this.businessdemand = businessdemand;
	}	
}
