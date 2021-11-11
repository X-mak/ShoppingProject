package com.vo;

import java.util.ArrayList;

public class BuyerInfo {
	private String b_act;
	private int b_tele;
	private BuyerAccount buyerAccount;
	private ArrayList<BuyerAddress> buyerAddress;
	public String getB_act() {
		return b_act;
	}
	public void setB_act(String b_act) {
		this.b_act = b_act;
	}
	public int getB_tele() {
		return b_tele;
	}
	public void setB_tele(int b_tele) {
		this.b_tele = b_tele;
	}
	public BuyerAccount getBuyerAccount() {
		return buyerAccount;
	}
	public void setBuyerAccount(BuyerAccount buyerAccount) {
		this.buyerAccount = buyerAccount;
	}

	public ArrayList<BuyerAddress> getBuyerAddress() {
		return buyerAddress;
	}
	public void setBuyerAddress(ArrayList<BuyerAddress> buyerAddress) {
		this.buyerAddress = buyerAddress;
	}
	@Override
	public String toString() {
		return "BuyerInfo [b_act=" + b_act + ", b_tele=" + b_tele + "]";
	}
	public BuyerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyerInfo(String b_act) {
		super();
		this.b_act = b_act;
	}
	public BuyerInfo(String b_act, int b_tele) {
		super();
		this.b_act = b_act;
		this.b_tele = b_tele;
	}
	public BuyerInfo(int b_tele) {
		super();
		this.b_tele = b_tele;
	}

	
	
}
