package com.util.authentication;

import com.vo.SellerInfo;
import com.vo.UserAccount;

public interface SellerAuthenticUtil {

	
	/**
	 * ��������һ�������˺�
	 * @param �û��˺�UserAccount,��Ҫ����u_act,u_pwd
	 * @param ������ϢSellerInfo,��Ҫ����u_act,s_status
	 * @return �ɹ��򷵻�������������ϢSellerInfo,ʧ���򷵻�null
	 */
	public SellerInfo addSeller(UserAccount ua,SellerInfo si);
	
}
