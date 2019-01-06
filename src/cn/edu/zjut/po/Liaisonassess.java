package cn.edu.zjut.po;

import java.util.HashSet;
import java.util.Set;

public class Liaisonassess {
	private int liaisonassessID;
	private String assess;
	private int attitude;
	private int effect;
	private Theorder theorder;
	

	public Liaisonassess() {}
	public Liaisonassess(int assessID) {
		super();
		this.liaisonassessID = assessID;
	}
	public Liaisonassess(int assessID,  String assess, int attitude, int effect,
			Theorder theorder) {
		super();
		this.liaisonassessID = assessID;
		this.assess = assess;
		this.attitude = attitude;
		this.effect = effect;
		this.theorder= theorder;
	}
	public int getLiaisonassessID() {
		return liaisonassessID;
	}
	public void setLiaisonassessID(int liaisonassessID) {
		this.liaisonassessID = liaisonassessID;
	}
	
	public String getAssess() {
		return assess;
	}
	public void setAssess(String assess) {
		this.assess = assess;
	}
	public int getAttitude() {
		return attitude;
	}
	public void setAttitude(int attitude) {
		this.attitude = attitude;
	}
	public int getEffect() {
		return effect;
	}
	public void setEffect(int effect) {
		this.effect = effect;
	}
	public Theorder getTheorder() {
		return theorder;
	}
	public void setTheorder(Theorder theorder) {
		this.theorder = theorder;
	}
}
