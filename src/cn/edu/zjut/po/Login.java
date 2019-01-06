package cn.edu.zjut.po;

public class Login {
	private String account;
	private String password;
	private Business business;
	private Liaisonuser liaisonuser;
	
	public Liaisonuser getLiaisonuser() {
		return liaisonuser;
	}
	public void setLiaisonuser(Liaisonuser liaisonuser) {
		this.liaisonuser = liaisonuser;
	}
	public Login() {}
	public Login(String account) {
		super();
		this.account = account;
	}
	public Login(String account, String password,Business business,Liaisonuser liaisonuser) {
		super();
		this.account = account;
		this.password = password;
		this.business=business;
		this.liaisonuser=liaisonuser;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
}
