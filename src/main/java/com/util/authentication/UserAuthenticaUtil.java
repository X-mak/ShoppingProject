package com.util.authentication;

import com.vo.UserAccount;

public interface UserAuthenticaUtil {


	/**
	 * 用于修改用户账号的密码
	 * @param 用户账号UserAccount,需要包括u_act,u_pwd
	 * @param 字符串new_pwd,修改后的新密码
	 * @return 修改是否成功
	 */
	public boolean changePwd(UserAccount ba,String new_pwd);
	
	/**
	 * 用于检查当前的用户是否能够通过登录认证
	 * @param 用户账号UserAccount,需要包括u_act,u_pwd
	 * @return 如果是买家账号返回"buyer",如果是卖家账号返回"seller",如果都不是则返回空字符串
	 */
	public String checkLogin(UserAccount sa);
	
	
}
