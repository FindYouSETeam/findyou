package cn.edu.zjut.bean;
//反馈界面，商家的中间类
public class judgeliaison implements java.io.Serializable{
	private int liaisonID;
	private int intentionID;
	private String departmentdetail;
	private String activityname;
	private String mincapital;
	private String maxcapital;
	private String publisheddate;
	private String phone;
	public int getLiaisonID() {
		return liaisonID;
	}
	public void setLiaisonID(int liaisonID) {
		this.liaisonID = liaisonID;
	}
	public int getIntentionID() {
		return intentionID;
	}
	public void setIntentionID(int intentionID) {
		this.intentionID = intentionID;
	}
	public String getDepartmentdetail() {
		return departmentdetail;
	}
	public void setDepartmentdetail(String departmentdetail) {
		this.departmentdetail = departmentdetail;
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
	public String getPublisheddate() {
		return publisheddate;
	}
	public void setPublisheddate(String publisheddate) {
		this.publisheddate = publisheddate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public judgeliaison(int liaisonID, int intentionID, String departmentdetail, String activityname, String mincapital,
			String maxcapital, String publisheddate, String phone) {
		this.liaisonID = liaisonID;
		this.intentionID = intentionID;
		this.departmentdetail = departmentdetail;
		this.activityname = activityname;
		this.mincapital = mincapital;
		this.maxcapital = maxcapital;
		this.publisheddate = publisheddate;
		this.phone = phone;
	}
	public judgeliaison() {}
}
