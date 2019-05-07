package model;

import java.sql.Date;

public class User {
	private String login;
	private String pwd;
	private String fname;
	private String lname;
	private String identity;
	private String society;
	private String phone;
	private Date cdate;
	private String stat;
	
	public User() {
		
	}
	
	public User(String login, String pwd, String fname, String lname, 
			String identity, String society, String phone, Date cdate, String stat) {
		this.login = login;
		this.pwd = pwd;
		this.fname = fname;
		this.lname = lname;
		this.identity = identity;
		this.society = society;
		this.phone = phone;
		this.cdate = cdate;
		this.stat = stat;
	}
	
	// methods of get
	public String getLogin() {
		return login;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public String getFname() {
		return fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	
	public String getIndentity() {
		return identity;
	}
	
	public String getSociety() {
		return society;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public Date getCdate() {
		return cdate;
	}
	
	public String getStat() {
		return stat;
	}
	
	// methods of set
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	public void setSociety(String society) {
		this.society = society;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	
	public void setStat(String stat) {
		this.stat = stat;
	}
	
	// methods of show
	public String toString() {
		return "User(" + "login=" + login + ", lastName=" + lname + ", firstName=" + fname + 
				", society=" + society + ", identity=" + identity + ")";
	}
	
}

