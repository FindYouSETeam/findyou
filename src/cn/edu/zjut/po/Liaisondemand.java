package cn.edu.zjut.po;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Liaisondemand {
	private int liaisondemandID;
	private String publisheddate;
	private String period;
	private String activityname;
	private String mincapital;
	private String maxcapital;
	private String activitydetail;
	private String overallnum;
	private String status;
	private String conductdetail;
	private String type;
	private Set intention=new HashSet(0);
	private Theorder theorder;
	private Liaisonuser liaisonuser;
	
	
	public Liaisondemand() {}
	public Liaisondemand(int liaisondemandID) {
		super();
		this.liaisondemandID = liaisondemandID;
	}
	public Liaisondemand(int liaisondemandID, String publisheddate, String period, String activityname, String mincapital,
			String maxcapital, String activitydetail, String overallnum, String status, String conductdetail,String type,
			Set intention, Theorder theorder, Liaisonuser liaisonuser) {
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
		this.type=type;
		this.intention = intention;
		this.theorder = theorder;
		this.liaisonuser = liaisonuser;
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
	public void setPublisheddate(String birthday) {
		this.publisheddate = birthday;
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
	public Set getIntention() {
		return intention;
	}
	public void setIntention(Set intention) {
		this.intention = intention;
	}

	public Theorder getTheorder() {
		return theorder;
	}
	public void setTheorder(Theorder theorder) {
		this.theorder = theorder;
	}
	public Liaisonuser getLiaisonuser() {
		return liaisonuser;
	}
	public void setLiaisonuser(Liaisonuser liaisonuser) {
		this.liaisonuser = liaisonuser;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
