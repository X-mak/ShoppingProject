package com.util.management;

import com.vo.Orders;

/**
 * @author ������
 * ��������Ľӿ�
 */
public interface OrdersManageUtil {

	
	/**
	 * ������������
	 * @param ����m_id,������Ʒ��id
	 * @param �ַ���b_act,��ҵ��˺��û���
	 * @param ����o_num,������Ʒ������
	 * @return �ɹ��򷵻ػ��������Ϣ��Orders,ʧ���򷵻�null
	 */
	public Orders havaOrder(int m_id,String b_act,int o_num);
	
	
	/**
	 * ����ȷ�϶���
	 * @param ����o_id,������id
	 * @return �����Ƿ�ɹ�
	 */
	public boolean sellerChooseBuyer(int o_id);
	
	
	/**
	 * ����������½���
	 * @param ����o_id,������id
	 * @return �����Ƿ�ɹ�
	 */
	public boolean finshDeal(int o_id);
	
	
	/**
	 * ����ɾ����������ʧ��
	 * @param ����o_id,������id
	 * @return ɾ���Ƿ�ɹ�
	 */
	public boolean deleteOrder(int o_id);
	
	
}
