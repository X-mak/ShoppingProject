package com.util.authentication;

import com.vo.BuyerInfo;

public interface BuyerAuthenticUtil {
	
	public boolean changePwd(String b_act,String old_pwd,String new_pwd);
	
	
	public BuyerInfo changeInfo(String b_act,int b_tele,String b_ads); 
	
	
	public BuyerInfo addBuyer(String act,String pwd,String ads,int tele);
	
	
	public boolean checkLogin(String act,String pwd);

}
