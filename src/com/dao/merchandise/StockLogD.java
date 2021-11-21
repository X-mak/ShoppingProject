package com.dao.merchandise;

import java.sql.SQLException;

import com.vo.Orders;
import com.vo.StockLog;

/**
 * @author 徐敏阳
 * 库存管理相关的连接数据库接口
 */
public interface StockLogD {

	
	/**
	 * 用于加入一条新的库存日志
	 * @param 库存日志StockLog,需要包括m_id,sl_num,sl_date
	 * @return 成功则返回包含主键的StockLog,失败则返回原参数
	 * @throws SQLException
	 */
	public StockLog insertLog(StockLog sl)throws SQLException;
	
	
	/**
	 * 用于删除一条库存日志
	 * @param 订单信息Orders,需要包含o_id
	 * @return 删除是否成功
	 * @throws SQLException
	 */
	public boolean deleteLog(Orders o)throws SQLException;
	
	
	/**
	 * 用于更新库存日志状态
	 * @param 库存日志StockLog,需要包括sl_id,o_id
	 * @return 更新是否成功
	 * @throws SQLException
	 */
	public boolean updateLog(StockLog sl)throws SQLException;
	
}
