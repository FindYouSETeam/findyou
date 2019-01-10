package cn.edu.zjut.service;
import java.sql.Blob;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.BusinessDAO;
import cn.edu.zjut.dao.BusinessdemandDAO;
import cn.edu.zjut.dao.IBusinessDAO;
import cn.edu.zjut.dao.IBusinessdemandDAO;
import cn.edu.zjut.dao.ILiaisonDAO;
import cn.edu.zjut.dao.ILiaisonassessDAO;
import cn.edu.zjut.dao.ILiaisondemandDAO;
import cn.edu.zjut.dao.ILiaisonuserDAO;
import cn.edu.zjut.dao.ILoginDAO;
import cn.edu.zjut.dao.IShopDAO;
import cn.edu.zjut.dao.IShopassessDAO;
import cn.edu.zjut.dao.IntentionDAO;
import cn.edu.zjut.dao.LiaisonDAO;
import cn.edu.zjut.dao.LiaisonassessDAO;
import cn.edu.zjut.dao.LiaisondemandDAO;
import cn.edu.zjut.dao.LiaisonuserDAO;
import cn.edu.zjut.dao.LoginDAO;
import cn.edu.zjut.dao.ShopDAO;
import cn.edu.zjut.dao.ShopassessDAO;
import cn.edu.zjut.po.*;

public class UserService implements IUserService{
	//HttpServletRequest request=ServletActionContext.getRequest();
	//HttpServletResponse response=ServletActionContext.getResponse();
	//ServletContext application=ServletActionContext.getServletContext();
	//HttpSession session=ServletActionContext.getRequest().getSession();
	
