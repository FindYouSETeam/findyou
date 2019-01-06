package cn.edu.zjut.po;

public class Shopactive {
	private int shopactiveID;
	private Business business;
	private String title;
	private String description;
	private String publisheddate;
	public int getShopactiveID() {
		return shopactiveID;
	}
	public void setShopactiveID(int shopactiveID) {
		this.shopactiveID = shopactiveID;
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisheddate() {
		return publisheddate;
	}
	public void setPublisheddate(String publisheddate) {
		this.publisheddate = publisheddate;
	}
	
	public Shopactive() 
	{
		
	}
	public Shopactive(int shopactiveID) {
		this.shopactiveID=shopactiveID;
	}
	public Shopactive(int shopactiveID,Business business,String title,String description,String publishdate)
	{
		super();
		this.shopactiveID=shopactiveID;
		this.business=business;
		this.title=title;
		this.description=description;
		this.publisheddate=publishdate;
	}
	
}
