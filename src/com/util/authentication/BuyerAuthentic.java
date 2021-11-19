package com.util.authentication;

import java.util.ArrayList;

import com.dao.users.BuyerD;
import com.dao.users.BuyerDI;
import com.dao.users.SellerD;
import com.dao.users.SellerDI;
import com.vo.BuyerAccount;
import com.vo.BuyerAddress;
import com.vo.BuyerInfo;
import com.vo.SellerAccount;

public class BuyerAuthentic implements BuyerAuthenticUtil {

	public boolean changePwd(BuyerAccount ba,String new_pwd) {
		boolean flag = false;
		BuyerD bd = new BuyerDI();
		try {
			if(bd.selectAccount(ba)) {
				flag = true;
				bd.updatePwd(ba, new_pwd);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public BuyerInfo changeInfo(BuyerInfo bi, BuyerAddress ba) {
		BuyerInfo res = null;
		BuyerD bd = new BuyerDI();
		try {
			res = bi;
			bd.updateInfo(bi);
			bd.updateAddress(ba);
			res = bd.selectAddress(bi);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	
	public BuyerInfo addBuyer(BuyerAccount ba,BuyerInfo bi, BuyerAddress bad) {
		BuyerInfo res = null;
		BuyerD bd = new BuyerDI();
		SellerD sd = new SellerDI();
		try {
			ArrayList<BuyerAddress> aba = new ArrayList<BuyerAddress>();
			SellerAccount sa = new SellerAccount(ba.getB_act(),ba.getB_pwd());
			if(!bd.selectAct(ba) && !sd.selectAct(sa)) {
				bd.insertAccount(ba);              //顺序和下一行反了
				bd.insertInfo(bi);
				aba.add(bd.insertAddress(bad));
				bi.setBuyerAccount(ba);
				bi.setBuyerAddress(aba);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	
}
