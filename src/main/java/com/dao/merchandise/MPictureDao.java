package com.dao.merchandise;

import java.sql.SQLException;

import com.vo.MPicture;

/**
 * @author ������
 * ��ƷͼƬ��ص��������ݿ�ӿ�
 */
public interface MPictureDao {

	
	/**
	 * ���ڼ����µ���ƷͼƬ
	 * @param ��ƷͼƬMPicture,��Ҫ����p_ads,m_id
	 * @return �ɹ��򷵻ذ���������MPicture,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public MPicture insertPicture(MPicture p)throws SQLException;
	
	
}
