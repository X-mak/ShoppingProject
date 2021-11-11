package com.vo;




public class Orders {
	private int o_id;
	private int m_id;
	private String b_act;
	private int o_status;
	private int o_num;
	private Merchandise merchandise;
	private BuyerInfo buyerInfo;
	
	
	@Override
	public String toString() {
		return "Orders [m_id=" + m_id + ", b_act=" + b_act + ", o_status=" + o_status + ", o_num=" + o_num + "]";
	}
	
	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
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
	public int getO_status() {
		return o_status;
	}
	public void setO_status(int o_status) {
		this.o_status = o_status;
	}
	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public Merchandise getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}
	public BuyerInfo getBuyerInfo() {
		return buyerInfo;
	}
	public void setBuyerInfo(BuyerInfo buyerInfo) {
		this.buyerInfo = buyerInfo;
	}
	public Orders(int m_id, String b_act) {
		super();
		this.m_id = m_id;
		this.b_act = b_act;
	}
	
	public Orders(int m_id, String b_act, int o_status, int o_num) {
		super();
		this.m_id = m_id;
		this.b_act = b_act;
		this.o_status = o_status;
		this.o_num = o_num;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int o_id, int m_id, String b_act, int o_status, int o_num) {
		super();
		this.o_id = o_id;
		this.m_id = m_id;
		this.b_act = b_act;
		this.o_status = o_status;
		this.o_num = o_num;
	}

	public Orders(int o_id) {
		super();
		this.o_id = o_id;
	}
	

}
