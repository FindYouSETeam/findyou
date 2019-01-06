package cn.edu.zjut.po;

public class Shopassess {
	private int shopassessID;	
	private String assess;
	private int attitude;
	private int effect;
	private Theorder theorder;
	
	
	public Shopassess() {}
	public Shopassess(int assessID) {
		super();
		this.shopassessID = assessID;
	}
	
	public Shopassess(int assessID, String assess, int attitude, int effect, Theorder theorder) {
		super();
		this.shopassessID = assessID;
		this.assess = assess;
		this.attitude = attitude;
		this.effect = effect;
		this.theorder=theorder;
	}
	public int getShopassessID() {
		return shopassessID;
	}
	public void setShopassessID(int shopassessID) {
		this.shopassessID = shopassessID;
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
