package com.dao.admin;

import java.sql.SQLException;

import com.vo.AdminAccount;

public interface AdminD {

	public boolean selectAccount(AdminAccount aa)throws SQLException;
	
	
	public boolean updatePwd(AdminAccount aa,String pwd)throws SQLException;
	
}
