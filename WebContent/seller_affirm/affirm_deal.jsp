<%@page import="com.vo.Merchandise"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@include file="../seller_login/navigation.jsp" %>
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/seller_affirm_interface2.css">
</head>
<body>
<% 
	Merchandise m = (Merchandise)(session.getAttribute("merchandise"));
	String successPath = basePath + "affirmsuccessServlet";
	String failPath = basePath + "affirmfailServlet";
%>
<div id = "main">
	<div>
            <a href= <%=successPath %>>交易成功</a>
            <a href= <%=failPath %>>交易失败</a>
    </div>
</div>
</body>
</html>