package com.dao.shop;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.SellerInfo;
import com.vo.Shop;

public interface ShopD {

	
	public ArrayList<Shop> selectShops(SellerInfo si)throws SQLException;
	
}
