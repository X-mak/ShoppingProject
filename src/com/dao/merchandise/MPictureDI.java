package com.dao.merchandise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.vo.MPicture;

public class MPictureDI implements MPictureD {

	
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
	
	
	
	public MPicture insertPicture(MPicture p)throws SQLException{
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs =null;
		MPicture new_p = p;
		try {
			String sql = "INSERT INTO mpicture VALUES(null,?,?)";
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,p.getP_ads());
			ps.setInt(2, p.getM_id());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				new_p.setP_id(id);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return new_p;
	}
	
	
}
