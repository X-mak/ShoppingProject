package com.util.authentication;

import com.dao.users.SellerDao;
import com.dao.users.SellerDaoImpl;
import com.dao.users.UserDao;
import com.dao.users.UserDaoImpl;
import com.vo.SellerInfo;
import com.vo.UserAccount;
import com.vo.UserGroup;

public class SellerAuthentic implements SellerAuthenticUtil {

	
	public SellerInfo addSeller(UserAccount ua,SellerInfo si) {
		SellerInfo new_si = null;
		UserDao ud = new UserDaoImpl();
		SellerDao sd = new SellerDaoImpl();
		try {
			ud.insertAccount(ua);
			UserGroup ug = new UserGroup(ua.getU_act(), "seller");
			ud.insertGroup(ug);
			ua.setUserGroup(ug);
			sd.insertInfo(si);
			new_si = si;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new_si;
	}
	
}
