package com.vo;

public class BuyerAccount {
	private String b_act;
	private String b_pwd;
	public String getB_act() {
		return b_act;
	}
	public void setB_act(String b_act) {
		this.b_act = b_act;
	}
	public String getB_pwd() {
		return b_pwd;
	}
	public void setB_pwd(String b_pwd) {
		this.b_pwd = b_pwd;
	}

	@Override
	public String toString() {
		return "BuyerAccount [b_act=" + b_act + ", b_pwd=" + b_pwd + "]";
	}
	public BuyerAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyerAccount(String b_act, String b_pwd) {
		super();
		this.b_act = b_act;
		this.b_pwd = b_pwd;
	}

}
