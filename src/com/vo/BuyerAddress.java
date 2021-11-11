package com.vo;

public class BuyerAddress {
	private int ba_id;
	private String b_act;
	private String b_ads;
	public int getBa_id() {
		return ba_id;
	}
	public void setBa_id(int ba_id) {
		this.ba_id = ba_id;
	}
	public String getB_act() {
		return b_act;
	}
	public void setB_act(String b_act) {
		this.b_act = b_act;
	}
	public String getB_ads() {
		return b_ads;
	}
	public void setB_ads(String b_ads) {
		this.b_ads = b_ads;
	}

	@Override
	public String toString() {
		return "buyeraddress [ba_id=" + ba_id + ", b_act=" + b_act + ", b_ads=" + b_ads + "]";
	}
	public BuyerAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyerAddress(int ba_id) {
		super();
		this.ba_id = ba_id;
	}
	public BuyerAddress(String b_act, String b_ads) {
		super();
		this.b_act = b_act;
		this.b_ads = b_ads;
	}

	public BuyerAddress(int ba_id, String b_act, String b_ads) {
		super();
		this.ba_id = ba_id;
		this.b_act = b_act;
		this.b_ads = b_ads;
	}
	
}
