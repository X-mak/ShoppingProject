package com.dao.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.util.BaseDao;
import com.util.util.Encode;
import com.vo.UserAccount;
import com.vo.UserGroup;

public class UserDaoImpl extends BaseDao implements UserDao {

	public boolean selectAccount(UserAccount aa)throws SQLException {
		boolean flag = false;
		Encode encode = new Encode();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from useraccount where BINARY u_act = ? and BINARY u_pwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, aa.getU_act());
			ps.setString(2, encode.getSHA256StrJava(aa.getU_pwd()));
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
	
	
	public boolean updatePwd(UserAccount aa,String pwd)throws SQLException{
		boolean flag = false;
		Encode encode = new Encode();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "UPDATE adminaccount SET u_pwd = ? WHERE BINARY u_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, encode.getSHA256StrJava(pwd));
			ps.setString(2, aa.getU_act());
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
	
	
	public boolean insertAccount(UserAccount aa)throws SQLException{
		boolean flag = false;
		Encode encode = new Encode();
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "INSERT INTO useraccount VALUES(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,aa.getU_act());
			ps.setString(2, encode.getSHA256StrJava(aa.getU_pwd()));
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
	
	
	public boolean insertGroup(UserGroup up)throws SQLException{
		boolean flag = false;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			String sql = "INSERT INTO usergroup VALUES(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,up.getU_act());
			ps.setString(2, up.getU_role());
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
	
	
	public boolean isValid(UserAccount aa)throws SQLException{
		boolean flag = true;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from useraccount where BINARY u_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, aa.getU_act());
			rs = ps.executeQuery();
			if(rs.next())
				flag = false;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return flag;
	}
	
	
	public UserGroup selectGroup(UserAccount aa)throws SQLException{
		UserGroup ug = null;
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from usergroup where BINARY u_act = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, aa.getU_act());
			rs = ps.executeQuery();
			if(rs.next())
				ug = new UserGroup(rs.getString(1),rs.getString(2));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.close();
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		}	
		return ug;
	}
	
}
