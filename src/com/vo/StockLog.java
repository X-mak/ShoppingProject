package com.vo;

import java.sql.Date;

public class StockLog {
	private int sl_id;
	private int m_id;
	private int o_id;
	private int sl_num;
	private String sl_date;
	private Merchandise merchandise;
	private Orders order;
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
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
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
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "StockLog [sl_id=" + sl_id + ", m_id=" + m_id + ", o_id=" + o_id + ", sl_num=" + sl_num + ", sl_date="
				+ sl_date + "]";
	}
	public StockLog(int sl_id, int m_id, int o_id, int sl_num, String sl_date) {
		super();
		this.sl_id = sl_id;
		this.m_id = m_id;
		this.o_id = o_id;
		this.sl_num = sl_num;
		this.sl_date = sl_date;
	}
	public StockLog(int sl_id) {
		super();
		this.sl_id = sl_id;
	}
	public StockLog(int m_id, int o_id, int sl_num, String sl_date) {
		super();
		this.m_id = m_id;
		this.o_id = o_id;
		this.sl_num = sl_num;
		this.sl_date = sl_date;
	}
	public StockLog(int m_id, int sl_num, String sl_date) {
		super();
		this.m_id = m_id;
		this.sl_num = sl_num;
		this.sl_date = sl_date;
	}
	public StockLog(int m_id, int sl_num) {
		super();
		this.m_id = m_id;
		this.sl_num = sl_num;
	}
	public StockLog() {
		super();
	}
	
	
}
