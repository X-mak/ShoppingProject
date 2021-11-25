package com.dao.shop;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.SellerInfo;
import com.vo.Shop;

/**
 * @author 徐敏阳
 *
 * 店铺相关的连接数据库的接口
 */
public interface ShopDao {

	
	/**
	 * 用于获取某个卖家的所有店铺
	 * @param 卖家信息SellerInfo,需要包括u_act
	 * @return 成功则返回包含某个卖家所有店铺Shop的数组,失败则返回一个空数组
	 * @throws SQLException
	 */
	public ArrayList<Shop> selectShops(SellerInfo si)throws SQLException;
	
}
