package com.util.authentication;

import com.dao.seller.SellerD;
import com.dao.seller.SellerDI;
import com.vo.SellerAccount;

public class SellerAuthentic implements SellerAuthenticUtil {

	
	public boolean checkLogin(String act,String pwd) {
		SellerD sd = new SellerDI();
		boolean flag = false;
		try {				
			SellerAccount sa = new SellerAccount(act,pwd);
			flag = sd.selectAccount(sa);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public boolean changePwd(String act,String old_pwd,String new_pwd) {
		boolean flag = false;
		SellerD sd = new SellerDI();
		try {
			SellerAccount s = new SellerAccount(act,old_pwd);
			if(sd.selectAccount(s)) {
				flag = true;
				sd.updatePwd(s, new_pwd);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
