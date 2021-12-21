package com.dao.users;

import java.sql.SQLException;

import com.vo.SellerInfo;

/**
 * @author 徐敏阳
 * 卖家相关的连接数据库接口
 */
public interface SellerDao {	
	
	/**
	 * 用于加入一个新的卖家用户信息
	 * @param 卖家信息SellerInfo,需要包括u_act,s_status
	 * @return 添加是否成功
	 * @throws SQLException
	 */
	public boolean insertInfo(SellerInfo si)throws SQLException;
	
	
}
