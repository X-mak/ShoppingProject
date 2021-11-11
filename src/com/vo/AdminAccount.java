package com.vo;



public class AdminAccount {
	private String a_act;
	private String a_pwd;
	public String getA_act() {
		return a_act;
	}
	public void setA_act(String a_act) {
		this.a_act = a_act;
	}
	public String getA_pwd() {
		return a_pwd;
	}
	public void setA_pwd(String a_pwd) {
		this.a_pwd = a_pwd;
	}
	public AdminAccount(String a_act, String a_pwd) {
		super();
		this.a_act = a_act;
		this.a_pwd = a_pwd;
	}
	public AdminAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "AdminAccount [a_act=" + a_act + ", a_pwd=" + a_pwd + "]";
	}


}
