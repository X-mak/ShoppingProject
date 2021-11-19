package com.dao.users;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.BuyerAccount;
import com.vo.BuyerAddress;
import com.vo.BuyerInfo;

/**
 * @author 徐敏阳
 * 买家相关连接数据库接口
 */
public interface BuyerD {

	/**
	 * 用于检查买家账号是否存在
	 * @param 买家账号BuyerAccount,需要包括b_act,b_pwd
	 * @return 是否存在这个买家账号
	 * @throws SQLException
	 */
	public boolean selectAccount(BuyerAccount ba)throws SQLException;
	
	
	/**
	 * 用于检查这个用户名是否被注册
	 * @param 买家账号BuyerAccount,需要包括b_act
	 * @return 用户名是否被注册
	 * @throws SQLException
	 */
	public boolean selectAct(BuyerAccount ba)throws SQLException;
	
	
	/**
	 * 用于更新买家账号的密码信息
	 * @param 买家账号BuyerAccount,需要包括b_act
	 * @param 字符串pwd,新密码
	 * @return 修改是否成功
	 * @throws SQLException
	 */
	public boolean updatePwd(BuyerAccount ba,String pwd)throws SQLException;
	
	
	/**
	 * 用于取出某个买家的所有地址信息
	 * @param 买家信息BuyerInfo,需要包括b_act
	 * @return 成功则返回得到买家所有地址信息的BuyerInfo,失败则返回原参数
	 * @throws SQLException
	 */
	public BuyerInfo selectAddress(BuyerInfo bi)throws SQLException;
	
	
	/**
	 * 用于取出某个买家的账号信息
	 * @param 买家信息BuyerInfo,需要包括b_act
	 * @return 成功则返回得到买家帐号信息的BuyerInfo,失败则返回原参数
	 * @throws SQLException
	 */
	public BuyerInfo selectAccount(BuyerInfo bi)throws SQLException;
	
	
	/**
	 * 用于加入新的买家账号信息
	 * @param 买家账号BuyerAccount,需要包括b_act,b_pwd
	 * @return 加入是否成功
	 * @throws SQLException
	 */
	public boolean insertAccount(BuyerAccount ba)throws SQLException;
	
	
	/**
	 * 用于加入新的买家个人信息
	 * @param 买家信息BuyerInfo,需要包括b_act,b_tele
	 * @return 加入是否成功
	 * @throws SQLException
	 */
	public boolean insertInfo(BuyerInfo bi)throws SQLException;
	
	
	/**
	 * 用于加入新的买家地址信息
	 * @param 买家地址BuyerAddress,需要包括b_act,b_ads
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
	 * @param 买家个人信息BuyerInfo,需要包括b_act,b_tele
	 * @return 更新是否成功
	 * @throws SQLException
	 */
	public boolean updateInfo(BuyerInfo bi)throws SQLException;
	
	
	/**
	 * 用于更新买家的地址信息
	 * @param 买家地址信息BuyerAddress,需要包括b_act,b_ads
	 * @return 更新是否成功
	 * @throws SQLException
	 */
	public boolean updateAddress(BuyerAddress ba)throws SQLException;
	
}
