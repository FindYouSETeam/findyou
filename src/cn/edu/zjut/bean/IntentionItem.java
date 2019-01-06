package cn.edu.zjut.bean;


public class IntentionItem
{
	  private String shopName;
	    private int shopID;
	    private int businessDemandID;
	    private int liaisonDemandID;
	    private String mincapital;
	    private String maxcapital;
	    private String applyDate;
	    private String status;
	    private int intentionID;
	    
    public IntentionItem()
    {
    }

    public IntentionItem(String shopName, int shopID, int businessDemandID, int liaisonDemandID, String mincapital, String maxcapital, String applyDate, 
            String status, int intentionID)
    {
        this.shopName = shopName;
        this.shopID = shopID;
        this.businessDemandID = businessDemandID;
        this.liaisonDemandID = liaisonDemandID;
        this.mincapital = mincapital;
        this.maxcapital = maxcapital;
        this.applyDate = applyDate;
        this.status = status;
        this.intentionID = intentionID;
    }

    public String getShopName()
    {
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public int getShopID()
    {
        return shopID;
    }

    public void setShopID(int shopID)
    {
        this.shopID = shopID;
    }

    public int getBusinessDemandID()
    {
        return businessDemandID;
    }

    public void setBusinessDemandID(int businessDemandID)
    {
        this.businessDemandID = businessDemandID;
    }

    public int getLiaisonDemandID()
    {
        return liaisonDemandID;
    }

    public void setLiaisonDemandID(int liaisonDemandID)
    {
        this.liaisonDemandID = liaisonDemandID;
    }

    public String getMincapital()
    {
        return mincapital;
    }

    public void setMincapital(String mincapital)
    {
        this.mincapital = mincapital;
    }

    public String getMaxcapital()
    {
        return maxcapital;
    }

    public void setMaxcapital(String maxcapital)
    {
        this.maxcapital = maxcapital;
    }

    public String getApplyDate()
    {
        return applyDate;
    }

    public void setApplyDate(String applyDate)
    {
        this.applyDate = applyDate;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public int getIntentionID()
    {
        return intentionID;
    }

    public void setIntentionID(int intentionID)
    {
        this.intentionID = intentionID;
    }

  
}
