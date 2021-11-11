package com.dao.buyer;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.BuyerAccount;
import com.vo.BuyerAddress;
import com.vo.BuyerInfo;

public interface BuyerD {

	public boolean selectAccount(BuyerAccount ba)throws SQLException;
	
	
	public boolean selectAct(BuyerAccount ba)throws SQLException;
	
	
	public boolean updatePwd(BuyerAccount ba,String pwd)throws SQLException;
	
	
	public BuyerInfo selectAddress(BuyerInfo bi)throws SQLException;
	
	
	public boolean insertAccount(BuyerAccount ba)throws SQLException;
	
	
	public boolean insertInfo(BuyerInfo bi)throws SQLException;
	
	
	public BuyerAddress insertAddress(BuyerAddress ba)throws SQLException; 
	
	
	public ArrayList<BuyerInfo> selectAllInfo()throws SQLException;
	
	
	public boolean updateInfo(BuyerInfo bi)throws SQLException;
	
	
	public boolean updateAddress(BuyerAddress ba)throws SQLException;
	
}
