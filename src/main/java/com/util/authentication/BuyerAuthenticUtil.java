package com.util.authentication;

import com.vo.BuyerAddress;
import com.vo.BuyerInfo;
import com.vo.UserAccount;

/**
 * @author ������
 * �����֤���ܵĽӿ�
 */
public interface BuyerAuthenticUtil {
	
	/**
	 * �����޸���ҵĸ�����Ϣ�͵�ַ��Ϣ
	 * @param �����ϢBuyerInfo,��Ҫ����u_act,b_tele
	 * @param ��ҵ�ַ��ϢBuyerAddress,��Ҫ����u_act,b_ads
	 * @return �ɹ��򷵻��޸ĺ��BuyerInfo,ʧ���򷵻�null
	 */
	public BuyerInfo changeInfo(BuyerInfo bi, BuyerAddress ba); 
	
	
	/**
	 * ������������˺�
	 * @param ����˺�BuyerAccount,��Ҫ����u_act,b_pwd
	 * @param �����ϢBuyerInfo,��Ҫ����u_act,b_tele
	 * @param ���ҵ�ַ��ϢBuyerAddress,��Ҫ����b_act,b_ads
	 * @return �ɹ��򷵻�����������˺�BuyerInfo,ʧ���򷵻�null
	 */
	public BuyerInfo addBuyer(UserAccount ua,BuyerInfo bi, BuyerAddress bad);
	
}
