package com.vo;

import java.sql.Date;

public class PriceLog {
	private int pl_id;
	private int m_id;
	private int pl_price;
	private String pl_date;
	private Merchandise merchandise;
	public int getPl_id() {
		return pl_id;
	}
	public void setPl_id(int pl_id) {
		this.pl_id = pl_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getPl_price() {
		return pl_price;
	}
	public void setPl_price(int pl_price) {
		this.pl_price = pl_price;
	}

	public String getPl_date() {
		return pl_date;
	}
	public void setPl_date(String pl_date) {
		this.pl_date = pl_date;
	}
	public Merchandise getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}
	@Override
	public String toString() {
		return "PriceLog [pl_id=" + pl_id + ", m_id=" + m_id + ", pl_price=" + pl_price + ", pl_date=" + pl_date + "]";
	}
	public PriceLog(int pl_id) {
		super();
		this.pl_id = pl_id;
	}
	public PriceLog(int m_id, int pl_price, String pl_date) {
		super();
		this.m_id = m_id;
		this.pl_price = pl_price;
		this.pl_date = pl_date;
	}
	public PriceLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PriceLog(int pl_id, int m_id, int pl_price, String pl_date) {
		super();
		this.pl_id = pl_id;
		this.m_id = m_id;
		this.pl_price = pl_price;
		this.pl_date = pl_date;
	}
	
}
