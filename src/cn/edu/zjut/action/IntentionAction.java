package cn.edu.zjut.action;

import cn.edu.zjut.po.Business;
import cn.edu.zjut.po.Liaisonuser;
import cn.edu.zjut.service.IntentionService;
import java.io.PrintStream;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import org.apache.struts2.ServletActionContext;

public class IntentionAction
{
	HttpServletRequest request= ServletActionContext.getRequest();
    HttpServletResponse response= ServletActionContext.getResponse();
    ServletContext application= ServletActionContext.getServletContext();
    HttpSession session= ServletActionContext.getRequest().getSession();
    List allIntention;
    int intentionID;
    
    //getter��setter
    public List getAllIntention()
    {
        return allIntention;
    }

    public void setAllIntention(List allIntention)
    {
        this.allIntention = allIntention;
    }

    public int getIntentionID()
    {
        return intentionID;
    }

    public void setIntentionID(int intentionID)
    {
        this.intentionID = intentionID;
    }
    
    //����BusinessID����liaisionuserID��ȡ�����б�
    public String getIntentionById()
    {
        IntentionService intenServ = new IntentionService();
        Business business=(Business) application.getAttribute("business");
        Liaisonuser liaisonuser=(Liaisonuser) application.getAttribute("liaisonuser");
        if(business!=null)
        {

        	if(business.getName()!=null)
        	{
        		System.out.println("是商家");
            	allIntention = intenServ.getIntentionByBID();
            	return "Businesssuccess";
        	}
        	
        }
        if(liaisonuser!=null)
        {
        	if(liaisonuser.getName()!=null)
        	{
        		System.out.println("是外联");
            	allIntention = intenServ.getIntentionByLID();
            	return "Liaisonsuccess";
        	}
        }
        return "failed";
    }
    
    //ȡ������
    public String cancelIntention()
    {
        //System.out.println("action1"); 
        intentionID = Integer.parseInt(request.getParameter("intentionID"));
        //System.out.println("action2");
        IntentionService intenServ = new IntentionService();
        //System.out.println("action3");
        if(intenServ.cancelIntention(intentionID))
        {
        	 getIntentionById();
        	 return "success";
        } 
        else
            return "failed";
    }

   
}
