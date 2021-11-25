package com.dao.users;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.BuyerAddress;
import com.vo.BuyerInfo;

/**
 * @author 徐敏阳
 * 买家相关连接数据库接口
 */
public interface BuyerDao {
		
	
	/**
	 * 用于取出某个买家的所有地址信息
	 * @param 买家信息BuyerInfo,需要包括u_act
	 * @return 成功则返回得到买家所有地址信息的BuyerInfo,失败则返回原参数
	 * @throws SQLException
	 */
	public BuyerInfo selectAddress(BuyerInfo bi)throws SQLException;
	
	
	/**
	 * 用于加入新的买家个人信息
	 * @param 买家信息BuyerInfo,需要包括u_act,b_tele
	 * @return 加入是否成功
	 * @throws SQLException
	 */
	public boolean insertInfo(BuyerInfo bi)throws SQLException;
	
	
	/**
	 * 用于加入新的买家地址信息
	 * @param 买家地址BuyerAddress,需要包括u_act,b_ads
	 * @return 成功则返回包含主键的BuyerAddress,失败则返回原参数
	 * @throws SQLException
	 */
	public BuyerAddress insertAddress(BuyerAddress ba)throws SQLException; 
	
	
	/**
	 * 用于获得所有的买家个人信息
	 * @return 成功则返回包含买家个人信息BuyerInfo的数组,失败则返回一个空数组
	 * @throws SQLException
	 */
	public ArrayList<BuyerInfo> selectAllInfo()throws SQLException;
	
	
	/**
	 * 用于更新卖家个人信息的数据
	 * @param 买家个人信息BuyerInfo,需要包括u_act,b_tele
	 * @return 更新是否成功
	 * @throws SQLException
	 */
	public boolean updateInfo(BuyerInfo bi)throws SQLException;
	
	
	/**
	 * 用于更新买家的地址信息
	 * @param 买家地址信息BuyerAddress,需要包括u_act,b_ads
	 * @return 更新是否成功
	 * @throws SQLException
	 */
	public boolean updateAddress(BuyerAddress ba)throws SQLException;
	
}
