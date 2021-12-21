package com.dao.orders;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.Orders;

/**
 * @author ������
 * ������ص��������ݿ�ӿ�
 */
public interface OrdersDao {

	/**
	 * ���ڼ���һ���µĶ�����Ϣ
	 * @param ������ϢOrders,��Ҫ����o_id������Ԫ��
	 * @return �ɹ��򷵻ذ���������Orders,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public Orders insertOrders(Orders o)throws SQLException;
	
	
	/**
	 * ���ڸ��¶�����״̬
	 * @param ������ϢOrders,��Ҫ����o_id
	 * @param ����o_status,Ϊ���º�Ķ���״̬
	 * @return �����Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean updateStatus(Orders o,int o_status)throws SQLException;
	
	
	/**
	 * ����ɾ��������Ϣ
	 * @param ������ϢOrders,��Ҫ����o_id
	 * @return ɾ���Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean deleteOrders(Orders o)throws SQLException;
	
	
	/**
	 * ���ڻ�ȡ�����������Ϣ
	 * @param ������ϢOrders,��Ҫ����u_act
	 * @return �ɹ��򷵻ذ��������Ϣ��Orders,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public Orders selectBuyerInfo(Orders o)throws SQLException;
	
	
	/**
	 * ���ڻ�ȡ��������Ʒ��Ϣ
	 * @param ������ϢOrders,��Ҫ����m_id
	 * @return �ɹ��򷵻ذ�����Ʒ��Ϣ��Orders,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public Orders selectMerchandise(Orders o)throws SQLException;
	
	
	/**
	 * ���ڷ���ĳ���ض��Ķ�����Ϣ
	 * @param ����o_id,������Ϣ������
	 * @return �ɹ��򷵻ذ���������Ϣ�Ķ���Orders,ʧ���򷵻�null
	 * @throws SQLException
	 */
	public Orders selectOrdersById(int o_id)throws SQLException;
	
	
	/**
	 * ���ڻ�ȡĳЩ����ض�״̬�Ķ�����Ϣ
	 * @param �ַ���u_act,����˺ŵ��û���
	 * @param ����o_status,������״̬
	 * @return �ɹ��򷵻�ѡ����������������Ϣ��Orders������,ʧ���򷵻�һ��������
	 * @throws SQLException
	 */
	public ArrayList<Orders> selectByBuyerStatus(String b_act,int o_status)throws SQLException;
	
	
	/**
	 * ���ڻ�ȡ
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Orders> selectOrders()throws SQLException;
	
	
	/**
	 * ���ڻ�ȡ���еĶ�����Ϣ
	 * @return �ɹ��򷵻ذ�������������Ϣ��Orders������,ʧ���򷵻�һ��������
	 * @throws SQLException
	 */
	public ArrayList<Orders> selectAllOrders()throws SQLException;
	
	
	/**
	 * ���ڻ�ȡĳ���û������ж���
	 * @param �ַ���u_act,�ض��û��˺ŵ��û���
	 * @return �ɹ��򷵻�ѡ����������������Ϣ��Orders������,ʧ���򷵻�һ��������
	 * @throws SQLException
	 */
	public ArrayList<Orders> selectByAct(String b_act)throws SQLException;
	
	
	
	
}
