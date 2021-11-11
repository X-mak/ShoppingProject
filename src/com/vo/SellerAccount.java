package com.vo;

public class SellerAccount {
	private String s_act;
	private String s_pwd;
	private int s_status;
	public int getS_status() {
		return s_status;
	}
	public void setS_status(int s_status) {
		this.s_status = s_status;
	}
	public String getS_act() {
		return s_act;
	}
	public void setS_act(String s_act) {
		this.s_act = s_act;
	}
	public String getS_pwd() {
		return s_pwd;
	}
	public void setS_pwd(String s_pwd) {
		this.s_pwd = s_pwd;
	}


	@Override
	public String toString() {
		return "SellerAccount [s_act=" + s_act + ", s_pwd=" + s_pwd + "]";
	}
	public SellerAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerAccount(String s_act, String s_pwd) {
		super();
		this.s_act = s_act;
		this.s_pwd = s_pwd;
	}
	public SellerAccount(String s_act, String s_pwd, int s_status) {
		super();
		this.s_act = s_act;
		this.s_pwd = s_pwd;
		this.s_status = s_status;
	}

	
	
}
