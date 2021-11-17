package com.vo;




public class Orders {
	private int o_id;
	private int m_id;
	private String b_act;
	private int sl_id;
	private int o_status;
	private int o_num;
	private Merchandise merchandise;
	private BuyerInfo buyerInfo;
	private StockLog stockLog;
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
	public int getSl_id() {
		return sl_id;
	}
	public void setSl_id(int sl_id) {
		this.sl_id = sl_id;
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
	public StockLog getStockLog() {
		return stockLog;
	}
	public void setStockLog(StockLog stockLog) {
		this.stockLog = stockLog;
	}
	@Override
	public String toString() {
		return "Orders [o_id=" + o_id + ", m_id=" + m_id + ", b_act=" + b_act + ", sl_id=" + sl_id + ", o_status="
				+ o_status + ", o_num=" + o_num + "]";
	}
	public Orders(int o_id, int m_id, String b_act, int sl_id, int o_status, int o_num) {
		super();
		this.o_id = o_id;
		this.m_id = m_id;
		this.b_act = b_act;
		this.sl_id = sl_id;
		this.o_status = o_status;
		this.o_num = o_num;
	}
	public Orders(int o_id) {
		super();
		this.o_id = o_id;
	}
	public Orders(int m_id, String b_act, int sl_id, int o_status, int o_num) {
		super();
		this.m_id = m_id;
		this.b_act = b_act;
		this.sl_id = sl_id;
		this.o_status = o_status;
		this.o_num = o_num;
	}
	public Orders() {
		super();
	}
	

	

}
