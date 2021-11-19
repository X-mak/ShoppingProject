package com.dao.merchandise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.vo.PriceLog;

public class PriceLogDI implements PriceLogD {

	
	
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
	
	
	public PriceLog insertLog(PriceLog pl)throws SQLException{
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO pricelog (m_id,pl_price,pl_date)VALUES(?,?,?)";
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, pl.getM_id());
			ps.setInt(2, pl.getPl_price());
			ps.setString(3, pl.getPl_date());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				pl.setPl_id(id);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return pl;
	}
}
