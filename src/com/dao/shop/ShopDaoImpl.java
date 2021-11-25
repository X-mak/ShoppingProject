package com.dao.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.util.BaseDao;
import com.vo.SellerInfo;
import com.vo.Shop;

public class ShopDaoImpl extends BaseDao implements ShopDao {


	
	public ArrayList<Shop> selectShops(SellerInfo si)throws SQLException{
		ArrayList<Shop> as = new ArrayList<Shop>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			String sql = "SELECT * FROM shop WHERE u_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, si.getU_act());
			rs = ps.executeQuery();
			while(rs.next()) {
				Shop s = new Shop(rs.getInt(1),rs.getString(2));
				as.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();		
		}
		return as;
	}
	
}
