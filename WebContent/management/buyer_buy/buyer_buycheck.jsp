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
		BuyerAccount buyer = (BuyerAccount)(session.getAttribute("buyeruser"));
		int m_id = Integer.parseInt((String)request.getParameter("id"));
		String buy_num = (String) request.getParameter("buynum");
		session.setAttribute("m_id", m_id);
		session.setAttribute("buynum",buy_num);
		if(buyer==null){
			response.sendRedirect("authentication/buyer_login/buyer_login.jsp");
		}else{
			response.sendRedirect("../../buymerchandiseServlet");
		}
%>
</body>
</html>