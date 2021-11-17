package com.util.util;

import com.vo.BuyerInfo;
import com.vo.Merchandise;
import com.vo.Orders;

public interface GetFullUtil {

	public Merchandise getAllMerchan(Merchandise m);
	
	
	public Orders getAllOrders(Orders o);
	
	
	public BuyerInfo getAllBuyer(BuyerInfo bi); 
	
}
