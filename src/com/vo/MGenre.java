package com.vo;

public class MGenre {
	private int m_id;
	private String genre1;
	private String genre2;
	private Merchandise merchandise;
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getGenre1() {
		return genre1;
	}
	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}
	public String getGenre2() {
		return genre2;
	}
	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}
	public Merchandise getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}
	@Override
	public String toString() {
		return "MGenre [m_id=" + m_id + ", genre1=" + genre1 + ", genre2=" + genre2 + "]";
	}
	public MGenre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MGenre(int m_id) {
		super();
		this.m_id = m_id;
	}
	public MGenre(String genre1, String genre2) {
		super();
		this.genre1 = genre1;
		this.genre2 = genre2;
	}
	public MGenre(int m_id, String genre1, String genre2) {
		super();
		this.m_id = m_id;
		this.genre1 = genre1;
		this.genre2 = genre2;
	}
	public MGenre(int m_id, String genre1) {
		super();
		this.m_id = m_id;
		this.genre1 = genre1;
	}

	
}
