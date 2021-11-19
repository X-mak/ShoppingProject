package com.dao.users;

import java.sql.SQLException;

import com.vo.AdminAccount;

/**
 * @author 徐敏阳
 * 管理员相关连接数据库接口
 */
public interface AdminD {

	/**
	 * 用于检查管理员账号是否存在
	 * @param 管理员账号AdminAccount,需要包括a_act,a_pwd.
	 * @return 数据库中是否存在这个管理员账号.
	 * @throws SQLException
	 */
	public boolean selectAccount(AdminAccount aa)throws SQLException;
	
	
	/**
	 * 用于修改管理员账号的密码
	 * @param 管理账号AdminAccount,需要包括a_act.
	 * @param 修改后的新密码.
	 * @return 此次修改是否成功.
	 * @throws SQLException
	 */
	public boolean updatePwd(AdminAccount aa,String pwd)throws SQLException;
	
}
