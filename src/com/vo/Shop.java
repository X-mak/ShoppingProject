package com.vo;

public class Shop {
	private int sh_id;
	private String s_act;
	private ShopInfo shopInfo;
	private SellerInfo sellerInfo;
	public int getSh_id() {
		return sh_id;
	}
	public void setSh_id(int sh_id) {
		this.sh_id = sh_id;
	}
	public String getS_act() {
		return s_act;
	}
	public void setS_act(String s_act) {
		this.s_act = s_act;
	}
	public ShopInfo getShopInfo() {
		return shopInfo;
	}
	public void setShopInfo(ShopInfo shopInfo) {
		this.shopInfo = shopInfo;
	}
	public SellerInfo getSellerInfo() {
		return sellerInfo;
	}
	public void setSellerInfo(SellerInfo sellerInfo) {
		this.sellerInfo = sellerInfo;
	}
	@Override
	public String toString() {
		return "Shop [sh_id=" + sh_id + ", s_act=" + s_act + "]";
	}
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop(String s_act, ShopInfo shopInfo) {
		super();
		this.s_act = s_act;
		this.shopInfo = shopInfo;
	}
	public Shop(int sh_id, String s_act) {
		super();
		this.sh_id = sh_id;
		this.s_act = s_act;
	}

	

	
	
}
