package com.vo;

public class UserAccount {

	private String u_act;
	private String u_pwd;
	private UserGroup userGroup;
	public String getU_act() {
		return u_act;
	}
	public void setU_act(String u_act) {
		this.u_act = u_act;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	
	public UserGroup getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
	@Override
	public String toString() {
		return "UserAccount [u_act=" + u_act + ", u_pwd=" + u_pwd + "]";
	}
	public UserAccount(String u_act, String u_pwd) {
		super();
		this.u_act = u_act;
		this.u_pwd = u_pwd;
	}
	
	public UserAccount(String u_act) {
		super();
		this.u_act = u_act;
	}
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
