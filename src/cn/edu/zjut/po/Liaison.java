package cn.edu.zjut.po;

import java.sql.Blob;

public class Liaison {
	private int liaisonID;
	private Blob qualification;
	private String departmentdetail;
	private String address;
	private Liaisonuser liaisonuser;

	public Liaison() {}
	public Liaison(int liaisonID) {
		super();
		this.liaisonID = liaisonID;
	}
	public Liaison(int liaisonID, Blob qualification, String departmentdetail,  String address,Liaisonuser liaisonuser) {
		super();
		this.liaisonID = liaisonID;
		this.qualification = qualification;
		this.departmentdetail = departmentdetail;
		this.address = address;
		this.liaisonuser=liaisonuser;
	}
	public int getLiaisonID() {
		return liaisonID;
	}
	public void setLiaisonID(int liaisonID) {
		this.liaisonID = liaisonID;
	}
	public Blob getQualification() {
		return qualification;
	}
	public void setQualification(Blob qualification) {
		this.qualification = qualification;
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
	public Liaisonuser getLiaisonuser() {
		return liaisonuser;
	}
	public void setLiaisonuser(Liaisonuser liaisonuser) {
		this.liaisonuser = liaisonuser;
	}
}
