package cn.edu.zjut.po;

public class Intention {
	
	private int intentionID;
	private String applyDate;
	private String status;
	private Businessdemand businessdemand;
	private Liaisondemand liaisondemand;
	private Boolean whoApply; //申请人 0-外联 1-商家
	public Boolean isWhoApply() {
		return whoApply;
	}
	public void setWhoApply(Boolean whoApply) {
		this.whoApply = whoApply;
	}
	public Intention() {}
	public Intention(int intentionID) {
		super();
		this.intentionID = intentionID;
	}
	public Intention(int intentionID,String applyDate,String status,Businessdemand businessdemand,Liaisondemand liaisondemand) {
		super();
		this.intentionID = intentionID;
		this.applyDate=applyDate;
		this.status=status;
		this.businessdemand=businessdemand;
		this.liaisondemand=liaisondemand;
	}
	
	public int getIntentionID() {
		return intentionID;
	}
	public void setIntentionID(int intentionID) {
		this.intentionID = intentionID;
	}
	public Businessdemand getBusinessdemand() {
		return businessdemand;
	}
	public void setBusinessdemand(Businessdemand businessdemand) {
		this.businessdemand = businessdemand;
	}
	public Liaisondemand getLiaisondemand() {
		return liaisondemand;
	}
	public void setLiaisondemand(Liaisondemand liaisondemand) {
		this.liaisondemand = liaisondemand;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
