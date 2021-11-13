package com.util.view;

import java.util.ArrayList;
import java.util.Iterator;

import com.dao.orders.OrdersD;
import com.dao.orders.OrdersDI;
import com.vo.Orders;

public class OrdersView implements OrdersViewUtil {

	
	public ArrayList<Orders> getBuyerOrders(String b_act){
		ArrayList<Orders> ao1 = new ArrayList<Orders>();
		ArrayList<Orders> ao2 = new ArrayList<Orders>();
		OrdersD od = new OrdersDI();
		try {
			ao1 = od.selectByAct(b_act);
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
	
	
	public ArrayList<Orders> showBuyerHistory(String b_act){
		ArrayList<Orders> ao1 = new ArrayList<Orders>();
		ArrayList<Orders> ao2 = new ArrayList<Orders>();
		OrdersD od = new OrdersDI();
		try {
			ao1 = od.selectByBuyerStatus(b_act, 2);
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
