package com.util.authentication;

public interface SellerAuthenticUtil {

	
	public String checkLogin(String act,String pwd);
	
	
	public boolean changePwd(String act,String old_pwd,String new_pwd);
	
}
