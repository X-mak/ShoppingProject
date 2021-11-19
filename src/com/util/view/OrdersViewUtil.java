package com.util.view;

import java.util.ArrayList;

import com.vo.Orders;

/**
 * @author 徐敏阳
 * 展示订单信息的接口
 */
public interface OrdersViewUtil {

	
	/**
	 * 用于获得某个买家的所有订单
	 * @param 字符串b_act,买家的账号用户名
	 * @return 成功则返回包含该用户拥有的所有Orders的数组,失败则返回空数组
	 */
	public ArrayList<Orders> getBuyerOrders(String b_act);
	
	
	/**
	 * 用于获得所有的订单
	 * @return 成功则返回包含所有的Orders的数组,失败则返回空数组
	 */
	public ArrayList<Orders> showAllOrders();
	
	
}
