package com.vo;



public class Comments {
	private int c_id;
	private int m_id;
	private String b_act;
	private String c_content;
	private int c_star;
	
	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getB_act() {
		return b_act;
	}

	public void setB_act(String b_act) {
		this.b_act = b_act;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public int getC_star() {
		return c_star;
	}

	public void setC_star(int c_star) {
		this.c_star = c_star;
	}

	public Comments(int m_id, String b_act, String c_content, int c_star) {
		super();
		this.m_id = m_id;
		this.b_act = b_act;
		this.c_content = c_content;
		this.c_star = c_star;
	}

	public Comments(int m_id, String b_act) {
		super();
		this.m_id = m_id;
		this.b_act = b_act;
	}

	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}


}
