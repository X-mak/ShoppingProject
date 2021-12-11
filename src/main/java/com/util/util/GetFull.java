package com.util.util;

import com.dao.merchandise.MerchandiseDao;
import com.dao.merchandise.MerchandiseDaoImpl;
import com.dao.orders.OrdersDao;
import com.dao.orders.OrdersDaoImpl;
import com.dao.users.BuyerDao;
import com.dao.users.BuyerDaoImpl;
import com.dao.users.UserDao;
import com.dao.users.UserDaoImpl;
import com.vo.BuyerInfo;
import com.vo.Merchandise;
import com.vo.Orders;
import com.vo.UserAccount;
import com.vo.UserGroup;

public class GetFull implements GetFullUtil{

	public Merchandise getAllMerchan(Merchandise m) {
		MerchandiseDao md = new MerchandiseDaoImpl();
		Merchandise new_m = m;
		try {
			new_m = md.selectMerchan(new_m);
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
		OrdersDao od = new OrdersDaoImpl();
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
	
	
	public BuyerInfo getAllBuyer(BuyerInfo bi) {
		BuyerDao bd = new BuyerDaoImpl();
		BuyerInfo new_bi = bi;
		try {
			new_bi = bd.selectAddress(bi);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new_bi;
	}
	
	
	public UserAccount getAllUser(UserAccount ua) {
		UserDao ud = new UserDaoImpl();
		UserAccount new_ua = ua;
		try {
			UserGroup ug = ud.selectGroup(new_ua);
			new_ua.setUserGroup(ug);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new_ua;
	}
}
