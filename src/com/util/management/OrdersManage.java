package com.util.management;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.merchandise.MerchandiseD;
import com.dao.merchandise.MerchandiseDI;
import com.dao.merchaninfo.StockLogD;
import com.dao.merchaninfo.StockLogDI;
import com.dao.orders.OrdersD;
import com.dao.orders.OrdersDI;
import com.vo.Merchandise;
import com.vo.Orders;
import com.vo.StockLog;

public class OrdersManage implements OrdersManageUtil {

	
	public Orders havaOrder(int m_id,String b_act,int o_num) {
		int i = 0;
		MerchandiseD md = new MerchandiseDI();
		StockLogD sld = new StockLogDI();
		Orders o = null;
		OrdersD od = new OrdersDI();
		try {
			Merchandise m = md.selectMerchan(m_id);
			m = md.selectStockLog(m);
			int num = m.getStockLog().get(0).getSl_num();
			i = num - o_num;
			if(i >= 0) {
				Date date = new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = df.format(date);
				StockLog sl = new StockLog(m_id,i,time);
				sl = sld.insertLog(sl);
				o = new Orders(m_id,b_act,sl.getSl_id(),0,o_num);
				o = od.insertOrders(o);
				o = od.selectBuyerInfo(o);
				o = od.selectMerchandise(o);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
	}
	
	
	public boolean sellerChooseBuyer(int o_id) {
		boolean flag = false;
		OrdersD od = new OrdersDI();
		try {
			Orders o = new Orders(o_id);
			if(od.updateStatus(o, 1))
				flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public boolean finshDeal(int o_id) {
		boolean flag = false;
		OrdersD od = new OrdersDI();
		try {
			Orders o = new Orders(o_id);
			if(od.updateStatus(o, 2))
				flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public boolean deleteOrder(int o_id) {
		boolean flag = false;
		OrdersD od = new OrdersDI();
		StockLogD slg = new StockLogDI();
		try {
			Orders o = new Orders(o_id);
			if(od.deleteOrders(o) && slg.deleteLog(o_id)) {
				flag = true;
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
}
