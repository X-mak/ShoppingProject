package com.dao.merchandise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.vo.Orders;
import com.vo.StockLog;

public class StockLogDI implements StockLogD {

	
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
	
	
	public StockLog insertLog(StockLog sl)throws SQLException{
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO stocklog (m_id,sl_num,sl_date) VALUES(?,?,?)";
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, sl.getM_id());
			ps.setInt(2, sl.getSl_num());
			ps.setString(3, sl.getSl_date());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				sl.setSl_id(id);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return sl;
	}
	
	
	public boolean deleteLog(Orders o)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "DELETE from stocklog where o_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, o.getO_id());
			rs = ps.executeUpdate();
			if(rs != 0)
				flag = true;		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
		}	
		return flag;
	}
	
	
	public boolean updateLog(StockLog sl)throws SQLException{
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		boolean flag = false;
		try {
			String sql = "UPDATE stocklog SET o_id = ? WHERE sl_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sl.getO_id());
			ps.setInt(2, sl.getSl_id());
			ps.executeUpdate();
			if(rs !=  0) {
				flag = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
		}	
		return flag;
	}
}