	private IBusinessDAO businessDAO = null;
	private ILiaisonuserDAO liaisonuserDAO = null;
	private ILoginDAO loginDAO = null;
	private IShopDAO shopDAO = null;
	private ILiaisonDAO liaisonDAO = null;
	private IShopassessDAO shopassessDAO = null;
	private IBusinessdemandDAO businessdemandDAO = null;
	private ILiaisondemandDAO liaisondemandDAO = null;
	private ILiaisonassessDAO liaisonassessDAO = null;
	
	
	public void setBusinessDAO(IBusinessDAO businessDAO) {
		this.businessDAO = businessDAO;
	}
	public void setLiaisonuserDAO(ILiaisonuserDAO liaisonuserDAO) {
		this.liaisonuserDAO = liaisonuserDAO;
	}
	public void setLoginDAO(ILoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	public void setShopDAO(IShopDAO shopDAO) {
		this.shopDAO = shopDAO;
	}
	public void setLiaisonDAO(ILiaisonDAO liaisonDAO) {
		this.liaisonDAO = liaisonDAO;
	}
	public void setShopassessDAO(IShopassessDAO shopassessDAO) {
		this.shopassessDAO = shopassessDAO;
	}
	public void setBusinessdemandDAO(IBusinessdemandDAO businessdemandDAO) {
		this.businessdemandDAO = businessdemandDAO;
	}
	public void setLiaisondemandDAO(ILiaisondemandDAO liaisondemandDAO) {
		this.liaisondemandDAO = liaisondemandDAO;
	}
	public void setLiaisonassessDAO(ILiaisonassessDAO liaisonassessDAO) {
		this.liaisonassessDAO = liaisonassessDAO;
	}
	
	public boolean business_register_basic(Business business,Login login)  //商家注册基础模块
	{
        ///Transaction tran = null;
		//BusinessDAO dao=new BusinessDAO();
		//LoginDAO logindao=new LoginDAO();
		try
		{
            ///tran=((BusinessDAO) businessDAO).getSession().beginTransaction();
			loginDAO.save(login);
			business.setLogin(login);
			application.setAttribute("business", business);
			businessDAO.save(business);
            ///tran.commit();
			return true;
		}catch (Exception e) {
            ///if(tran != null) tran.rollback();
			return false;
			} finally {
            //((BusinessDAO) businessDAO).getSession().close();
			}
			}
	public boolean business_register_detail(Business business,Shop shop) //商家注册详细模块
	{
		business=(Business)application.getAttribute("business");
		String hql = "from Business where account='" + business.getLogin().getAccount()
				+ "'";
        ///Transaction tran = null;
		//BusinessDAO dao=new BusinessDAO();
		//ShopDAO shopdao=new ShopDAO();
		try
		{
			List list=businessDAO.findByHql(hql);
            //((BusinessDAO) businessDAO).getSession().close();
            ///tran=((BusinessDAO) businessDAO).getSession().beginTransaction();
			business=(Business)list.get(0);
			shop.setBusiness(business);
			shopDAO.save(shop);
            ///tran.commit();
			return true;
		}catch (Exception e) {
            ///if(tran != null) tran.rollback();
			return false;
			} finally {
            //((BusinessDAO) businessDAO).getSession().close();
			}
	}
	public boolean user_register_basic(Liaisonuser liaisonuser,Login login)  //用户注册基础模块
	{
        ///Transaction tran = null;
		//LiaisonuserDAO dao=new LiaisonuserDAO();
		//LoginDAO logindao=new LoginDAO();
		try
		{
            ///tran=((LiaisonuserDAO) liaisonuserDAO).getSession().beginTransaction();
			loginDAO.save(login);
			liaisonuser.setLogin(login);
			application.setAttribute("liaisonuser", liaisonuser);
			liaisonuserDAO.save(liaisonuser);
            ///tran.commit();
			return true;
		}catch (Exception e) {
            ///if(tran != null) tran.rollback();
			return false;
			} finally {
            //((LiaisonuserDAO) liaisonuserDAO).getSession().close();
			}
			}
	public boolean user_register_detail(Liaisonuser liaisonuser,Liaison liaison) //用户注册详细模块
	{
		liaisonuser=(Liaisonuser)application.getAttribute("liaisonuser");
		String hql= "from Liaisonuser where account='" + liaisonuser.getLogin().getAccount()+"'";
        ///Transaction tran = null;
		//BusinessDAO dao=new BusinessDAO();
		//LiaisonDAO liasiondao=new LiaisonDAO();
		try
		{
			List list=businessDAO.findByHql(hql);
            //((BusinessDAO) businessDAO).getSession().close();
            ///tran=((BusinessDAO) businessDAO).getSession().beginTransaction();
			liaisonuser=(Liaisonuser)list.get(0);
			liaison.setLiaisonuser(liaisonuser);
			liaisonDAO.save(liaison);
            ///tran.commit();
			return true;
		}catch (Exception e) {
            ///if(tran != null) tran.rollback();
			return false;
			} finally {
            //((BusinessDAO) businessDAO).getSession().close();
			}
	}
	public boolean createShopAssess( Shopassess shopassess,int orderID)  //评价店铺
	{
        ///Transaction tran=null;
		//ShopassessDAO dao=new ShopassessDAO();
		try
		{
            ///tran=((ShopassessDAO) shopassessDAO).getSession().beginTransaction();
			//shopassess.getTheorder().setOrderID(orderID);
			shopassessDAO.save(shopassess);
            ///tran.commit();
			return true;
		}catch (Exception e) {
            ///if(tran != null) tran.rollback();
			return false;
			} finally {
            //((ShopassessDAO) shopassessDAO).getSession().close();
			}
		
	}
	public boolean LoginService(Login login,String type)              //登录    
	{
		String hql;
	try
	{
		if(type.equals("liaisonuser"))
		{
            ///Transaction tran = null;
            ///tran=((LiaisonuserDAO) liaisonuserDAO).getSession().beginTransaction();
			
			//LiaisonuserDAO dao=new LiaisonuserDAO();
			hql=  "from Liaisonuser where account='"+login.getAccount()+"'";
			List list=liaisonuserDAO.findByHql(hql);
			Liaisonuser liaisonuser =( Liaisonuser)list.get(0);
			application.setAttribute("liaisonuser", liaisonuser);
			System.out.println("外联登录放application");
			System.out.println(liaisonuser.getName());
            //((LiaisonuserDAO) liaisonuserDAO).getSession().close();
            ///tran.commit();

		}
		if(type.equals("business"))
		{
            ///Transaction tran = null;
            ///tran=((BusinessDAO) businessDAO).getSession().beginTransaction();
			
			//BusinessDAO dao= new BusinessDAO(); 	
			hql= "from Business where account='"+login.getAccount()+"'";
			List list=businessDAO.findByHql(hql);
			Business business=(Business)list.get(0);
			application.setAttribute("business", business);
			System.out.println("商家登录放application");
			System.out.println(business.getName());
            //((BusinessDAO) businessDAO).getSession().close();
            ///tran.commit();
		}
		return true;
		}
		catch (Exception e) {
				return false;
	}
	}
	public Businessdemand findBusinessdemandbyID(int businessdemandID) //用businessdemandID查询指定商家需求信息
	{
		String hql;
		List list;
		//BusinessdemandDAO dao=new BusinessdemandDAO();
		hql="from Businessdemand where businessdemandID="+businessdemandID;
        ///Transaction tran = null;
        ///tran=((BusinessdemandDAO) businessdemandDAO).getSession().beginTransaction();
		
		list=businessdemandDAO.findByHql(hql);
        ///tran.commit();
		Businessdemand businessdemand=(Businessdemand)list.get(0);
        //((BusinessdemandDAO) businessdemandDAO).getSession().close();
		return businessdemand;
	}
	public Liaisondemand findLiaisondemandbyID(int liaisondemandID) //用liaisondemandID查外联指定需求信息
	{
		String hql;
		List list;
		//BusinessdemandDAO dao=new BusinessdemandDAO();
		hql="from Liaisondemand where liaisondemandID="+liaisondemandID;
        //Transaction tran = null;
        //tran=((BusinessdemandDAO) businessdemandDAO).getSession().beginTransaction();
		
		list=businessdemandDAO.findByHql(hql);
        //tran.commit();
		Liaisondemand liaisondemand=(Liaisondemand)list.get(0);
        //((BusinessdemandDAO) businessdemandDAO).getSession().close();
		return liaisondemand;
	}
	public List findallbusinessService() //外联登录显示所有商家的需求列表
	{
		String hql;
		List list;
		//BusinessdemandDAO dao=new BusinessdemandDAO();
		hql="select new cn.edu.zjut.bean.showBusinessdemand(demand.businessdemandID,demand.publisheddate,demand.period,demand.mincapital,"
				+ "demand.maxcapital,demand.overallnum,demand.status,demand.business.businessID,"
				+ "shop.shopID,shop.shopname,shop.qualification,shop.shoptype,shop.shopdetail,shop.shopfront,shop.address) "
				+ "from Businessdemand demand,Shop shop Where demand.business.businessID=shop.business.businessID";
        ///Transaction tran = null;
        ///tran=((BusinessdemandDAO) businessdemandDAO).getSession().beginTransaction();
		
		list=businessdemandDAO.findByHql(hql);
        ///tran.commit();
        //((BusinessdemandDAO) businessdemandDAO).getSession().close();
		return list;
	}
	public List findliaisonService() //商家登录显示所有外联的需求列表
	{
			String hql;
			List list;
			//LiaisondemandDAO dao=new LiaisondemandDAO();
			hql="select new cn.edu.zjut.po.ShowLiaisondemand(demand.liaisondemandID,demand.publisheddate,demand.period,demand.activityname,demand.mincapital,"
					+ "demand.maxcapital,demand.activitydetail,demand.overallnum,demand.status,demand.conductdetail,"
					+"demand.liaisonuser.liaisonuserID,demand.type,"
					+ "liaison.departmentdetail,liaison.address,liaisonuser.phone)"
					+ "from Liaisondemand demand,Liaison liaison,Liaisonuser liaisonuser Where demand.liaisonuser.liaisonuserID=liaison.liaisonuser.liaisonuserID"
					+ " and liaison.liaisonuser.liaisonuserID=liaisonuser.liaisonuserID";
        ///Transaction tran = null;
        ///tran=((LiaisondemandDAO) liaisondemandDAO).getSession().beginTransaction();
			
			list=liaisondemandDAO.findByHql(hql);
        ///tran.commit();
        //((LiaisondemandDAO) liaisondemandDAO).getSession().close();
			
			return list;
	}
	public boolean updateBusinessInfo(Business business,Login login)   //更新商家信息
	{
		//BusinessDAO businessdao=new BusinessDAO();
        //LoginDAO logindao=new LoginDAO();
        ///Transaction tran = null;
		try
		{
            ///tran=((BusinessDAO) businessDAO).getSession().beginTransaction();
            loginDAO.update(login);
			business.setLogin(login);
			application.setAttribute("business", business);
			businessDAO.update(business);
            ///tran.commit();
			return true;
		}catch (Exception e) {
            ///if(tran != null) tran.rollback();
			return false;
			} finally {
            //((BusinessDAO) businessDAO).getSession().close();
			}
	}
	public boolean updateLiaisonInfo(Liaisonuser liaisonuser,Login login)   //更新外联信息
	{
		//LiaisonuserDAO liaisonuserdao=new LiaisonuserDAO();
		//LoginDAO logindao=new LoginDAO();
        ///Transaction tran = null;
		try
		{
            ///tran=((LoginDAO) loginDAO).getSession().beginTransaction();
			liaisonuser.setLogin(login);
			login.setLiaisonuser(liaisonuser);
			loginDAO.update(login);
			liaisonuserDAO.update(liaisonuser);
            ///tran.commit();
			application.setAttribute("liaisonuser", liaisonuser);
			return true;
		}catch (Exception e) {
            ///if(tran != null) tran.rollback();
			return false;
			} finally {
            //((LiaisonuserDAO) liaisonuserDAO).getSession().close();
			}
	}
	public boolean createLiaisonAssess( Liaisonassess assess,int orderID) //评价外联
	{
        ///Transaction tran=null;
		//LiaisonassessDAO dao=new LiaisonassessDAO();
		try
		{
            ///tran=((LiaisonassessDAO) liaisonassessDAO).getSession().beginTransaction();
			liaisonassessDAO.save(assess);
            ///tran.commit();
			return true;
		}catch (Exception e) {
            ///if(tran != null) tran.rollback();
			return false;
			} finally {
            //((LiaisonassessDAO) liaisonassessDAO).getSession().close();
			}
		
	}
	
	public List findBusinessdemandbybussinessID(int businessID) //用businessID查询历史发布订单
	{
		System.out.println("来查找历史");
		String hql;
		List list;
		//BusinessdemandDAO dao=new BusinessdemandDAO();
		hql="select new cn.edu.zjut.bean.showBusinessdemand(demand.businessdemandID,demand.publisheddate,demand.period,demand.mincapital,"
				+ "demand.maxcapital,demand.overallnum,demand.status,demand.business.businessID,"
				+ "shop.shopID,shop.shopname,shop.qualification,shop.shoptype,shop.shopdetail,shop.shopfront,shop.address) "
				+ "from Businessdemand demand,Shop shop Where demand.business.businessID=shop.business.businessID and demand.business.businessID="+businessID;
        ///Transaction tran = null;
        ///tran=((BusinessdemandDAO) businessdemandDAO).getSession().beginTransaction();

        list = businessdemandDAO.findByHql(hql);
        ///tran.commit();
        //((BusinessdemandDAO) businessdemandDAO).getSession().close();
		return list;
	}
	public List findliaisondemandbyliaisonID(int liaisonID) //外联查看历史订单
	{
			String hql;
			List list;
			//LiaisondemandDAO dao=new LiaisondemandDAO();
			System.out.println("查看外联历史订单");
			hql="select new cn.edu.zjut.po.ShowLiaisondemand(demand.liaisondemandID,demand.publisheddate,demand.period,demand.activityname,demand.mincapital,"
					+ "demand.maxcapital,demand.activitydetail,demand.overallnum,demand.status,demand.conductdetail,"
					+"demand.liaisonuser.liaisonuserID,demand.type,"
					+ "liaison.departmentdetail,liaison.address,liaisonuser.phone)"
					+ "from Liaisondemand demand,Liaison liaison,Liaisonuser liaisonuser Where demand.liaisonuser.liaisonuserID=liaison.liaisonuser.liaisonuserID"
					+ " and liaison.liaisonuser.liaisonuserID=liaisonuser.liaisonuserID and demand.liaisonuser.liaisonuserID="+liaisonID;
        ///Transaction tran = null;
        ///tran=((LiaisondemandDAO) liaisondemandDAO).getSession().beginTransaction();
			
			list=liaisondemandDAO.findByHql(hql);
        ///tran.commit();
        //((LiaisondemandDAO) liaisondemandDAO).getSession().close();
			
			return list;
	}


    public boolean alreadyassesshop(int orderID)//判断是否评价过商家
    {
        String hql;
        List list;
        hql = "from Shopassess where orderID=" + orderID;
        list = shopassessDAO.findByHql(hql);
        if (list.size() == 0) {
            return false;
        } else return true;
    }

    public boolean alreadyassesliaison(int orderID)//判断是否评价过外联
    {
        String hql;
        List list;
        hql = "from Liaisonassess where orderID=" + orderID;
        list = liaisonassessDAO.findByHql(hql);
        if (list.size() == 0) {
            return false;
        } else return true;
    }

}
