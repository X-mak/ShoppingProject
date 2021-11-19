package com.dao.users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.vo.BuyerAccount;
import com.vo.BuyerAddress;
import com.vo.BuyerInfo;

public class BuyerDI implements BuyerD {

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
	
	
	
	public boolean selectAccount(BuyerAccount ba)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from buyeraccount where BINARY b_act = ? and BINARY b_pwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ba.getB_act());
			ps.setString(2, ba.getB_pwd());
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
	
	
	
	
	public boolean selectAct(BuyerAccount ba)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from buyeraccount where BINARY b_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ba.getB_act());
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
	
	
	
	
	public boolean updatePwd(BuyerAccount ba,String pwd)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "UPDATE buyeraccount SET b_pwd = ? WHERE BINARY b_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setString(2, ba.getB_act());
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
	
	
	
	
	public BuyerInfo selectAddress(BuyerInfo bi)throws SQLException{
		BuyerInfo new_b = bi;
		ArrayList<BuyerAddress> ab = new ArrayList<BuyerAddress>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from buyeraddress where BINARY b_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bi.getB_act());
			rs = ps.executeQuery();
			while(rs.next()) {
				BuyerAddress ba = new BuyerAddress(rs.getInt(1),rs.getString(2),rs.getString(3));
				ab.add(ba);
			}
			new_b.setBuyerAddress(ab);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return new_b;
	}
	
	
	
	
	public BuyerInfo selectAccount(BuyerInfo bi)throws SQLException{
		BuyerInfo new_b = bi;
		BuyerAccount ba = null;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from buyeraccount where BINARY b_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bi.getB_act());
			rs = ps.executeQuery();
			if(rs.next()) {
				ba = new BuyerAccount(rs.getString(1),rs.getString(2));
			}
			new_b.setBuyerAccount(ba);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return new_b;
	}
	
	
	
	
	public boolean insertAccount(BuyerAccount ba)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "INSERT INTO buyeraccount VALUES(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,ba.getB_act() );
			ps.setString(2, ba.getB_pwd());
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
	
	
	
	
	public boolean insertInfo(BuyerInfo bi)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "INSERT INTO buyerinfo VALUES(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,bi.getB_act());
			ps.setInt(2, bi.getB_tele());
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
	
	
	
	
	public BuyerAddress insertAddress(BuyerAddress ba)throws SQLException{
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO buyeraddress(b_act,b_ads)VALUES(?,?)";
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,ba.getB_act());
			ps.setString(2, ba.getB_ads());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				ba.setBa_id(id);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return ba;
	}
	
	
	
	
	public ArrayList<BuyerInfo> selectAllInfo()throws SQLException{
		ArrayList<BuyerInfo> ab = new ArrayList<BuyerInfo>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from buyerinfo";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BuyerInfo bi = new BuyerInfo(rs.getString(1),rs.getInt(2));
				ab.add(bi);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return ab;
	}
	
	
	
	
	public boolean updateInfo(BuyerInfo bi)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "UPDATE buyerinfo SET b_tele = ? WHERE BINARY b_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bi.getB_tele());
			ps.setString(2, bi.getB_act());
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
	
	
	
	public boolean updateAddress(BuyerAddress ba)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "UPDATE buyeraddress SET b_ads = ? WHERE BINARY b_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ba.getB_ads());
			ps.setString(2, ba.getB_act());
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
