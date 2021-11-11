package com.util.seller;

import java.util.ArrayList;

import com.vo.BuyerInfo;
import com.vo.MPicture;
import com.vo.Merchandise;
import com.vo.Orders;
import com.vo.PriceLog;
import com.vo.StockLog;

public interface SellerUtil {

	
	public Merchandise addMerchan(Merchandise m,ArrayList<MPicture> am,int price,int num,String genre1);
	
	
	public Merchandise getFull(int m_id);
	
	
	public boolean changePwd(String act,String old_pwd,String new_pwd);
	
	
	public ArrayList<BuyerInfo> showAllBuyers();
	
	
	public ArrayList<Orders> showBuyerHistory(String b_act);
	
	
	public ArrayList<Orders> showSellerHistory();
	
	
	public ArrayList<Merchandise> showAllMerchan();
	
}
