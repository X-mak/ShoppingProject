package com.util.management;

import com.vo.Orders;

public interface OrdersManageUtil {

	
	public Orders havaOrder(int m_id,String b_act,int o_num);
	
	
	public boolean sellerChooseBuyer(int o_id);
	
	
	public boolean finshDeal(int o_id);
	
	
	public boolean deleteOrder(int o_id);
	
	
}
