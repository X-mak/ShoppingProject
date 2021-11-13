package com.util.authentication;

import java.util.ArrayList;

import com.dao.buyer.BuyerD;
import com.dao.buyer.BuyerDI;

import com.vo.BuyerAccount;
import com.vo.BuyerAddress;
import com.vo.BuyerInfo;

public class BuyerAuthentic implements BuyerAuthenticUtil {

	public boolean changePwd(String b_act,String old_pwd,String new_pwd) {
		boolean flag = false;
		BuyerD bd = new BuyerDI();
		try {
			BuyerAccount ba = new BuyerAccount(b_act,old_pwd);
			if(bd.selectAccount(ba)) {
				flag = true;
				bd.updatePwd(ba, new_pwd);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public BuyerInfo changeInfo(String b_act,int b_tele,String b_ads) {
		BuyerInfo bi = null;
		BuyerD bd = new BuyerDI();
		try {
			bi = new BuyerInfo(b_act,b_tele);
			bd.updateInfo(bi);
			bi = bd.selectAddress(bi);
			bd.updateAddress(bi.getBuyerAddress().get(0));
			bi = bd.selectAddress(bi);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bi;
	}
	
	
	
	public BuyerInfo addBuyer(String act,String pwd,String ads,int tele) {
		BuyerInfo bi = null;
		BuyerD bd = new BuyerDI();
		try {
			ArrayList<BuyerAddress> aba = new ArrayList<BuyerAddress>();
			BuyerAccount ba = new BuyerAccount(act,pwd);
			if(!bd.selectAct(ba)) {
				bi = new BuyerInfo(act,tele);
				BuyerAddress bad = new BuyerAddress(act,ads);
				bd.insertAccount(ba);              //顺序和下一行反了
				bd.insertInfo(bi);
				aba.add(bd.insertAddress(bad));
				bi.setBuyerAccount(ba);
				bi.setBuyerAddress(aba);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bi;
	}
	
	
	
	public boolean checkLogin(String act,String pwd) {
		BuyerD bd = new BuyerDI();
		boolean flag = false;
		try {
			BuyerAccount ba = new BuyerAccount(act,pwd);
			flag = bd.selectAccount(ba);					
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
