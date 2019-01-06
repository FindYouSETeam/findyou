package cn.edu.zjut.bean;
//反馈界面，外联端的中间类
public class judgebusiness implements java.io.Serializable{
	private int shopID;
	public int getShopID() {
		return shopID;
	}
	public void setShopID(int shopID) {
		this.shopID = shopID;
	}
	private int intentionID;
	public int getIntentionID() {
		return intentionID;
	}
	public void setIntentionID(int intentionID) {
		this.intentionID = intentionID;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
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
	public String getOverallnum() {
		return overallnum;
	}
	public void setOverallnum(String overallnum) {
		this.overallnum = overallnum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public judgebusiness(int shopID,int intentionID,String shopname, String mincapital, String maxcapital, String publisheddate, String overallnum,
			String phone) {
		this.shopID=shopID;
		this.intentionID=intentionID;
		this.shopname = shopname;
		this.mincapital = mincapital;
		this.maxcapital = maxcapital;
		this.publisheddate = publisheddate;
		this.overallnum = overallnum;
		this.phone = phone;
	}
	public judgebusiness()
	{
		
	}
	private String shopname;
	private String mincapital;
	private String maxcapital;
	private String publisheddate;
	private String overallnum;
	private String phone;
}
