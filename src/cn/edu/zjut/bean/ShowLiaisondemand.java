package cn.edu.zjut.bean;

public class ShowLiaisondemand implements java.io.Serializable{	
	public ShowLiaisondemand(int liaisondemandID, String publisheddate, String period, String activityname,
			String mincapital, String maxcapital, String activitydetail, String overallnum, String status,
			String conductdetail, int liaisonuserID, String type, String departmentdetail, String address,String phone) {
		super();
		this.liaisondemandID = liaisondemandID;
		this.publisheddate = publisheddate;
		this.period = period;
		this.activityname = activityname;
		this.mincapital = mincapital;
		this.maxcapital = maxcapital;
		this.activitydetail = activitydetail;
		this.overallnum = overallnum;
		this.status = status;
		this.conductdetail = conductdetail;
		this.liaisonuserID = liaisonuserID;
		this.type = type;
		this.departmentdetail = departmentdetail;
		this.address = address;
		this.phone=phone;
	}
	private int liaisondemandID;
	private String publisheddate;
	private String phone;
	private String period;
	private String activityname;
	private String mincapital;
	private String maxcapital;
	private String activitydetail;
	private String overallnum;
	private String status;
	private String conductdetail;
	private int liaisonuserID;
	private String type;
	private String departmentdetail;
	private String address;
	public ShowLiaisondemand(){}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getLiaisondemandID() {
		return liaisondemandID;
	}
	public void setLiaisondemandID(int liaisondemandID) {
		this.liaisondemandID = liaisondemandID;
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
	public String getActivityname() {
		return activityname;
	}
	public void setActivityname(String activityname) {
		this.activityname = activityname;
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
	public String getActivitydetail() {
		return activitydetail;
	}
	public void setActivitydetail(String activitydetail) {
		this.activitydetail = activitydetail;
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
	public String getConductdetail() {
		return conductdetail;
	}
	public void setConductdetail(String conductdetail) {
		this.conductdetail = conductdetail;
	}
	public int getLiaisonuserID() {
		return liaisonuserID;
	}
	public void setLiaisonuserID(int liaisonuserID) {
		this.liaisonuserID = liaisonuserID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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

	

}
