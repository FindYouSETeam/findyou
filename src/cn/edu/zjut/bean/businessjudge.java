package cn.edu.zjut.bean;

public class businessjudge {
	private int businessID;
	public businessjudge(int businessID, String account, String name, String iDCard, String phone, String shopname,
			String shoptype, String shopdetail, String shopaddress) {
		this.businessID = businessID;
		this.account = account;
		this.name = name;
		IDCard = iDCard;
		this.phone = phone;
		this.shopname = shopname;
		this.shoptype = shoptype;
		this.shopdetail = shopdetail;
		this.shopaddress = shopaddress;
	}
	public int getBusinessID() {
		return businessID;
	}
	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
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
	public String getShopaddress() {
		return shopaddress;
	}
	public void setShopaddress(String shopaddress) {
		this.shopaddress = shopaddress;
	}
	private String account;
	private String name;
	private String IDCard;
	private String phone;
	private String shopname;
	private String shoptype;
	private String shopdetail;
	private String shopaddress;
}
