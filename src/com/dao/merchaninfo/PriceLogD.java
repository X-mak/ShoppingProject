package com.dao.merchaninfo;

import java.sql.SQLException;

import com.vo.PriceLog;

public interface PriceLogD {

	
	public PriceLog insertLog(PriceLog pl)throws SQLException;
	
	
}
