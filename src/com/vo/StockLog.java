package com.vo;

import java.sql.Date;

public class StockLog {
	private int sl_id;
	private int m_id;
	private int sl_num;
	private String sl_date;
	private Merchandise merchandise;
	public int getSl_id() {
		return sl_id;
	}
	public void setSl_id(int sl_id) {
		this.sl_id = sl_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getSl_num() {
		return sl_num;
	}
	public void setSl_num(int sl_num) {
		this.sl_num = sl_num;
	}
	
	public String getSl_date() {
		return sl_date;
	}
	public void setSl_date(String sl_date) {
		this.sl_date = sl_date;
	}
	public Merchandise getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}
	@Override
	public String toString() {
		return "StockLog [sl_id=" + sl_id + ", m_id=" + m_id + ", sl_num=" + sl_num + ", sl_date=" + sl_date + "]";
	}
	public StockLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StockLog(int sl_id) {
		super();
		this.sl_id = sl_id;
	}
	public StockLog(int m_id, int sl_num, String sl_date) {
		super();
		this.m_id = m_id;
		this.sl_num = sl_num;
		this.sl_date = sl_date;
	}
	public StockLog(int sl_id, int m_id, int sl_num, String sl_date) {
		super();
		this.sl_id = sl_id;
		this.m_id = m_id;
		this.sl_num = sl_num;
		this.sl_date = sl_date;
	}
	
}
