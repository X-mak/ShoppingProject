package com.vo;

public class ShopInfo {
	private int sh_id;
	private String sh_name;
	private Shop shop;
	public int getSh_id() {
		return sh_id;
	}
	public void setSh_id(int sh_id) {
		this.sh_id = sh_id;
	}
	public String getSh_name() {
		return sh_name;
	}
	public void setSh_name(String sh_name) {
		this.sh_name = sh_name;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	@Override
	public String toString() {
		return "ShopInfo [sh_id=" + sh_id + ", sh_name=" + sh_name + "]";
	}
	public ShopInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShopInfo(int sh_id) {
		super();
		this.sh_id = sh_id;
	}
	public ShopInfo(String sh_name) {
		super();
		this.sh_name = sh_name;
	}
	public ShopInfo(int sh_id, String sh_name) {
		super();
		this.sh_id = sh_id;
		this.sh_name = sh_name;
	}
	
}
