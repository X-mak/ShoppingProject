package com.util.management;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.merchandise.MerchandiseDao;
import com.dao.merchandise.MerchandiseDaoImpl;
import com.dao.merchandise.StockLogDao;
import com.dao.merchandise.StockLogDaoImpl;
import com.dao.orders.OrdersDao;
import com.dao.orders.OrdersDaoImpl;
import com.util.util.GetFull;
import com.vo.Merchandise;
import com.vo.Orders;
import com.vo.StockLog;

public class OrdersManage implements OrdersManageUtil {

	
	public Orders havaOrder(int m_id,String b_act,int o_num) {
		int i = 0;
		MerchandiseDao md = new MerchandiseDaoImpl();
		StockLogDao sld = new StockLogDaoImpl();
		Orders o = null;
		OrdersDao od = new OrdersDaoImpl();
		try {
			Merchandise m = md.selectMerchan(new Merchandise(m_id));
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
				sl.setO_id(o.getO_id());
				sld.updateLog(sl);
				if(i == 0) {
					md.updateStatus(m, 0);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
	}
	
	
	public boolean sellerChooseBuyer(int o_id) {
		boolean flag = false;
		OrdersDao od = new OrdersDaoImpl();
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
		OrdersDao od = new OrdersDaoImpl();
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
		OrdersDao od = new OrdersDaoImpl();
		StockLogDao slg = new StockLogDaoImpl();
		GetFull gf = new GetFull();
		try {
			Orders o = new Orders(o_id);
			o = gf.getAllOrders(o);
			StockLog sl = new StockLog();
			sl.setSl_id(o.getSl_id());
			sl.setO_id(0);
			slg.updateLog(sl);
			if( od.deleteOrders(o) && slg.deleteLog(new Orders(0))) {
				flag = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
}
