package com.util.buyer;

import java.util.ArrayList;
import java.util.Iterator;

import com.dao.buyer.BuyerD;
import com.dao.buyer.BuyerDI;
import com.dao.orders.OrdersD;
import com.dao.orders.OrdersDI;
import com.vo.BuyerAccount;
import com.vo.BuyerAddress;
import com.vo.BuyerInfo;
import com.vo.Orders;

public class BuyerUI implements BuyerUtil {

	
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
	
	
	public ArrayList<Orders> getBuyerOrders(String b_act){
		ArrayList<Orders> ao1 = new ArrayList<Orders>();
		ArrayList<Orders> ao2 = new ArrayList<Orders>();
		OrdersD od = new OrdersDI();
		try {
			ao1 = od.selectByAct(b_act);
			Iterator<Orders> io = ao1.iterator();
			while(io.hasNext()) {
				Orders o = io.next();
				o = od.selectBuyerInfo(o);
				o = od.selectMerchandise(o);
				ao2.add(o);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ao2;
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
}
