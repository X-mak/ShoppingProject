package com.dao.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.SellerInfo;
import com.vo.Shop;

public class ShopDI implements ShopD {

	
	public Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =  DriverManager.getConnection("jdbc:mysql://121.4.183.230:3306/onlineshoppinga?useUnicode=true&characterEncoding=utf-8&useSSL=false","root", "123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public ArrayList<Shop> selectShops(SellerInfo si)throws SQLException{
		ArrayList<Shop> as = new ArrayList<Shop>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			String sql = "SELECT * FROM shop WHERE s_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, si.getS_act());
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
