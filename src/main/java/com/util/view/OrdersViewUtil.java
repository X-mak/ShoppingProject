package com.util.view;

import java.util.ArrayList;

import com.vo.Orders;

/**
 * @author ������
 * չʾ������Ϣ�Ľӿ�
 */
public interface OrdersViewUtil {

	
	/**
	 * ���ڻ��ĳ����ҵ����ж���
	 * @param �ַ���b_act,��ҵ��˺��û���
	 * @return �ɹ��򷵻ذ������û�ӵ�е�����Orders������,ʧ���򷵻ؿ�����
	 */
	public ArrayList<Orders> getBuyerOrders(String b_act);
	
	
	/**
	 * ���ڻ�����еĶ���
	 * @return �ɹ��򷵻ذ������е�Orders������,ʧ���򷵻ؿ�����
	 */
	public ArrayList<Orders> showAllOrders();
	
	
}
