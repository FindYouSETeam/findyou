package cn.edu.zjut.bean;

public class liaisonjudge {
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
	public String getDepartmentdetail() {
		return departmentdetail;
	}
	public void setDepartmentdetail(String departmentdetail) {
		this.departmentdetail = departmentdetail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public liaisonjudge(int ID,String account, String name, String iDCard, String phone, String departmentdetail,
			String address) {
		this.ID=ID;
		this.account = account;
		this.name = name;
		IDCard = iDCard;
		this.phone = phone;
		this.departmentdetail = departmentdetail;
		this.address = address;
	}
	private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	private String account;
	private String name;
	private String IDCard;
	private String phone;
	private String departmentdetail;
	private String address;
}
