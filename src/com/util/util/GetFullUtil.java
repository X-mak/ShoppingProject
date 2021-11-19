package com.util.util;

import com.vo.BuyerInfo;
import com.vo.Merchandise;
import com.vo.Orders;

/**
 * @author 徐敏阳
 * 获取完整数据的接口
 */
public interface GetFullUtil {

	/**
	 * 用于获取完整的商品Merchandise
	 * @param 商品信息Merchandise,需要包括m_id
	 * @return 成功则返回包含所有相关信息的Merchandise,失败则返回原参数
	 */
	public Merchandise getAllMerchan(Merchandise m);
	
	
	/**
	 * 用于获取完整的订单Orders
	 * @param 订单信息Orders,需要包括o_id
	 * @return 成功则返回包含所有相关信息的Orders,失败则返回原参数
	 */
	public Orders getAllOrders(Orders o);
	
	
	/**
	 * 用于获取完整的买家Buyer
	 * @param 买家信息BuyerInfo,需要包含b_act
	 * @return 成功则返回包含所有相关信息的BuyerInfo,失败则返回原参数
	 */
	public BuyerInfo getAllBuyer(BuyerInfo bi); 
	
}
