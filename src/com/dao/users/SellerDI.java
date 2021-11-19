package com.dao.users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vo.SellerAccount;
import com.vo.SellerInfo;

public class SellerDI implements SellerD {

	
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
	
	
	
	public boolean selectAccount(SellerAccount sa)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from selleraccount where BINARY s_act = ? and BINARY s_pwd = ? and s_status = 1";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sa.getS_act());
			ps.setString(2, sa.getS_pwd());
			rs = ps.executeQuery();
			if(rs.next())
				flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return flag;
	}
	
	
	
	public boolean selectAct(SellerAccount sa)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from selleraccount where BINARY s_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sa.getS_act());
			rs = ps.executeQuery();
			if(rs.next())
				flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return flag;
	}
	
	
	
	public boolean updatePwd(SellerAccount sa,String pwd)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "UPDATE selleraccount SET s_pwd = ? WHERE BINARY s_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setString(2, sa.getS_act());
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
	
	
	
	public boolean insertAccount(SellerAccount sa)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "INSERT INTO selleraccount VALUES(?,?,1)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,sa.getS_act());
			ps.setString(2, sa.getS_pwd());
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
	
	
	
	public boolean insertInfo(SellerInfo si)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "INSERT INTO sellerinfo VALUES(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,si.getS_act());
			ps.setString(2, si.getA_act());
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
	
}
