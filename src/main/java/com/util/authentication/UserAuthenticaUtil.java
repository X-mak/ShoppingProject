package com.util.authentication;

import com.vo.UserAccount;

public interface UserAuthenticaUtil {


	/**
	 * �����޸��û��˺ŵ�����
	 * @param �û��˺�UserAccount,��Ҫ����u_act,u_pwd
	 * @param �ַ���new_pwd,�޸ĺ��������
	 * @return �޸��Ƿ�ɹ�
	 */
	public boolean changePwd(UserAccount ba,String new_pwd);
	
	/**
	 * ���ڼ�鵱ǰ���û��Ƿ��ܹ�ͨ����¼��֤
	 * @param �û��˺�UserAccount,��Ҫ����u_act,u_pwd
	 * @return ���������˺ŷ���"buyer",����������˺ŷ���"seller",����������򷵻ؿ��ַ���
	 */
	public String checkLogin(UserAccount sa);
	
	
}
