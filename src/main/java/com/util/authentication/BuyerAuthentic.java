package com.util.authentication;

import java.util.ArrayList;

import com.dao.users.BuyerDao;
import com.dao.users.BuyerDaoImpl;
import com.dao.users.UserDao;
import com.dao.users.UserDaoImpl;
import com.vo.BuyerAddress;
import com.vo.BuyerInfo;
import com.vo.UserAccount;
import com.vo.UserGroup;

public class BuyerAuthentic implements BuyerAuthenticUtil {

	
	public BuyerInfo changeInfo(BuyerInfo bi, BuyerAddress ba) {
		BuyerInfo res = null;
		BuyerDao bd = new BuyerDaoImpl();
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
	
	
	
	public BuyerInfo addBuyer(UserAccount ua,BuyerInfo bi, BuyerAddress bad) {
		BuyerInfo res = null;
		BuyerDao bd = new BuyerDaoImpl();
		UserDao ud = new UserDaoImpl();
		try {
			ArrayList<BuyerAddress> aba = new ArrayList<BuyerAddress>();
			if(ud.isValid(ua)) {
				ud.insertAccount(ua);              //顺序和下一行反了
				bd.insertInfo(bi);
				UserGroup ug = new UserGroup(ua.getU_act(), "buyer");
				ud.insertGroup(ug);
				aba.add(bd.insertAddress(bad));
				bi.setBuyerAddress(aba);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	
}
