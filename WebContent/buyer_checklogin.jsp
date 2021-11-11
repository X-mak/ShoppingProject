<%@page import="com.vo.BuyerAccount"%>
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
BuyerAccount buyer = (BuyerAccount)(session.getAttribute("buyeruser"));
		if(buyer==null){
			response.sendRedirect(bbasePath+"buyer_login/buyer_login.jsp");
			return;
		}
%>
</body>
</html>