package com.dao.users;

import java.sql.SQLException;

import com.vo.UserAccount;
import com.vo.UserGroup;

/**
 * @author ������
 * 
 * �û��˺�����������ݿ�ӿ�
 */
public interface UserDao {

	/**
	 * ���ڼ���˺��Ƿ����
	 * @param �˺�UserAccount,��Ҫ����u_act,u_pwd.
	 * @return ���ݿ����Ƿ��������˺�.
	 * @throws SQLException
	 */
	public boolean selectAccount(UserAccount aa)throws SQLException;
	
	
	/**
	 * �����޸��˺ŵ�����
	 * @param �˺�UserAccount,��Ҫ����u_act.
	 * @param �޸ĺ��������.
	 * @return �˴��޸��Ƿ�ɹ�.
	 * @throws SQLException
	 */
	public boolean updatePwd(UserAccount aa,String pwd)throws SQLException;
	
	
	/**
	 * ���������û��˺�
	 * @param �˺�UserAccount,��Ҫ����u_act,u_pwd
	 * @return �����Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean insertAccount(UserAccount aa)throws SQLException;
	
	
	/**
	 * ���ڸ��û�����
	 * @param �û���UserGroup,��Ҫ����u_act,u_role
	 * @return �����Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean insertGroup(UserGroup up)throws SQLException;
	
	
	/**
	 * ���ڼ���˺��û����Ƿ�Ϸ�
	 * @param �˺�UserAccount,��Ҫ����u_act
	 * @return �û����Ƿ�Ϸ�
	 * @throws SQLException
	 */
	public boolean isValid(UserAccount aa)throws SQLException;
	
	
	/**
	 * ���ڻ�ȡ���û����û���
	 * @param �˺�UserAccount,��Ҫ����u_act
	 * @return �ɹ��򷵻ظ��û��������û���,ʧ���򷵻�null
	 * @throws SQLException
	 */
	public UserGroup selectGroup(UserAccount aa)throws SQLException;
	
}
