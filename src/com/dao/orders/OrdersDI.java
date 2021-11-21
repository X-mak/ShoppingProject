package com.dao.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.util.util.GetFull;
import com.vo.BuyerInfo;
import com.vo.Merchandise;
import com.vo.Orders;

public class OrdersDI implements OrdersD {

	
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
	
	
	public Orders insertOrders(Orders o)throws SQLException{
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO orders VALUES(null,?,?,?,0,?)";
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, o.getM_id());
			ps.setString(2, o.getB_act());
			ps.setInt(3, o.getSl_id());
			ps.setInt(4, o.getO_num());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				o.setO_id(id);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return o;
	}
	
	
	public boolean updateStatus(Orders o,int o_status)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "UPDATE orders SET o_status = ? WHERE o_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, o_status);
			ps.setInt(2, o.getO_id());
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
	
	
	
	public boolean deleteOrders(Orders o)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "DELETE FROM orders WHERE o_id = ?";
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
	
	
	
	public Orders selectBuyerInfo(Orders o)throws SQLException{
		Orders new_o = o;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			String sql = "SELECT * FROM buyerinfo WHERE b_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, o.getB_act());
			rs = ps.executeQuery();
			if(rs.next()) {
				BuyerInfo bi = new BuyerInfo(rs.getString(1),rs.getInt(2));
				new_o.setBuyerInfo(bi);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();		
		}
		return new_o;
	}
	
	
	
	public Orders selectMerchandise(Orders o)throws SQLException{
		Orders new_o = o;
		GetFull gf = new GetFull();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			String sql = "SELECT * FROM merchandise WHERE m_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, o.getM_id());
			rs = ps.executeQuery();
			if(rs.next()) {
				Merchandise m = new Merchandise(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
				m = gf.getAllMerchan(m);
				new_o.setMerchandise(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();		
		}
		return new_o;
	}
	
	
	
	public Orders selectOrdersById(int o_id)throws SQLException{
		Orders new_o = null;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			String sql = "SELECT * FROM orders WHERE o_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, o_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				new_o = new Orders(o_id,rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();		
		}
		return new_o;
	}
	
	
	
	public ArrayList<Orders> selectByBuyerStatus(String b_act,int o_status)throws SQLException{
		ArrayList<Orders> ao = new ArrayList<Orders>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			String sql = "SELECT * FROM orders WHERE b_act = ? AND o_status = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, b_act);
			ps.setInt(2, o_status);
			rs = ps.executeQuery();
			while(rs.next()) {
				Orders o = new Orders(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
				ao.add(o);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();		
		}
		return ao;
	}
	
	
	
	public ArrayList<Orders> selectOrders()throws SQLException{
		ArrayList<Orders> ao = new ArrayList<Orders>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			String sql = "SELECT * FROM orders WHERE o_status = 0 OR o_status = 1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Orders o = new Orders(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
				ao.add(o);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();		
		}
		return ao;
	}
	
	
	public ArrayList<Orders> selectAllOrders()throws SQLException{
		ArrayList<Orders> ao = new ArrayList<Orders>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			String sql = "SELECT * FROM orders";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Orders o = new Orders(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
				ao.add(o);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();		
		}
		return ao;
	}
	
	
	public ArrayList<Orders> selectByAct(String b_act)throws SQLException{
		ArrayList<Orders> ao = new ArrayList<Orders>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			String sql = "SELECT * FROM orders WHERE b_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, b_act);
			rs = ps.executeQuery();
			while(rs.next()) {
				Orders o = new Orders(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
				ao.add(o);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();		
		}
		return ao;
	}
	
	
	
}
