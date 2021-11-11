package com.dao.seller;

import java.sql.SQLException;

import com.vo.SellerAccount;
import com.vo.SellerInfo;

public interface SellerD {

	public boolean selectAccount(SellerAccount sa)throws SQLException;
	
	
	public boolean selectAct(SellerAccount sa)throws SQLException;
	
	
	public boolean updatePwd(SellerAccount sa,String pwd)throws SQLException;
	
	
	public boolean insertAccount(SellerAccount sa)throws SQLException;
	
	
	public boolean insertInfo(SellerInfo si)throws SQLException;
	
	
	public SellerAccount test()throws SQLException;
	
}
