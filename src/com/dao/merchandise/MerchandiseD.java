package com.dao.merchandise;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.Merchandise;

public interface MerchandiseD {

	
	public Merchandise insertMerchan(Merchandise m)throws SQLException;
	
	
	public Merchandise selectMPicture(Merchandise m)throws SQLException;
	
	
	public Merchandise selectPriceLog(Merchandise m)throws SQLException;
	
	
	public Merchandise selectStockLog(Merchandise m)throws SQLException;
	
	
	public Merchandise selectMGenre(Merchandise m)throws SQLException;
	

	public Merchandise selectMerchan(int m_id)throws SQLException;
	
	
	public ArrayList<Merchandise> selectAllMerchanStatus()throws SQLException;
	
	
	public ArrayList<Merchandise> selectAllMerchan()throws SQLException;
	
	
	public boolean updateStatus(Merchandise m,int status)throws SQLException;
}
