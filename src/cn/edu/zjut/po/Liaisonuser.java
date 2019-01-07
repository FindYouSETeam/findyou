package cn.edu.zjut.po;

import java.util.HashSet;
import java.util.Set;

public class Liaisonuser {

	private int liaisonuserID;
	private String name;
	private String IDCard;
	private String phone;
	private int auditing;
	private Login login;
	private Liaison liaison;
	private Set liaisondemand=new HashSet(0);
	
	public Liaisonuser() {}
	public Liaisonuser(int liaisonuserID) {
		super();
		this.liaisonuserID = liaisonuserID;
	}
	
	public Liaisonuser(int liaisonuserID, String name, String iDCard, String phone, int auditing, Login login,
			Liaison liaison, Set liaisondemand) {
		super();
		this.liaisonuserID = liaisonuserID;
		this.name = name;
		IDCard = iDCard;
		this.phone = phone;
		this.auditing = auditing;
		this.login = login;
		this.liaison = liaison;
		this.liaisondemand = liaisondemand;
	}
	public int getLiaisonuserID() {
		return liaisonuserID;
	}
	public void setLiaisonuserID(int liaisonuserID) {
		this.liaisonuserID = liaisonuserID;
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
	public int getAuditing() {
		return auditing;
	}
	public void setAuditing(int auditing) {
		this.auditing = auditing;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Liaison getLiaison() {
		return liaison;
	}
	public void setLiaison(Liaison liaison) {
		this.liaison = liaison;
	}
	public Set getLiaisondemand() {
		return liaisondemand;
	}
	public void setLiaisondemand(Set liaisondemand) {
		this.liaisondemand = liaisondemand;
	}

}
