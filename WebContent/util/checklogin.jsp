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
String ipath = request.getContextPath();
String ibasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ipath+"/";
UserAccount selleruser = (UserAccount)(session.getAttribute("selleruser"));
		if(!selleruser.getUserGroup().getU_role().equals("seller")){
			response.sendRedirect(ibasePath+"authentication/seller_login/seller_login.jsp");
			return;
		}
%>
</body>
</html>