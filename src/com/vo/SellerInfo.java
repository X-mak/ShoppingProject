package com.vo;

public class SellerInfo {
	private String s_act;
	private String a_act;
	public String getS_act() {
		return s_act;
	}
	public void setS_act(String s_act) {
		this.s_act = s_act;
	}
	public String getA_act() {
		return a_act;
	}
	public void setA_act(String a_act) {
		this.a_act = a_act;
	}
	@Override
	public String toString() {
		return "SellerInfo [s_act=" + s_act + ", a_act=" + a_act + "]";
	}
	public SellerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerInfo(String s_act, String a_act) {
		super();
		this.s_act = s_act;
		this.a_act = a_act;
	}

	
}
