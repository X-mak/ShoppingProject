package com.util.authentication;

import com.dao.buyer.BuyerD;
import com.dao.buyer.BuyerDI;
import com.dao.seller.SellerD;
import com.dao.seller.SellerDI;
import com.vo.BuyerAccount;
import com.vo.SellerAccount;

public class SellerAuthentic implements SellerAuthenticUtil {

	
	public String checkLogin(String act,String pwd) {
		SellerD sd = new SellerDI();
		BuyerD bd = new BuyerDI();
		String ans = "empty";
		try {				
			SellerAccount sa = new SellerAccount(act,pwd);
			BuyerAccount ba = new BuyerAccount(act, pwd);
			if(sd.selectAccount(sa))ans = "seller";
			else if(bd.selectAccount(ba))ans = "buyer";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ans;
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
