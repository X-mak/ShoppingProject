package com.dao.merchandise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.util.BaseDao;
import com.vo.MGenre;

public class MGenreDaoImpl extends BaseDao implements MGenreDao {

	
	public boolean updateGenre(MGenre mg)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "UPDATE mgenre SET genre1 = ? , genre2 = ? WHERE m_id = ?";
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
			String sql = "insert mgenre(m_id) values (?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mg.getM_id());
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
