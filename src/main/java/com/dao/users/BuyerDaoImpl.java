package com.dao.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.util.util.BaseDao;
import com.vo.BuyerAddress;
import com.vo.BuyerInfo;

public class BuyerDaoImpl extends BaseDao implements BuyerDao {
	
	
	public BuyerInfo selectAddress(BuyerInfo bi)throws SQLException{
		BuyerInfo new_b = bi;
		ArrayList<BuyerAddress> ab = new ArrayList<BuyerAddress>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from buyeraddress where BINARY u_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bi.getU_act());
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
	
	
	
	public boolean insertInfo(BuyerInfo bi)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "INSERT INTO buyerinfo VALUES(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,bi.getU_act());
			ps.setString(2, bi.getB_tele());
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
			String sql = "INSERT INTO buyeraddress(u_act,b_ads)VALUES(?,?)";
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,ba.getU_act());
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
				BuyerInfo bi = new BuyerInfo(rs.getString(1),rs.getString(2));
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
			String sql = "UPDATE buyerinfo SET b_tele = ? WHERE BINARY u_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bi.getB_tele());
			ps.setString(2, bi.getU_act());
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
			String sql = "UPDATE buyeraddress SET b_ads = ? WHERE BINARY u_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ba.getB_ads());
			ps.setString(2, ba.getU_act());
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
