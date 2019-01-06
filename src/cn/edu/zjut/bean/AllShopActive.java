package cn.edu.zjut.bean;

public class AllShopActive  implements java.io.Serializable{
	private String businessname;
	private String title;
	private String description;
	private String publisheddate;

	public String getBusinessname() {
		return businessname;
	}
	public void setBusinessname(String businessname) {
		this.businessname = businessname;
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
	public AllShopActive()
	{
		
	}
	public AllShopActive(String buinessname,String title,String description,String publisheddate)
	{
		this.businessname=buinessname;
		this.title=title;
		this.description=description;
		this.publisheddate=publisheddate;		
	}
}
