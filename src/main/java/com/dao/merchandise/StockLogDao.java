package com.dao.merchandise;

import java.sql.SQLException;

import com.vo.Orders;
import com.vo.StockLog;

/**
 * @author ������
 * ��������ص��������ݿ�ӿ�
 */
public interface StockLogDao {

	
	/**
	 * ���ڼ���һ���µĿ����־
	 * @param �����־StockLog,��Ҫ����m_id,sl_num,sl_date
	 * @return �ɹ��򷵻ذ���������StockLog,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public StockLog insertLog(StockLog sl)throws SQLException;
	
	
	/**
	 * ����ɾ��һ�������־
	 * @param ������ϢOrders,��Ҫ����o_id
	 * @return ɾ���Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean deleteLog(Orders o)throws SQLException;
	
	
	/**
	 * ���ڸ��¿����־״̬
	 * @param �����־StockLog,��Ҫ����sl_id,o_id
	 * @return �����Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean updateLog(StockLog sl)throws SQLException;
	
}
