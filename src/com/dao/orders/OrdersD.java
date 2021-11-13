package com.dao.orders;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.Orders;

public interface OrdersD {

	
	
	public Orders insertOrders(Orders o)throws SQLException;
	
	
	public boolean updateStatus(Orders o,int o_status)throws SQLException;
	
	
	public boolean deleteOrders(Orders o)throws SQLException;
	
	
	public Orders selectBuyerInfo(Orders o)throws SQLException;
	
	
	public Orders selectMerchandise(Orders o)throws SQLException;
	
	
	public Orders selectOrdersById(int o_id)throws SQLException;
	
	
	public ArrayList<Orders> selectByBuyerStatus(String b_act,int o_status)throws SQLException;
	
	
	public ArrayList<Orders> selectOrders()throws SQLException;
	
	
	public ArrayList<Orders> selectAllOrders()throws SQLException;
	
	
	public ArrayList<Orders> selectByAct(String b_act)throws SQLException;
	
}
