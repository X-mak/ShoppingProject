package com.dao.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.util.BaseDao;
import com.vo.SellerInfo;

public class SellerDaoImpl extends BaseDao implements SellerDao {
	
	public boolean insertInfo(SellerInfo si)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "INSERT INTO sellerinfo VALUES(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,si.getU_act());
			ps.setInt(2, si.getS_status());
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
