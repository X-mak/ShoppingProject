package com.util.authentication;

import com.vo.SellerInfo;
import com.vo.UserAccount;

public interface SellerAuthenticUtil {

	
	/**
	 * 用于新增一个卖家账号
	 * @param 用户账号UserAccount,需要包括u_act,u_pwd
	 * @param 卖家信息SellerInfo,需要包括u_act,s_status
	 * @return 成功则返回新增的卖家信息SellerInfo,失败则返回null
	 */
	public SellerInfo addSeller(UserAccount ua,SellerInfo si);
	
}
