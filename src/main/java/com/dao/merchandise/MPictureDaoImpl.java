package com.dao.merchandise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.util.util.BaseDao;
import com.vo.MPicture;

public class MPictureDaoImpl extends BaseDao implements MPictureDao {

	
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
