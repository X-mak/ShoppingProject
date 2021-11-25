package com.util.view;

import java.util.ArrayList;
import java.util.Iterator;

import com.dao.users.BuyerDao;
import com.dao.users.BuyerDaoImpl;
import com.util.util.GetFull;
import com.vo.BuyerInfo;

public class BuyerView implements BuyerViewUtil {

	public ArrayList<BuyerInfo> showAllBuyers(){
		ArrayList<BuyerInfo> ab1 = new ArrayList<BuyerInfo>();
		ArrayList<BuyerInfo> ab2 = new ArrayList<BuyerInfo>();
		BuyerDao bd = new BuyerDaoImpl();
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
