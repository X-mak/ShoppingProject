package com.util.management;

import com.vo.Orders;

/**
 * @author 徐敏阳
 * 订单管理的接口
 */
public interface OrdersManageUtil {

	
	/**
	 * 用于新增订单
	 * @param 整数m_id,购买商品的id
	 * @param 字符串b_act,买家的账号用户名
	 * @param 整数o_num,购买商品的数量
	 * @return 成功则返回获得完整信息的Orders,失败则返回null
	 */
	public Orders havaOrder(int m_id,String b_act,int o_num);
	
	
	/**
	 * 用于确认订单
	 * @param 整数o_id,订单的id
	 * @return 操作是否成功
	 */
	public boolean sellerChooseBuyer(int o_id);
	
	
	/**
	 * 用于完成线下交易
	 * @param 整数o_id,订单的id
	 * @return 操作是否成功
	 */
	public boolean finshDeal(int o_id);
	
	
	/**
	 * 用于删除订单或交易失败
	 * @param 整数o_id,订单的id
	 * @return 删除是否成功
	 */
	public boolean deleteOrder(int o_id);
	
	
}
