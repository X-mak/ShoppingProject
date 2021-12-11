package com.vo;

public class MPicture {
	private int p_id;
	private String p_ads;
	private int m_id;
	private Merchandise merchandise;
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getP_ads() {
		return p_ads;
	}
	public void setP_ads(String p_ads) {
		this.p_ads = p_ads;
	}
	public Merchandise getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}
	@Override
	public String toString() {
		return "MPicture [p_ads=" + p_ads + ", m_id=" + m_id + "]";
	}
	public MPicture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MPicture(String p_ads, int m_id) {
		super();
		this.p_ads = p_ads;
		this.m_id = m_id;
	}
	public MPicture(String p_ads) {
		super();
		this.p_ads = p_ads;
	}
	public MPicture(int p_id, String p_ads, int m_id) {
		super();
		this.p_id = p_id;
		this.p_ads = p_ads;
		this.m_id = m_id;
	}
	
}
