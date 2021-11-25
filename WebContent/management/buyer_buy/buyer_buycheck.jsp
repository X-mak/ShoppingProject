<%@page import="com.vo.UserAccount"%>
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
		UserAccount buyer = (UserAccount)(session.getAttribute("buyeruser"));
		String m_id = (String)request.getParameter("id");
		String buy_num = (String) request.getParameter("buynum");
		session.setAttribute("m_id", m_id);
		session.setAttribute("buynum",buy_num);
		if(!buyer.getUserGroup().getU_role().equals("buyer")){
			response.sendRedirect("../../authentication/seller_login/seller_login.jsp");
		}else{
			response.sendRedirect("../../buymerchandiseServlet");
		}
%>
</body>
</html>