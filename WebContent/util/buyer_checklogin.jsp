<%@page import="com.util.authentication.UserAuthentic"%>
<%@page import="com.util.authentication.UserAuthenticaUtil"%>
<%@page import="com.vo.UserAccount"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String bpath = request.getContextPath();
String bbasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+bpath+"/";
UserAccount buyer = (UserAccount)(session.getAttribute("buyeruser"));
UserAuthenticaUtil userAuthentic = new UserAuthentic();
		if(!userAuthentic.checkLogin(buyer).equals("buyer")){
			response.sendRedirect(bbasePath+"authentication/buyer_login/buyer_login.jsp");
			return;
		}
%>
</body>
</html>