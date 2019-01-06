package cn.edu.zjut.po;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Businessdemand {
	public int getBusinessdemandID() {
		return businessdemandID;
	}
	public void setBusinessdemandID(int businessdemandID) {
		this.businessdemandID = businessdemandID;
	}
	private int businessdemandID;
	private String publisheddate;
	private String period;
	private String mincapital;
	private String maxcapital;
	private String overallnum;
	private String status;
	private Business business;
	private Set intention=new HashSet(0);
	private Theorder theorder;


	public Theorder getTheorder() {
		return theorder;
	}
	public void setTheorder(Theorder theorder) {
		this.theorder = theorder;
	}
	public Businessdemand() {}
	public Businessdemand(int demandID) {
		super();
		this.businessdemandID = demandID;
	}
	public Businessdemand(int demandID, String publisheddate, String period, String mincapital, String maxcapital,
			String overallnum, String status,Business business,Set intention,Theorder theorder) {
		super();
		this.businessdemandID = demandID;
		this.publisheddate = publisheddate;
		this.period = period;
		this.mincapital = mincapital;
		this.maxcapital = maxcapital;
		this.overallnum = overallnum;
		this.status = status;
		this.business=business;
		this.intention=intention;
		this.theorder =theorder;
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
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public Set getIntention() {
		return intention;
	}
	public void setIntention(Set intention) {
		intention = intention;
	}
}
