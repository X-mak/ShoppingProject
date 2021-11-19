package com.util.view;

import java.util.ArrayList;
import java.util.Iterator;

import com.dao.users.BuyerD;
import com.dao.users.BuyerDI;
import com.util.util.GetFull;
import com.vo.BuyerInfo;

public class BuyerView implements BuyerViewUtil {

	public ArrayList<BuyerInfo> showAllBuyers(){
		ArrayList<BuyerInfo> ab1 = new ArrayList<BuyerInfo>();
		ArrayList<BuyerInfo> ab2 = new ArrayList<BuyerInfo>();
		BuyerD bd = new BuyerDI();
		GetFull gf = new GetFull();
		try {
			ab1 = bd.selectAllInfo();
			Iterator<BuyerInfo> ib = ab1.iterator();
			while(ib.hasNext()) {
				BuyerInfo bi = ib.next();
				bi = gf.getAllBuyer(bi);
				ab2.add(bi);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ab2;
	}
	
	
}
