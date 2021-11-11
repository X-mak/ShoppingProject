package com.util.buyer;

import java.util.ArrayList;

import com.vo.BuyerInfo;
import com.vo.Orders;

public interface BuyerUtil {

	
	public boolean changePwd(String b_act,String old_pwd,String new_pwd);
	
	
	public ArrayList<Orders> getBuyerOrders(String b_act);
	
	
	public BuyerInfo changeInfo(String b_act,int b_tele,String b_ads); 
	
}
