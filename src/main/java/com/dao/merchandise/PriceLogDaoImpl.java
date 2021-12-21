package com.dao.merchandise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.util.util.BaseDao;
import com.vo.PriceLog;

public class PriceLogDaoImpl extends BaseDao implements PriceLogDao {	
	
	public PriceLog insertLog(PriceLog pl)throws SQLException{
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO pricelog (m_id,pl_price,pl_date)VALUES(?,?,?)";
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, pl.getM_id());
			ps.setDouble(2, pl.getPl_price());
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
