package com.dao.merchandise;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.Merchandise;

/**
 * @author ������
 * ��Ʒ��ص��������ݿ�ӿ�
 */
public interface MerchandiseDao {

	
	/**
	 * ���ڼ���һ������Ʒ
	 * @param ��ƷMerchandise,��Ҫ����m_id������Ԫ��
	 * @return �ɹ��򷵻ذ���������Merchandise,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public Merchandise insertMerchan(Merchandise m)throws SQLException;
	
	
	/**
	 * ���ڻ�ȡ��Ʒ������ͼƬ��Ϣ
	 * @param ��ƷMerchandise,��Ҫ����m_id
	 * @return �ɹ��򷵻ذ�������ͼƬ��Ϣ��Merchandise,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public Merchandise selectMPicture(Merchandise m)throws SQLException;
	
	
	/**
	 * ���ڻ�ȡ��Ʒ�����м۸���־
	 * @param ��ƷMerchandise,��Ҫ����m_id
	 * @return �ɹ��򷵻ذ������м۸���־��Merchandise,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public Merchandise selectPriceLog(Merchandise m)throws SQLException;
	
	
	/**
	 * ���ڻ�ȡ��Ʒ�����п����־
	 * @param ��ƷMerchandise,��Ҫ����m_id
	 * @return �ɹ��򷵻ذ������п����־��Merchandise,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public Merchandise selectStockLog(Merchandise m)throws SQLException;
	
	
	/**
	 * ���ڻ�ȡ��Ʒ�������Ϣ
	 * @param ��ƷMerchandise,��Ҫ����m_id
	 * @return �ɹ��򷵻ذ��������Ϣ��Merchandise,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public Merchandise selectMGenre(Merchandise m)throws SQLException;
	
	
	/**
	 * ���ڻ�ȡ��Ʒ�Ļ�����Ϣ
	 * @param ��ƷMerchandise,��Ҫ����m_id
	 * @return �ɹ��򷵻ذ���������Ϣ��Merchandise,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public Merchandise selectMerchan(Merchandise m)throws SQLException;
	
	
	/**
	 * ���ڻ�����������е���Ʒ
	 * @return �ɹ��򷵻����������е�Merchandise������,ʧ���򷵻ؿ�����
	 * @throws SQLException
	 */
	public ArrayList<Merchandise> selectAllMerchanStatus()throws SQLException;
	
	
	/**
	 * ���ڻ��������Ʒ
	 * @return �ɹ��򷵻�����Merchandise������,ʧ���򷵻ؿ�����
	 * @throws SQLException
	 */
	public ArrayList<Merchandise> selectAllMerchan()throws SQLException;
	
	
	/**
	 * ���ڻ��������ص���Ʒ
	 * @param �ַ���words,�����Ĺؼ���
	 * @return �ɹ��򷵻����������õ���Merchandise������,ʧ���򷵻ؿ�����
	 * @throws SQLException
	 */
	public ArrayList<Merchandise> selectMerchanLike(String words)throws SQLException;
	
	
	/**
	 * ���ڸ�����Ʒ���ϼ�״̬
	 * @param ��ƷMerchandise,��Ҫ����m_id
	 * @param ����status,��Ʒ��״̬,1Ϊ������,0Ϊ�¼���
	 * @return �����Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean updateStatus(Merchandise m,int status)throws SQLException;
	
}
