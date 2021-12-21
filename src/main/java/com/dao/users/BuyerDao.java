package com.dao.users;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.BuyerAddress;
import com.vo.BuyerInfo;

/**
 * @author ������
 * �������������ݿ�ӿ�
 */
public interface BuyerDao {
		
	
	/**
	 * ����ȡ��ĳ����ҵ����е�ַ��Ϣ
	 * @param �����ϢBuyerInfo,��Ҫ����u_act
	 * @return �ɹ��򷵻صõ�������е�ַ��Ϣ��BuyerInfo,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public BuyerInfo selectAddress(BuyerInfo bi)throws SQLException;
	
	
	/**
	 * ���ڼ����µ���Ҹ�����Ϣ
	 * @param �����ϢBuyerInfo,��Ҫ����u_act,b_tele
	 * @return �����Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean insertInfo(BuyerInfo bi)throws SQLException;
	
	
	/**
	 * ���ڼ����µ���ҵ�ַ��Ϣ
	 * @param ��ҵ�ַBuyerAddress,��Ҫ����u_act,b_ads
	 * @return �ɹ��򷵻ذ���������BuyerAddress,ʧ���򷵻�ԭ����
	 * @throws SQLException
	 */
	public BuyerAddress insertAddress(BuyerAddress ba)throws SQLException; 
	
	
	/**
	 * ���ڻ�����е���Ҹ�����Ϣ
	 * @return �ɹ��򷵻ذ�����Ҹ�����ϢBuyerInfo������,ʧ���򷵻�һ��������
	 * @throws SQLException
	 */
	public ArrayList<BuyerInfo> selectAllInfo()throws SQLException;
	
	
	/**
	 * ���ڸ������Ҹ�����Ϣ������
	 * @param ��Ҹ�����ϢBuyerInfo,��Ҫ����u_act,b_tele
	 * @return �����Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean updateInfo(BuyerInfo bi)throws SQLException;
	
	
	/**
	 * ���ڸ�����ҵĵ�ַ��Ϣ
	 * @param ��ҵ�ַ��ϢBuyerAddress,��Ҫ����u_act,b_ads
	 * @return �����Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean updateAddress(BuyerAddress ba)throws SQLException;
	
}
