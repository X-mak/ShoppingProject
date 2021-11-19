package com.dao.merchandise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vo.MGenre;

public class MGenreDI implements MGenreD {

	
	
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
	
	
	
	public boolean updateGenre(MGenre mg)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "UPDATE mgenre SET genre1 = ? AND genre2 = ? WHERE m_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mg.getGenre1());
			ps.setString(2, mg.getGenre2());
			ps.setInt(3, mg.getM_id());
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
	
	
	
	public MGenre insertGenre(MGenre mg)throws SQLException{
		MGenre new_mg = null;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "insert mgenre(m_id,genre1,genre2) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mg.getM_id());
			ps.setString(2, mg.getGenre1());
			ps.setString(3, mg.getGenre2());
			rs = ps.executeUpdate();
			if(rs != 0)
				new_mg = mg;		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
		}	
		return new_mg;
	}
}
