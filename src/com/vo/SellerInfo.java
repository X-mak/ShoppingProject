package com.vo;

public class SellerInfo {
	private String u_act;
	private int s_status;
	public String getU_act() {
		return u_act;
	}
	public void setU_act(String s_act) {
		this.u_act = s_act;
	}
	public int getS_status() {
		return s_status;
	}
	public void setS_status(int s_status) {
		this.s_status = s_status;
	}
	@Override
	public String toString() {
		return "SellerInfo [u_act=" + u_act + ", s_status=" + s_status + "]";
	}
	public SellerInfo(String u_act, int s_status) {
		super();
		this.u_act = u_act;
		this.s_status = s_status;
	}
	public SellerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerInfo(String u_act) {
		super();
		this.u_act = u_act;
	}


	
}
