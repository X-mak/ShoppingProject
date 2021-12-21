package com.util.authentication;

import com.dao.users.UserDao;
import com.dao.users.UserDaoImpl;
import com.vo.UserAccount;
import com.vo.UserGroup;

public class UserAuthentic implements UserAuthenticaUtil{

	
	public boolean changePwd(UserAccount ba,String new_pwd) {
		boolean flag = false;
		UserDao ud = new UserDaoImpl();
		try {
			if(ud.updatePwd(ba, new_pwd))
				flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public String checkLogin(UserAccount sa) {
		String res = "";
		UserDao ud = new UserDaoImpl();
		try {
			if(ud.selectAccount(sa)) {
				UserGroup ug = ud.selectGroup(sa);
				return ug.getU_role();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
