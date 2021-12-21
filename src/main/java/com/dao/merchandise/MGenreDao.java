package com.dao.merchandise;

import java.sql.SQLException;

import com.vo.MGenre;

/**
 * @author ������
 * ��Ʒ�����ص��������ݿ�ӿ�
 */
public interface MGenreDao {

	
	/**
	 * ���ڸ�����Ʒ�������Ϣ
	 * @param ��Ʒ�����ϢMGenre,��Ҫ����m_id,genre1,genre2
	 * @return �����Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean updateGenre(MGenre mg)throws SQLException;
	
	
	/**
	 * ���ڼ����µ������Ϣ
	 * @param ��Ʒ�����ϢMGenre,��Ҫ����m_id
	 * @return �ɹ��򷵻ز����MGenre,ʧ���򷵻�null
	 * @throws SQLException
	 */
	public MGenre insertGenre(MGenre mg)throws SQLException;
	
	
}
