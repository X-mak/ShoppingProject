package com.dao.merchaninfo;

import java.sql.SQLException;

import com.vo.StockLog;

public interface StockLogD {

	
	public StockLog insertLog(StockLog sl)throws SQLException;
	
	
	public boolean deleteLog(int o_id)throws SQLException;
	
}
