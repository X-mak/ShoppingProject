package com.util.index;

import java.util.ArrayList;

import com.vo.BuyerInfo;
import com.vo.Merchandise;

public interface IndexUtil {

	
	public BuyerInfo addBuyer(String act,String pwd,String ads,int tele);
	
	
	public ArrayList<Merchandise> showAllMerchanOnSale();
	
	
	public boolean checkLogin(String act,String pwd,String type);
	
}
