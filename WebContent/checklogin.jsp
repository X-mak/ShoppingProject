<%@page import="com.vo.SellerAccount"%>
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
SellerAccount selleruser = (SellerAccount)(session.getAttribute("selleruser"));
		if(selleruser==null){
			response.sendRedirect(ibasePath+"seller_login/seller_login.jsp");
			return;
		}
%>
</body>
</html>