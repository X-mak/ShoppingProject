package com.util.authentication;

import com.vo.BuyerAddress;
import com.vo.BuyerInfo;
import com.vo.UserAccount;

/**
 * @author 徐敏阳
 * 买家认证功能的接口
 */
public interface BuyerAuthenticUtil {
	
	/**
	 * 用于修改买家的个人信息和地址信息
	 * @param 买家信息BuyerInfo,需要包括u_act,b_tele
	 * @param 买家地址信息BuyerAddress,需要包括u_act,b_ads
	 * @return 成功则返回修改后的BuyerInfo,失败则返回null
	 */
	public BuyerInfo changeInfo(BuyerInfo bi, BuyerAddress ba); 
	
	
	/**
	 * 用于新增买家账号
	 * @param 买家账号BuyerAccount,需要包括u_act,b_pwd
	 * @param 买家信息BuyerInfo,需要包括u_act,b_tele
	 * @param 卖家地址信息BuyerAddress,需要包括b_act,b_ads
	 * @return 成功则返回新增的买家账号BuyerInfo,失败则返回null
	 */
	public BuyerInfo addBuyer(UserAccount ua,BuyerInfo bi, BuyerAddress bad);
	
}
