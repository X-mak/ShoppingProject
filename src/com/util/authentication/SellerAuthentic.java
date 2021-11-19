package com.util.authentication;

import com.dao.users.BuyerD;
import com.dao.users.BuyerDI;
import com.dao.users.SellerD;
import com.dao.users.SellerDI;
import com.vo.BuyerAccount;
import com.vo.SellerAccount;

public class SellerAuthentic implements SellerAuthenticUtil {

	
	public String checkLogin(SellerAccount sa) {
		SellerD sd = new SellerDI();
		BuyerD bd = new BuyerDI();
		String ans = null;
		try {				
			BuyerAccount ba = new BuyerAccount(sa.getS_act(),sa.getS_pwd());
			if(sd.selectAccount(sa))ans = "seller";
			else if(bd.selectAccount(ba))ans = "buyer";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ans;
	}
	
	
	public boolean changePwd(SellerAccount sa,String new_pwd) {
		boolean flag = false;
		SellerD sd = new SellerDI();
		try {
			if(sd.selectAccount(sa)) {
				flag = true;
				sd.updatePwd(sa, new_pwd);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
