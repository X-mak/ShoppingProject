package com.util.util;

import com.dao.merchandise.MerchandiseD;
import com.dao.merchandise.MerchandiseDI;
import com.dao.orders.OrdersD;
import com.dao.orders.OrdersDI;
import com.vo.Merchandise;
import com.vo.Orders;

public class GetFull implements GetFullUtil{

	public Merchandise getAllMerchan(Merchandise m) {
		MerchandiseD md = new MerchandiseDI();
		Merchandise new_m = m;
		try {
			new_m = md.selectMerchan(m.getM_id());
			new_m = md.selectMGenre(new_m);
			new_m = md.selectMPicture(new_m);
			new_m = md.selectPriceLog(new_m);
			new_m = md.selectStockLog(new_m);
			new_m.setM_price(new_m.getPriceLog().get(0).getPl_price());
			new_m.setM_num(new_m.getStockLog().get(0).getSl_num());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new_m;
	}
	
	
	public Orders getAllOrders(Orders o) {
		OrdersD od = new OrdersDI();
		Orders new_o = o;
		try {
			new_o = od.selectOrdersById(o.getO_id());
			new_o = od.selectBuyerInfo(new_o);
			new_o = od.selectMerchandise(new_o);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new_o;
	}
}
