package com.util.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
	public boolean nameiscorrect(String charaString){//检查用户名是否正确
		String regEx = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$" ;
	    Pattern p = Pattern.compile(regEx);
	    Matcher m = p.matcher(charaString);
	    if(m.find()) {
	    	return true;
	    	}
	    else
	    	return false;
	    }//正则表达式验证用户名是否为英文加数字
	
	public boolean pwdiscorrect(String pwd){//正则表达式检查密码是否正确
		int len = pwd.length();
		String regEx = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$" ;
	    Pattern p = Pattern.compile(regEx);
	    Matcher m = p.matcher(pwd);
	    int n=0;
	    if(m.find()) {
	    	n++;
	    	}
	    if(len>6&&len<12) {
	    	n++;
	    }
	    if(n==2) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	   }
	
	public boolean isNum(String str) {
		String regEx = "[0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		int n = 0;
		while(m.find())
			n += 1;
		if(n == str.length() && n == 11)
			return true;
		else 
			return false;
	}
	
	public boolean check_phone(String phone) {
		String regEx = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$" ;
	    Pattern p = Pattern.compile(regEx);
	    Matcher m = p.matcher(phone);
	    if(m.find()) {
	    	return true;
	    	}
	    else
	    	return false;
	    }//对手机号码的检测
	
	public boolean check_price(String price) {
		String regEx = "\\d\\.\\d*|[1-9]\\d*|\\d*\\.\\d*|\\d" ;
	    Pattern p = Pattern.compile(regEx);
	    Matcher m = p.matcher(price);
	    if(m.find()) {
	    	return true;
	    	}
	    else
	    	return false;
	    }//对价格检测
	
	public boolean check_num(String num) {
		String regEx = "\\d{5}" ;
	    Pattern p = Pattern.compile(regEx);
	    Matcher m = p.matcher(num);
	    if(m.find()) {
	    	return true;
	    	}
	    else
	    	return false;
	    }//对商品数量检测
}
