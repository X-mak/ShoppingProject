package com.dao.users;

import java.sql.SQLException;

import com.vo.SellerInfo;

/**
 * @author ������
 * ������ص��������ݿ�ӿ�
 */
public interface SellerDao {	
	
	/**
	 * ���ڼ���һ���µ������û���Ϣ
	 * @param ������ϢSellerInfo,��Ҫ����u_act,s_status
	 * @return ����Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean insertInfo(SellerInfo si)throws SQLException;
	
	
}
