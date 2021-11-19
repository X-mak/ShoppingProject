package com.dao.merchandise;

import java.sql.SQLException;

import com.vo.PriceLog;

/**
 * @author 徐敏阳
 * 价格管理相关的连接数据库接口
 */
public interface PriceLogD {

	
	/**
	 * 用于加入一条新的价格日志
	 * @param 价格日志PriceLog,需要包括m_id,pl_price,pl_date
	 * @return 成功则返回包含主键的PriceLog,失败则返回原参数
	 * @throws SQLException
	 */
	public PriceLog insertLog(PriceLog pl)throws SQLException;
	
	
}
