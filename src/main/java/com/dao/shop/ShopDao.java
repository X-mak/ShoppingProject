package com.dao.shop;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.SellerInfo;
import com.vo.Shop;

/**
 * @author ������
 *
 * ������ص��������ݿ�Ľӿ�
 */
public interface ShopDao {

	
	/**
	 * ���ڻ�ȡĳ�����ҵ����е���
	 * @param ������ϢSellerInfo,��Ҫ����u_act
	 * @return �ɹ��򷵻ذ���ĳ���������е���Shop������,ʧ���򷵻�һ��������
	 * @throws SQLException
	 */
	public ArrayList<Shop> selectShops(SellerInfo si)throws SQLException;
	
}
