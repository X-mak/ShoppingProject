package com.util.authentication;

import com.vo.SellerAccount;

/**
 * @author 徐敏阳
 * 卖家认证功能的接口
 */
public interface SellerAuthenticUtil {

	
	/**
	 * 用于检查当前的用户是否能够通过登录认证
	 * @param 卖家账号SellerAccount,需要包括s_act,s_pwd
	 * @return 如果是买家账号返回"buyer",如果是卖家账号返回"seller",如果都不是则返回null
	 */
	public String checkLogin(SellerAccount sa);
	
	
	/**
	 * 用于修改卖家账号的密码
	 * @param 卖家账号SellerAccount,需要包括s_act,s_pwd
	 * @param 字符串new_pwd,修改后的新密码
	 * @return 修改是否成功
	 */
	public boolean changePwd(SellerAccount sa,String new_pwd);
	
}
