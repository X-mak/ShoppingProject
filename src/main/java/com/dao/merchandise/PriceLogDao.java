package com.dao.merchandise;

import java.sql.SQLException;

import com.vo.PriceLog;

/**
 * @author ������
 * �۸������ص��������ݿ�ӿ�
 */
public interface PriceLogDao {

	
	/**
	 * ���ڼ���һ���µļ۸���־
	 * @param �۸���־PriceLog,��Ҫ����m_id,pl_price,pl_date
	 * @return �ɹ��򷵻ذ���������PriceLog,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public PriceLog insertLog(PriceLog pl)throws SQLException;
	
	
}
