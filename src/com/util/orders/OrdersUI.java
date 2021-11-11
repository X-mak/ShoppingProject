package com.util.orders;

import java.util.ArrayList;
import java.util.Iterator;

import com.dao.merchandise.MerchandiseD;
import com.dao.merchandise.MerchandiseDI;
import com.dao.orders.OrdersD;
import com.dao.orders.OrdersDI;
import com.vo.Merchandise;
import com.vo.Orders;

public class OrdersUI implements OrdersUtil {

	
	public Orders havaOrder(int m_id,String b_act,int o_num) {
		int i = 0;
		MerchandiseD md = new MerchandiseDI();
		Orders o = null;
		OrdersD od = new OrdersDI();
		try {
			Merchandise m = md.selectMerchan(m_id);
			m = md.selectStockLog(m);
			int num = m.getStockLog().get(0).getSl_num();
			i = num - o_num;
			if(i >= 0) {
				o = new Orders(m_id,b_act,0,o_num);
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
	
	
	
	public ArrayList<Orders> showAllOrders(){
		ArrayList<Orders> ao1 = new ArrayList<Orders>();
		ArrayList<Orders> ao2 = new ArrayList<Orders>();
		OrdersD od = new OrdersDI();
		try {
			ao1 = od.selectOrders();
			Iterator<Orders> io = ao1.iterator();
			while(io.hasNext()) {
				Orders o = io.next();
				o = od.selectBuyerInfo(o);
				o = od.selectMerchandise(o);
				ao2.add(o);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ao2;
	}
}
