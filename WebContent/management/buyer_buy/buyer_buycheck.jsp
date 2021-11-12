<%@page import="com.vo.BuyerAccount"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="../../util/getpath.jsp" %>
<body>
<%
		BuyerAccount buyer = (BuyerAccount)(session.getAttribute("buyer"));
		int m_id = Integer.parseInt((String)session.getAttribute("id"));
		if(buyer==null){
			response.sendRedirect("buyer_login.jsp");
		}else{
			response.sendRedirect("buymerchandiseServlet");
		}
%>
</body>
</html>