package com.dao.orders;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.Orders;

/**
 * @author 徐敏阳
 * 订单相关的连接数据库接口
 */
public interface OrdersD {

	/**
	 * 用于加入一条新的订单信息
	 * @param 订单信息Orders,需要包括o_id外所有元素
	 * @return 成功则返回包含主键的Orders,失败则返回原参数
	 * @throws SQLException
	 */
	public Orders insertOrders(Orders o)throws SQLException;
	
	
	/**
	 * 用于更新订单的状态
	 * @param 订单信息Orders,需要包括o_id
	 * @param 整数o_status,为更新后的订单状态
	 * @return 更新是否成功
	 * @throws SQLException
	 */
	public boolean updateStatus(Orders o,int o_status)throws SQLException;
	
	
	/**
	 * 用于删除订单信息
	 * @param 订单信息Orders,需要包括o_id
	 * @return 删除是否成功
	 * @throws SQLException
	 */
	public boolean deleteOrders(Orders o)throws SQLException;
	
	
	/**
	 * 用于获取订单的买家信息
	 * @param 订单信息Orders,需要包括b_act
	 * @return 成功则返回包含买家信息的Orders,失败则返回原参数
	 * @throws SQLException
	 */
	public Orders selectBuyerInfo(Orders o)throws SQLException;
	
	
	/**
	 * 用于获取订单的商品信息
	 * @param 订单信息Orders,需要包括m_id
	 * @return 成功则返回包含商品信息的Orders,失败则返回原参数
	 * @throws SQLException
	 */
	public Orders selectMerchandise(Orders o)throws SQLException;
	
	
	/**
	 * 用于返回某个特定的订单信息
	 * @param 整数o_id,订单信息的主键
	 * @return 成功则返回包含基本信息的订单Orders,失败则返回null
	 * @throws SQLException
	 */
	public Orders selectOrdersById(int o_id)throws SQLException;
	
	
	/**
	 * 用于获取某些买家特定状态的订单信息
	 * @param 字符串b_act,买家账号的用户名
	 * @param 整数o_status,订单的状态
	 * @return 成功则返回选择后包含订单基本信息的Orders的数组,失败则返回一个空数组
	 * @throws SQLException
	 */
	public ArrayList<Orders> selectByBuyerStatus(String b_act,int o_status)throws SQLException;
	
	
	/**
	 * 用于获取
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Orders> selectOrders()throws SQLException;
	
	
	/**
	 * 用于获取所有的订单信息
	 * @return 成功则返回包含订单基本信息的Orders的数组,失败则返回一个空数组
	 * @throws SQLException
	 */
	public ArrayList<Orders> selectAllOrders()throws SQLException;
	
	
	/**
	 * 用于获取某个用户的所有订单
	 * @param 字符串b_act,特定用户账号的用户名
	 * @return 成功则返回选择后包含订单基本信息的Orders的数组,失败则返回一个空数组
	 * @throws SQLException
	 */
	public ArrayList<Orders> selectByAct(String b_act)throws SQLException;
	
	
	
	
}
