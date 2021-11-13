package com.util.view;

import java.util.ArrayList;

import com.vo.Orders;

public interface OrdersViewUtil {

	
	public ArrayList<Orders> getBuyerOrders(String b_act);
	
	
	public ArrayList<Orders> showAllOrders();
	
	
	public ArrayList<Orders> showBuyerHistory(String b_act);
	
	
}
