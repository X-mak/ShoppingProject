package com.util.view;

import java.util.ArrayList;

import com.dao.buyer.BuyerD;
import com.dao.buyer.BuyerDI;
import com.vo.BuyerInfo;

public class BuyerView implements BuyerViewUtil {

	public ArrayList<BuyerInfo> showAllBuyers(){
		ArrayList<BuyerInfo> ab = new ArrayList<BuyerInfo>();
		BuyerD bd = new BuyerDI();
		try {
			ab = bd.selectAllInfo();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
	
	
}
