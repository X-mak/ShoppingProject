package com.vo;

import java.util.ArrayList;

public class BuyerInfo {
	private String u_act;
	private String b_tele;
	private ArrayList<BuyerAddress> buyerAddress;
	public String getU_act() {
		return u_act;
	}
	public void setU_act(String b_act) {
		this.u_act = b_act;
	}
	public String getB_tele() {
		return b_tele;
	}
	public void setB_tele(String b_tele) {
		this.b_tele = b_tele;
	}

	public ArrayList<BuyerAddress> getBuyerAddress() {
		return buyerAddress;
	}
	public void setBuyerAddress(ArrayList<BuyerAddress> buyerAddress) {
		this.buyerAddress = buyerAddress;
	}
	@Override
	public String toString() {
		return "BuyerInfo [b_act=" + u_act + ", b_tele=" + b_tele + "]";
	}
	public BuyerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyerInfo(String b_act) {
		super();
		this.u_act = b_act;
	}
	public BuyerInfo(String b_act, String b_tele) {
		super();
		this.u_act = b_act;
		this.b_tele = b_tele;
	}


	
	
}
