package com.dao.merchandise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.util.util.Search;
import com.vo.MGenre;
import com.vo.MPicture;
import com.vo.Merchandise;
import com.vo.PriceLog;
import com.vo.StockLog;

public class MerchandiseDI implements MerchandiseD {

	
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
	
	
	public Merchandise insertMerchan(Merchandise m)throws SQLException{
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO merchandise(sh_id,m_name,m_intro,m_status) VALUES(?,?,?,1)";
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, m.getSh_id());
			ps.setString(2, m.getM_name());
			ps.setString(3, m.getM_intro());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				m.setM_id(id);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return m;
	}
	
	
	
	public Merchandise selectMPicture(Merchandise m)throws SQLException{
		Merchandise new_m = m;
		ArrayList<MPicture> am = new ArrayList<MPicture>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from mpicture where m_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, m.getM_id());
			rs = ps.executeQuery();
			while(rs.next()) {
				MPicture p = new MPicture(rs.getInt(1),rs.getString(2),rs.getInt(3)); //这里存在错误，写成了rs.getString(1),rs.getInt(2)
				am.add(p);
			}
			new_m.setmPicture(am);;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return new_m;
	}
	
	
	
	public Merchandise selectPriceLog(Merchandise m)throws SQLException{
		Merchandise new_m = m;
		ArrayList<PriceLog> ap = new ArrayList<PriceLog>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from pricelog where m_id = ? ORDER BY pl_date DESC";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, m.getM_id());
			rs = ps.executeQuery();
			while(rs.next()) {
				PriceLog p = new PriceLog(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
				ap.add(p);
			}
			new_m.setPriceLog(ap);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return new_m;
	}
	
	
	
	public Merchandise selectStockLog(Merchandise m)throws SQLException{
		Merchandise new_m = m;
		ArrayList<StockLog> as = new ArrayList<StockLog>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from stocklog where m_id = ? ORDER BY sl_date DESC";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, m.getM_id());
			rs = ps.executeQuery();
			while(rs.next()) {
				StockLog sl = new StockLog(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
				as.add(sl);
			}
			new_m.setStockLog(as);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return new_m;
	}
	
	
	
	public Merchandise selectMGenre(Merchandise m)throws SQLException{
		Merchandise new_m = m;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from mgenre where m_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, m.getM_id());
			rs = ps.executeQuery();
			if(rs.next()) {
				MGenre mg = new MGenre(rs.getInt(1),rs.getString(2),rs.getString(3));
				new_m.setmGenre(mg);
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return new_m;
	}
	
	
	
	public Merchandise selectMerchan(Merchandise m)throws SQLException{
		Merchandise new_m = m;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from merchandise where m_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, m.getM_id());
			rs = ps.executeQuery();
			if(rs.next()) {
				new_m = new Merchandise(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return new_m;
	}
	
	
	
	public ArrayList<Merchandise> selectAllMerchanStatus()throws SQLException{
		ArrayList<Merchandise> l = new ArrayList<Merchandise>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			String sql = "SELECT * FROM merchandise where m_status = 1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Merchandise m = new Merchandise(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				l.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();		
		}
		return l;
	}
	
	
	public ArrayList<Merchandise> selectMerchanLike(String words)throws SQLException{
		ArrayList<Merchandise> l = new ArrayList<Merchandise>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			String sql = "SELECT m.m_id FROM merchandise m INNER JOIN mgenre g ON m.m_id = g.m_id WHERE (m_intro LIKE ? OR m_name LIKE ? OR genre1 LIKE ? OR genre2 LIKE ?) AND m_status = 1";
			ps = conn.prepareStatement(sql);
			Search s = new Search();
			String w = s.getKeyWords(words);
			ps.setString(1, w);
			ps.setString(2, w);
			ps.setString(3, w);
			ps.setString(4, w);
			rs = ps.executeQuery();
			while(rs.next()) {
				Merchandise m = new Merchandise(rs.getInt(1));
				l.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();		
		}
		return l;
	}
	
	
	
	public boolean updateStatus(Merchandise m,int status)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "UPDATE merchandise SET m_status = ? WHERE m_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, m.getM_id());
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
	
	
	
	public ArrayList<Merchandise> selectAllMerchan()throws SQLException{
		ArrayList<Merchandise> l = new ArrayList<Merchandise>();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			String sql = "SELECT * FROM merchandise";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Merchandise m = new Merchandise(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				l.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();		
		}
		return l;
	}
}
