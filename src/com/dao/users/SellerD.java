package com.dao.users;

import java.sql.SQLException;

import com.vo.SellerAccount;
import com.vo.SellerInfo;

/**
 * @author 徐敏阳
 * 卖家相关的连接数据库接口
 */
public interface SellerD {

	/**
	 * 用于检查是否存在这样的卖家账号
	 * @param 卖家账号SellerAccount,需要包括s_act,s_pwd,s_status
	 * @return 是否存在卖家账号
	 * @throws SQLException
	 */
	public boolean selectAccount(SellerAccount sa)throws SQLException;
	
	
	/**
	 * 用于检查是否存在这样的卖家用户名
	 * @param 卖家账号SellerAccount,需要包括s_act
	 * @return 是否存在这样的卖家用户名
	 * @throws SQLException
	 */
	public boolean selectAct(SellerAccount sa)throws SQLException;
	
	
	/**
	 * 用于修改卖家账号的密码
	 * @param 卖家账号SellerAccount,需要包括s_act
	 * @param 字符串pwd,修改后的新密码
	 * @return 修改是否成功
	 * @throws SQLException
	 */
	public boolean updatePwd(SellerAccount sa,String pwd)throws SQLException;
	
	
	/**
	 * 用于加入一个新的卖家用户账号
	 * @param 卖家账号SellerAccount,需要包括s_act,s_pwd
	 * @return 添加是否成功
	 * @throws SQLException
	 */
	public boolean insertAccount(SellerAccount sa)throws SQLException;
	
	
	/**
	 * 用于加入一个新的卖家用户信息
	 * @param 卖家信息SellerInfo,需要包括s_act,a_act
	 * @return 添加是否成功
	 * @throws SQLException
	 */
	public boolean insertInfo(SellerInfo si)throws SQLException;
	
	
}
