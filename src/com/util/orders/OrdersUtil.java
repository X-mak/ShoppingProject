package com.util.orders;

import java.util.ArrayList;

import com.vo.Orders;

public interface OrdersUtil {

	
	public Orders havaOrder(int m_id,String b_act,int o_num);
	
	
	
	public boolean sellerChooseBuyer(int o_id);
	
	
	
	public boolean finshDeal(int o_id);
	
	
	
	public ArrayList<Orders> showAllOrders();
	
	
}
