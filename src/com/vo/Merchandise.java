package com.vo;

import java.util.ArrayList;

public class Merchandise {
	private int m_id;
	private int sh_id;
	private String m_name;
	private String m_intro;
	private Shop shop;
	private ArrayList<MPicture> mPicture;
	private ArrayList<PriceLog> priceLog;
	private ArrayList<StockLog> stockLog;
	private MGenre mGenre;
	private int m_status;
	private int m_price;
	private int m_num;
	
	public int getM_status() {
		return m_status;
	}
	public void setM_status(int m_status) {
		this.m_status = m_status;
	}
	public int getM_price() {
		return m_price;
	}
	public void setM_price(int m_price) {
		this.m_price = m_price;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getSh_id() {
		return sh_id;
	}
	public void setSh_id(int sh_id) {
		this.sh_id = sh_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_intro() {
		return m_intro;
	}
	public void setM_intro(String m_intro) {
		this.m_intro = m_intro;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public ArrayList<MPicture> getmPicture() {
		return mPicture;
	}
	public void setmPicture(ArrayList<MPicture> mPicture) {
		this.mPicture = mPicture;
	}
	public ArrayList<PriceLog> getPriceLog() {
		return priceLog;
	}
	public void setPriceLog(ArrayList<PriceLog> priceLog) {
		this.priceLog = priceLog;
	}
	public ArrayList<StockLog> getStockLog() {
		return stockLog;
	}
	public void setStockLog(ArrayList<StockLog> stockLog) {
		this.stockLog = stockLog;
	}
	public MGenre getmGenre() {
		return mGenre;
	}
	public void setmGenre(MGenre mGenre) {
		this.mGenre = mGenre;
	}
	@Override
	public String toString() {
		return "Merchandise [m_id=" + m_id + ", sh_id=" + sh_id + ", m_name=" + m_name + ", m_intro=" + m_intro + "]";
	}
	public Merchandise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Merchandise(int m_id) {
		super();
		this.m_id = m_id;
	}
	public Merchandise(int sh_id, String m_name, String m_intro) {
		super();
		this.sh_id = sh_id;
		this.m_name = m_name;
		this.m_intro = m_intro;
	}
	public Merchandise(int sh_id, String m_name, String m_intro, Shop shop, ArrayList<MPicture> mPicture,
			ArrayList<PriceLog> priceLog, ArrayList<StockLog> stockLog, MGenre mGenre) {
		super();
		this.sh_id = sh_id;
		this.m_name = m_name;
		this.m_intro = m_intro;
		this.shop = shop;
		this.mPicture = mPicture;
		this.priceLog = priceLog;
		this.stockLog = stockLog;
		this.mGenre = mGenre;
	}
	public Merchandise(int m_id, int sh_id, String m_name, String m_intro) {
		super();
		this.m_id = m_id;
		this.sh_id = sh_id;
		this.m_name = m_name;
		this.m_intro = m_intro;
	}
	public Merchandise(int m_id, int sh_id, String m_name, String m_intro, int m_status) {
		super();
		this.m_id = m_id;
		this.sh_id = sh_id;
		this.m_name = m_name;
		this.m_intro = m_intro;
		this.m_status = m_status;
	}
	
	
}
