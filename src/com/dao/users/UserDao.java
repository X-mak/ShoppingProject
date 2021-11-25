package com.dao.users;

import java.sql.SQLException;

import com.vo.UserAccount;
import com.vo.UserGroup;

/**
 * @author 徐敏阳
 * 
 * 用户账号相关连接数据库接口
 */
public interface UserDao {

	/**
	 * 用于检查账号是否存在
	 * @param 账号UserAccount,需要包括u_act,u_pwd.
	 * @return 数据库中是否存在这个账号.
	 * @throws SQLException
	 */
	public boolean selectAccount(UserAccount aa)throws SQLException;
	
	
	/**
	 * 用于修改账号的密码
	 * @param 账号UserAccount,需要包括u_act.
	 * @param 修改后的新密码.
	 * @return 此次修改是否成功.
	 * @throws SQLException
	 */
	public boolean updatePwd(UserAccount aa,String pwd)throws SQLException;
	
	
	/**
	 * 用于新增用户账号
	 * @param 账号UserAccount,需要包括u_act,u_pwd
	 * @return 新增是否成功
	 * @throws SQLException
	 */
	public boolean insertAccount(UserAccount aa)throws SQLException;
	
	
	/**
	 * 用于给用户分组
	 * @param 用户组UserGroup,需要包括u_act,u_role
	 * @return 新增是否成功
	 * @throws SQLException
	 */
	public boolean insertGroup(UserGroup up)throws SQLException;
	
	
	/**
	 * 用于检查账号用户名是否合法
	 * @param 账号UserAccount,需要包括u_act
	 * @return 用户名是否合法
	 * @throws SQLException
	 */
	public boolean isValid(UserAccount aa)throws SQLException;
	
	
	/**
	 * 用于获取该用户的用户组
	 * @param 账号UserAccount,需要包括u_act
	 * @return 成功则返回该用户所属的用户组,失败则返回null
	 * @throws SQLException
	 */
	public UserGroup selectGroup(UserAccount aa)throws SQLException;
	
}
